package creatures;

import creatures.model.CreatureGeneConstants;
import creatures.model.Position;

import java.util.concurrent.ThreadLocalRandom;

public class PositionCreator {

  public static Position buildRandomPosition() {

    double x =
        ThreadLocalRandom.current()
            .nextDouble(CreatureGeneConstants.MIN_X, CreatureGeneConstants.MAX_X);
    double y =
        ThreadLocalRandom.current()
            .nextDouble(CreatureGeneConstants.MIN_Y, CreatureGeneConstants.MAX_Y);

    return new Position(x, y);
  }
}
