package creatures.implementations;

import creatures.model.CreatureChromosome;
import creatures.model.CreatureGeneConstants;
import geneticalgorithm.interfaces.IScoreEvaluator;

public class CreatureScoreEvaluator implements IScoreEvaluator {
  @Override
  public double evaluateChromosome(CreatureChromosome chromosome) {
    // ( chromosome.getEnergy() / CreatureGeneConstants.MAX_ENERGY)
    return (chromosome.getEnergy() / CreatureGeneConstants.MAX_ENERGY) * chromosome.getFoodCount();
  }
}
