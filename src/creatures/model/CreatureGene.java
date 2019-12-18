package creatures.model;

import geneticalgorithm.model.Gene;

import java.util.concurrent.ThreadLocalRandom;

public class CreatureGene extends Gene {

  private double energyDecayPerTick;
  private double visionRange;
  private double speedPixelsPerTick;

  public CreatureGene(double energyDecayPerTick, double visionRange, double speedPixelsPerTick) {
    this.energyDecayPerTick = energyDecayPerTick;
    this.visionRange = visionRange;
    this.speedPixelsPerTick = speedPixelsPerTick;
  }

  public CreatureGene() {
    this.randomizeGene();
  }

  public CreatureGene(CreatureGene creatureGene) {
    energyDecayPerTick = creatureGene.energyDecayPerTick;
    visionRange = creatureGene.visionRange;
    speedPixelsPerTick = creatureGene.speedPixelsPerTick;
  }

  public void randomizeGene() {
    this.visionRange =
        ThreadLocalRandom.current()
            .nextDouble(
                CreatureGeneConstants.MIN_VISION_RANGE, CreatureGeneConstants.MAX_VISION_RANGE);
    this.speedPixelsPerTick =
        ThreadLocalRandom.current()
            .nextDouble(CreatureGeneConstants.MIN_SPEED, CreatureGeneConstants.MAX_SPEED);

    double speedPercentage =
        this.speedPixelsPerTick
            / (2 * (CreatureGeneConstants.MAX_SPEED - CreatureGeneConstants.MIN_SPEED));
    this.energyDecayPerTick =
        speedPercentage
            * (CreatureGeneConstants.MAX_ENERGY_DECAY_PER_SECOND
                - CreatureGeneConstants.MIN_ENERGY_DECAY_PER_SECOND);
  }

  public void mutateGene() {
    int randomValue = ThreadLocalRandom.current().nextInt(2);
    boolean randomBoolean = ThreadLocalRandom.current().nextBoolean();
    int sign = randomBoolean ? 1 : -1;
    if (randomValue == 0) {
      this.visionRange +=
          (sign
              * ThreadLocalRandom.current()
                  .nextDouble(
                      CreatureGeneConstants.MIN_VISION_RANGE,
                      ((CreatureGeneConstants.MAX_VISION_RANGE
                                  + CreatureGeneConstants.MIN_VISION_RANGE)
                              * 0.1)
                          + CreatureGeneConstants.MIN_VISION_RANGE));
      if (this.visionRange < CreatureGeneConstants.MIN_VISION_RANGE)
        this.visionRange = CreatureGeneConstants.MIN_VISION_RANGE;
      if (this.visionRange > CreatureGeneConstants.MAX_VISION_RANGE)
        this.visionRange = CreatureGeneConstants.MAX_VISION_RANGE;

    } else if (randomValue == 1) {
      this.speedPixelsPerTick +=
          (sign
              * ThreadLocalRandom.current()
                  .nextDouble(
                      CreatureGeneConstants.MIN_SPEED,
                      ((CreatureGeneConstants.MAX_SPEED + CreatureGeneConstants.MIN_SPEED) * 0.1)
                          + CreatureGeneConstants.MIN_SPEED));
      if (this.speedPixelsPerTick < CreatureGeneConstants.MIN_SPEED)
        this.visionRange = CreatureGeneConstants.MIN_SPEED;
      if (this.speedPixelsPerTick > CreatureGeneConstants.MAX_SPEED)
        this.visionRange = CreatureGeneConstants.MAX_SPEED;

      double speedPercentage =
              this.speedPixelsPerTick
                      / (2 * (CreatureGeneConstants.MAX_SPEED - CreatureGeneConstants.MIN_SPEED));
      this.energyDecayPerTick =
              speedPercentage
                      * (CreatureGeneConstants.MAX_ENERGY_DECAY_PER_SECOND
                      - CreatureGeneConstants.MIN_ENERGY_DECAY_PER_SECOND);
    }
  }

  public double getEnergyDecayPerTick() {
    return energyDecayPerTick;
  }

  public double getVisionRange() {
    return visionRange;
  }

  public double getSpeedPixelsPerTick() {
    return speedPixelsPerTick;
  }

  public void setEnergyDecayPerTick(double energyDecayPerTick) {
    this.energyDecayPerTick = energyDecayPerTick;
  }

  public void setVisionRange(double visionRange) {
    this.visionRange = visionRange;
  }

  public void setSpeedPixelsPerTick(double speedPixelsPerTick) {
    this.speedPixelsPerTick = speedPixelsPerTick;
  }
}
