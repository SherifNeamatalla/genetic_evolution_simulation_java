package geneticalgorithm.interfaces;

import creatures.model.CreatureChromosome;

import java.util.ArrayList;
import java.util.List;

public interface IMutationManager {

  CreatureChromosome mutateCreatureChromosome(
      CreatureChromosome CreatureChromosome, double mutationRate);

  default List<CreatureChromosome> mutateGeneration(
      List<CreatureChromosome> CreatureChromosomes, double mutationRate) {

    List<CreatureChromosome> result = new ArrayList<>();
    for (CreatureChromosome currentCreatureChromosome : CreatureChromosomes) {
      result.add(mutateCreatureChromosome(currentCreatureChromosome, mutationRate));
    }
    return result;
  }
}
