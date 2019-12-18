package geneticalgorithm;

import creatures.model.CreatureChromosome;
import geneticalgorithm.interfaces.IMutationManager;
import geneticalgorithm.interfaces.IScoreEvaluator;
import geneticalgorithm.model.Gene;

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

  public List<CreatureChromosome> getNextGeneration(
      int populationCount,
      double mutationRate,
      double crossoverRate,
      double topSurvivorsPercentage,
      double suddenDeathRate,
      List<CreatureChromosome> population) {

    // First round/generation.
    if (population == null || population.size() == 0) {
      population = this.IPopulationCreator.newGeneration(populationCount);
      AlgorithmLogger.log("Generated first population.");
      return population;
    }

    population.sort(Comparator.comparing(scoreEvaluator::evaluateChromosome).reversed());

    int initialPopulationCount = population.size();

    List<CreatureChromosome> survivingPopulation =
        IPopulationCreator.getCrossoverPool(population, scoreEvaluator, topSurvivorsPercentage,suddenDeathRate);
    AlgorithmLogger.log("Generated surviving population");

    List<CreatureChromosome> offSpring =
        IPopulationCreator.newGeneration(
            survivingPopulation, crossoverRate, scoreEvaluator, initialPopulationCount);

    AlgorithmLogger.log("Generated offspring population");

    population = IMutationManager.mutateGeneration(offSpring, mutationRate);

    AlgorithmLogger.log("Generated mutated population for generation");

    AlgorithmLogger.log("New generation size : " + population.size());

    population.sort(Comparator.comparing(scoreEvaluator::evaluateChromosome).reversed());

    return population;
  }
}
