package geneticalgorithm;

import creatures.model.CreatureChromosome;
import geneticalgorithm.interfaces.IMutationManager;
import geneticalgorithm.interfaces.IScoreEvaluator;
import geneticalgorithm.model.Gene;
import simulation.model.SimulationResult;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainAlgorithm<T extends Gene> {

  private geneticalgorithm.interfaces.IPopulationCreator IPopulationCreator;
  private geneticalgorithm.interfaces.IMutationManager IMutationManager;
  private IScoreEvaluator scoreEvaluator;

  public MainAlgorithm(
      geneticalgorithm.interfaces.IPopulationCreator IPopulationCreator,
      IMutationManager IMutationManager,
      IScoreEvaluator scoreEvaluator) {
    this.IPopulationCreator = IPopulationCreator;
    this.IMutationManager = IMutationManager;
    this.scoreEvaluator = scoreEvaluator;
  }

  public SimulationResult getWholeHistoryBestCreature(
      int generations,
      int populationCount,
      double mutationRate,
      double crossoverRate,
      double topSurvivorsPercentage) {

    return getWholeHistoryBestGeneration(
            generations, populationCount, mutationRate, crossoverRate, topSurvivorsPercentage)
        .get(0);
  }

  public List<SimulationResult> getWholeHistoryBestGeneration(
      int generations,
      int populationCount,
      double mutationRate,
      double crossoverRate,
      double topSurvivorsPercentage) {

    List<CreatureChromosome> population = this.IPopulationCreator.newGeneration(populationCount);
    AlgorithmLogger.log("Generated first population.");

    return getNextGenerations(
        generations, mutationRate, crossoverRate, topSurvivorsPercentage, population);
  }

  public SimulationResult getNextGeneration(
      int generations,
      int populationCount,
      double mutationRate,
      double crossoverRate,
      double topSurvivorsPercentage,
      List<CreatureChromosome> population) {

    if (population == null || population.size() == 0) {
      population = this.IPopulationCreator.newGeneration(populationCount);
      AlgorithmLogger.log("Generated first population.");
      return new SimulationResult(
          population.get(0),
          population.get(population.size() / 2),
          population.get(population.size() - 1),
          population);
    }

    return getNextGenerations(
            generations, mutationRate, crossoverRate, topSurvivorsPercentage, population)
        .get(0);
  }

  private List<SimulationResult> getNextGenerations(
      int generations,
      double mutationRate,
      double crossoverRate,
      double topSurvivorsPercentage,
      List<CreatureChromosome> population) {
    CreatureChromosome bestCreature = null;
    CreatureChromosome averageCreature = null;
    CreatureChromosome worstCreature = null;

    List<SimulationResult> result = new ArrayList<>();
    for (int i = 0; i < generations; i++) {

      population.sort(Comparator.comparing(scoreEvaluator::evaluateChromosome).reversed());

      int initialPopulationCount = population.size();

      bestCreature = population.get(0);
      averageCreature = population.get(population.size() / 2);
      worstCreature = population.get(population.size() - 1);

      List<CreatureChromosome> survivingPopulation =
          IPopulationCreator.getCrossoverPool(population, scoreEvaluator, topSurvivorsPercentage);
      AlgorithmLogger.log("Generated surviving population for generation : " + i);

      List<CreatureChromosome> offSpring =
          IPopulationCreator.newGeneration(
              survivingPopulation, crossoverRate, scoreEvaluator, initialPopulationCount);

      AlgorithmLogger.log("Generated offSpring population for generation : " + i);

      population = IMutationManager.mutateGeneration(offSpring, mutationRate);

      AlgorithmLogger.log("Generated mutated population for generation : " + i);

      AlgorithmLogger.log("New generation size : " + population.size());

      population.sort(Comparator.comparing(scoreEvaluator::evaluateChromosome).reversed());

      result.add(new SimulationResult(bestCreature, averageCreature, worstCreature, population));

      if (scoreEvaluator.evaluateChromosome(population.get(0))
          > scoreEvaluator.evaluateChromosome(bestCreature)) {

        bestCreature = population.get(0);

      } else if (!population.contains(bestCreature)) {
        population.add(bestCreature);
      }
    }

    return result;
  }
}
