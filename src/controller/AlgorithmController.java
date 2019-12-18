package controller;

import creatures.model.CreatureChromosome;
import creatures.model.CreatureGene;
import geneticalgorithm.AlgorithmStatisticsController;
import geneticalgorithm.MainAlgorithm;
import geneticalgorithm.interfaces.IMutationManager;
import geneticalgorithm.interfaces.IPopulationCreator;
import geneticalgorithm.interfaces.IScoreEvaluator;
import geneticalgorithm.model.GenerationMetaInformation;

import java.util.List;

public class AlgorithmController {

  private MainAlgorithm<CreatureGene> mainAlgorithm;
  private AlgorithmStatisticsController algorithmStatisticsController;

  public AlgorithmController(
      IPopulationCreator populationCreator,
      IScoreEvaluator scoreEvaluator,
      IMutationManager mutationManager) {
    this.mainAlgorithm = new MainAlgorithm<>(populationCreator, mutationManager, scoreEvaluator);
    this.algorithmStatisticsController = new AlgorithmStatisticsController(scoreEvaluator);
  }

  public List<CreatureChromosome> getNextGeneration(
      int populationCount,
      double mutationRate,
      double crossoverRate,
      double topSurvivorsPercentage,
      double suddenDeathRate,
      List<CreatureChromosome> population) {

    return mainAlgorithm.getNextGeneration(
        populationCount, mutationRate, crossoverRate, topSurvivorsPercentage,suddenDeathRate, population);
  }

  public GenerationMetaInformation getGenerationMetaInformation(
      int generationCount, List<CreatureChromosome> population) {

    return this.algorithmStatisticsController.getGenerationMetaInformation(
        generationCount, population);
  }
}
