package creatures.implementations;

import creatures.model.CreatureChromosome;
import geneticalgorithm.interfaces.IMutationManager;

import java.util.Random;

public class CreatureMutationManager implements IMutationManager {
  @Override
  public CreatureChromosome mutateCreatureChromosome(
      CreatureChromosome chromosome, double mutationRate) {

    Random random = new Random(System.currentTimeMillis());
    double randomValue = random.nextDouble();

    if (randomValue <= mutationRate) chromosome.mutate();

    return chromosome;
  }
}
