package geneticalgorithm.interfaces;

import creatures.model.CreatureChromosome;

import java.util.*;
import java.util.stream.Collectors;

public interface IPopulationCreator {

  List<CreatureChromosome> newGeneration(int populationCount);

  CreatureChromosome newOffspring(CreatureChromosome parent1, CreatureChromosome parent2);

  default List<CreatureChromosome> newGeneration(
      List<CreatureChromosome> population,
      double crossoverRate,
      IScoreEvaluator scoreEvaluator,
      int creaturesCount) {

    Random random = new Random(System.currentTimeMillis());

    List<CreatureChromosome> newPopulation = new ArrayList<>();
    population.sort(Comparator.comparing(scoreEvaluator::evaluateChromosome).reversed());
    newPopulation.add(population.get(0));
    newPopulation.add(population.get(1));

    while (newPopulation.size() < creaturesCount) {
      Collections.shuffle(population);

      for (int i = 0; i < population.size() - 1 && newPopulation.size() < creaturesCount; i++,i++) {
        var parent1 = population.get(i);
        var parent2 = population.get((i + 1));

        double randomValue = random.nextDouble();

        if (randomValue >= crossoverRate) {
          var clone1 = new CreatureChromosome((parent1.getGene()), parent1.getPosition());
          var clone2 = new CreatureChromosome((parent2.getGene()), parent2.getPosition());

          newPopulation.add(clone1);
          newPopulation.add(clone2);

        } else {

          var child1 = newOffspring(parent1, parent2);

          newPopulation.add(child1);
        }
      }
    }

    return newPopulation;
  }

  default List<CreatureChromosome> getCrossoverPool(
      List<CreatureChromosome> population,
      IScoreEvaluator scoreEvaluator,
      double topSurvivorsPercentage) {

    List<CreatureChromosome> populationCopy =
        population.stream()
            .sorted(Comparator.comparing(scoreEvaluator::evaluateChromosome).reversed())
            .collect(Collectors.toList());

    var topPopulation = populationCopy.subList(0, (populationCopy.size() / 2));

    Collections.shuffle(topPopulation);

    var topSurvivors =
        topPopulation.subList(0, (int) (topPopulation.size() * topSurvivorsPercentage));

    var bottomPopulation =
        populationCopy.subList((populationCopy.size() / 2), populationCopy.size());

    Collections.shuffle(bottomPopulation);

    var bottomSurvivors =
        bottomPopulation
            .subList(0, (int) Math.ceil(bottomPopulation.size() * (1 - topSurvivorsPercentage)))
            .stream()
            .filter(creatureChromosome -> creatureChromosome.getEnergy() > 0)
            .collect(Collectors.toList());

    topSurvivors.addAll(bottomSurvivors);

    return topSurvivors;
  }
}
