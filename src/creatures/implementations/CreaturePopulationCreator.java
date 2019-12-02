package creatures.implementations;

import creatures.CreatureGenesCreator;
import creatures.PositionCreator;
import creatures.model.CreatureChromosome;
import creatures.model.CreatureGene;
import creatures.model.CreatureGeneConstants;
import geneticalgorithm.interfaces.IPopulationCreator;
import geneticalgorithm.interfaces.IScoreEvaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CreaturePopulationCreator implements IPopulationCreator {

  private static final int MAX_NUMBER_OF_GENE_PROPERTIES = 3;

  @Override
  public List<CreatureChromosome> newGeneration(int populationCount) {

    List<CreatureChromosome> result = new ArrayList<>();
    for (int i = 0; i < populationCount; i++) {
      result.add(
          new CreatureChromosome(
              CreatureGenesCreator.buildRandomGene(), PositionCreator.buildRandomPosition()));
    }
    return result;
  }

  @Override
  public CreatureChromosome newOffspring(CreatureChromosome parent1, CreatureChromosome parent2) {
    Random random = new Random(System.currentTimeMillis());

    int index1 = random.nextInt(3);
    int index2 = random.nextInt(3);

    int max = Math.max(index1, index2);
    int min = Math.min(index1, index2);

    double energyDecayPerTrick = parent2.getGene().getEnergyDecayPerTick();
    double range = parent2.getGene().getVisionRange();
    double speedPixelsPerTick = parent2.getGene().getSpeedPixelsPerTick();

    for (int i = min; i < max; i++) {
      if (i == 0) {
        range = parent1.getGene().getVisionRange();

      } else if (i == 1) {
        speedPixelsPerTick = parent1.getGene().getSpeedPixelsPerTick();

      } else if (i == 2) {
        energyDecayPerTrick = parent1.getGene().getEnergyDecayPerTick();
      }
    }
    CreatureGene newChild = new CreatureGene(energyDecayPerTrick, range, speedPixelsPerTick);

    return new CreatureChromosome(newChild, parent1.getPosition());
  }

  @Override
  public List<CreatureChromosome> newGeneration(
      List<CreatureChromosome> population,
      double crossoverRate,
      IScoreEvaluator scoreEvaluator,
      int creaturesCount) {
    if (population.size() <= 1) return population;
    Random random = new Random(System.currentTimeMillis());

    List<CreatureChromosome> newPopulation = new ArrayList<>();

    Collections.shuffle(population);

    List<CreatureChromosome> successfulCreatures =
        population.stream()
            .filter(
                c -> c.getEnergy() > CreatureGeneConstants.MAX_ENERGY / 2 && c.getFoodCount() > 0)
            .collect(Collectors.toList());

    for (int i = 0;
        i < successfulCreatures.size() - 1 && newPopulation.size() < creaturesCount;
        i++, i++) {
      var parent1 = successfulCreatures.get(i);
      var parent2 = successfulCreatures.get((i + 1));

      double randomValue = random.nextDouble();

      if (randomValue < crossoverRate) {
        var child1 = newOffspring(parent1, parent2);

        newPopulation.add(child1);
      }
    }

    // All old population survives.
    newPopulation.addAll(population);
    return newPopulation;
  }

  @Override
  public List<CreatureChromosome> getCrossoverPool(
      List<CreatureChromosome> population,
      IScoreEvaluator scoreEvaluator,
      double topSurvivorsPercentage) {

    return population.stream().filter(p -> p.getEnergy() > 0).collect(Collectors.toList());
  }
}
