package geneticalgorithm;

import creatures.model.CreatureChromosome;
import geneticalgorithm.interfaces.IScoreEvaluator;
import geneticalgorithm.model.GenerationMetaInformation;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AlgorithmStatisticsController {

  private IScoreEvaluator scoreEvaluator;

  public AlgorithmStatisticsController(IScoreEvaluator scoreEvaluator) {
    this.scoreEvaluator = scoreEvaluator;
  }

  public GenerationMetaInformation getGenerationMetaInformation(
      int generationCount, List<CreatureChromosome> population) {

    if (population == null) return new GenerationMetaInformation();

    GenerationMetaInformation result = new GenerationMetaInformation();

    result.setPopulation(
        population.stream().filter(p -> p.getEnergy() > 0).collect(Collectors.toList()));

    result.setGenerationCount(generationCount);

    List<CreatureChromosome> populationCopy = new ArrayList<>(population);

    populationCopy.sort(Comparator.comparing(scoreEvaluator::evaluateChromosome));

    var latestResult = getHighestAverageLowestFromOrderedList(populationCopy);

    result.setBestCreature(latestResult.topCreature);
    result.setAverageCreature(populationCopy.get(population.size() / 2));
    result.setWorstCreature(latestResult.lowestCreature);

    /*-----------------------------*/
    populationCopy.sort(Comparator.comparing(CreatureChromosome::getEnergy));

    latestResult = getHighestAverageLowestFromOrderedList(populationCopy);

    result.setGenerationHighestEnergyCreature(latestResult.topCreature);
    result.setGenerationLowestEnergyCreature(latestResult.lowestCreature);

    /*-----------------------------*/
    populationCopy.sort(Comparator.comparing(c -> c.getGene().getSpeedPixelsPerTick()));

    latestResult = getHighestAverageLowestFromOrderedList(populationCopy);

    result.setGenerationHighestSpeedCreature(latestResult.topCreature);
    result.setGenerationLowestSpeedCreature(latestResult.lowestCreature);

    /*-----------------------------*/
    populationCopy.sort(Comparator.comparing(c -> c.getGene().getEnergyDecayPerTick()));

    latestResult = getHighestAverageLowestFromOrderedList(populationCopy);

    result.setGenerationHighestEnergyDecayCreature(latestResult.topCreature);
    result.setGenerationLowestEnergyDecayCreature(latestResult.lowestCreature);

    /*-----------------------------*/
    populationCopy.sort(Comparator.comparing(c -> c.getGene().getVisionRange()));

    latestResult = getHighestAverageLowestFromOrderedList(populationCopy);

    result.setGenerationHighestVisionRangeCreature(latestResult.topCreature);
    result.setGenerationLowestVisionRangeCreature(latestResult.lowestCreature);

    setAverages(result, populationCopy);

    return result;
  }

  private void setAverages(GenerationMetaInformation result, List<CreatureChromosome> population) {

    double speedSum =
        population.stream().mapToDouble(c -> c.getGene().getSpeedPixelsPerTick()).sum();

    double energySum = population.stream().mapToDouble(CreatureChromosome::getEnergy).sum();

    double energyDecaySum =
        population.stream().mapToDouble(c -> c.getGene().getEnergyDecayPerTick()).sum();

    double visionRangeSum =
        population.stream().mapToDouble(c -> c.getGene().getVisionRange()).sum();

    result.setGenerationAverageEnergy(energySum / (1.0 * population.size()));
    result.setGenerationAverageEnergyDecay(energyDecaySum / (1.0 * population.size()));
    result.setGenerationAverageSpeed(speedSum / (1.0 * population.size()));
    result.setGenerationAverageVisionRange(visionRangeSum / (1.0 * population.size()));
  }

  private EnrichmentResult getHighestAverageLowestFromOrderedList(
      List<CreatureChromosome> population) {
    var topCreature = population.get(population.size() - 1);
    var lowestCreature = population.get(0);

    return new EnrichmentResult(
        new CreatureChromosome(topCreature), new CreatureChromosome(lowestCreature));
  }

  private static class EnrichmentResult {
    CreatureChromosome topCreature;
    CreatureChromosome lowestCreature;

    EnrichmentResult(CreatureChromosome topCreature, CreatureChromosome lowestCreature) {
      this.topCreature = topCreature;
      this.lowestCreature = lowestCreature;
    }
  }
}
