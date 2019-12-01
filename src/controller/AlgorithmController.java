package controller;

import creatures.model.CreatureChromosome;
import creatures.model.CreatureGene;
import geneticalgorithm.MainAlgorithm;
import geneticalgorithm.interfaces.IMutationManager;
import geneticalgorithm.interfaces.IPopulationCreator;
import geneticalgorithm.interfaces.IScoreEvaluator;
import simulation.model.SimulationResult;

import java.util.ArrayList;
import java.util.List;

public class AlgorithmController {

  private MainAlgorithm<CreatureGene> mainAlgorithm;

  public AlgorithmController(
      IPopulationCreator populationCreator,
      IScoreEvaluator scoreEvaluator,
      IMutationManager mutationManager) {
    this.mainAlgorithm = new MainAlgorithm<>(populationCreator, mutationManager, scoreEvaluator);
  }

  public SimulationResult getNextGeneration(
      int generationPerClick,
      int populationCount,
      double mutationRate,
      double crossoverRate,
      double topSurvivorsPercentage,
      List<CreatureChromosome> population) {

    if (population == null || population.size() == 0) population = new ArrayList<>();

    SimulationResult simulationResult = null;
    for (int i = 0; i < generationPerClick; i++) {
      simulationResult =
          mainAlgorithm.getNextGeneration(
              1, populationCount, mutationRate, crossoverRate, topSurvivorsPercentage, population);
    }
    return simulationResult;
  }
}
