package creatures.implementations;

import creatures.CreatureGenesCreator;
import creatures.PositionCreator;
import creatures.model.CreatureChromosome;
import creatures.model.CreatureGene;
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
    Random random = new Random(System.currentTimeMillis());

    List<CreatureChromosome> newPopulation = new ArrayList<>();

    Collections.shuffle(population);

    for (int i = 0; i < population.size() - 1; i++, i++) {
      var parent1 = population.get(i);
      var parent2 = population.get((i + 1));

      double randomValue = random.nextDouble();

      var clone1 = new CreatureChromosome((parent1.getGene()), parent1.getPosition());
      var clone2 = new CreatureChromosome((parent2.getGene()), parent2.getPosition());

      newPopulation.add(clone1);
      newPopulation.add(clone2);

      if (randomValue < crossoverRate) {
        var child1 = newOffspring(parent1, parent2);

        newPopulation.add(child1);
      }
    }

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
