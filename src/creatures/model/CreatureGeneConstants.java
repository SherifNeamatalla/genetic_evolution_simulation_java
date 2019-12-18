package creatures.model;

public class CreatureGeneConstants {

  public static final double MAX_ENERGY = 100;
  public static final double MIN_ENERGY = 0;

  public static final double MAX_SPEED = 25;

  public static final double MIN_SPEED = 0;

  public static final double MIN_ENERGY_DECAY_PER_SECOND = 1;

  public static final double MAX_ENERGY_DECAY_PER_SECOND = 15;

  public static final double MAX_X = 1024;
  public static final double MAX_Y = 1024;

  public static final double MIN_X = 0;
  public static final double MIN_Y = 0;

  public static final double MAX_VISION_RANGE = 250;

  public static final double MIN_VISION_RANGE = 50;

  public static final int CREATURE_RADIUS = 20;

  public static final int FOOD_REWARD = 25;
  public static final double SURVIVAL_REWARD = 0;

  // For forcing creatures to seek for food.. or DIE!
  public static final double PER_TICK_DEFAULT_DECAY = 2;
}
