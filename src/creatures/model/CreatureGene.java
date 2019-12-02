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
            / (CreatureGeneConstants.MAX_SPEED - CreatureGeneConstants.MIN_SPEED);
    this.energyDecayPerTick =
        speedPercentage
            * (CreatureGeneConstants.MAX_ENERGY_DECAY_PER_SECOND
                - CreatureGeneConstants.MIN_ENERGY_DECAY_PER_SECOND);
  }

  public void mutateGene() {
    int randomValue = ThreadLocalRandom.current().nextInt(3);
    if(randomValue == 0)this.visionRange =
            ThreadLocalRandom.current()
                    .nextDouble(
                            CreatureGeneConstants.MIN_VISION_RANGE, CreatureGeneConstants.MAX_VISION_RANGE);
    else if (randomValue == 1){
      this.speedPixelsPerTick =
              ThreadLocalRandom.current()
                      .nextDouble(CreatureGeneConstants.MIN_SPEED, CreatureGeneConstants.MAX_SPEED);
    }
    else if(randomValue == 2)
    {
      this.energyDecayPerTick =
              ThreadLocalRandom.current()
                      .nextDouble(CreatureGeneConstants.MIN_ENERGY_DECAY_PER_SECOND, CreatureGeneConstants.MAX_ENERGY_DECAY_PER_SECOND);
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
