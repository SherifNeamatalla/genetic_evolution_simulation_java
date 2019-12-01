package geneticalgorithm.interfaces;

import creatures.model.CreatureChromosome;

public interface IScoreEvaluator {

  double evaluateChromosome(CreatureChromosome CreatureChromosome);
}
