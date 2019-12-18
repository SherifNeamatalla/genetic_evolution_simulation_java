package geneticalgorithm.model;

import creatures.model.CreatureChromosome;

import java.util.List;

public class GenerationMetaInformation {

  private int generationCount;

  private int creaturesCount;

  private double generationAverageSpeed;

  private double generationAverageEnergy;

  private double generationAverageEnergyDecay;

  private double generationAverageVisionRange;

  private CreatureChromosome generationHighestSpeedCreature;

  private CreatureChromosome generationHighestEnergyCreature;

  private CreatureChromosome generationHighestEnergyDecayCreature;

  private CreatureChromosome generationHighestVisionRangeCreature;

  private CreatureChromosome generationLowestSpeedCreature;

  private CreatureChromosome generationLowestEnergyDecayCreature;

  private CreatureChromosome generationLowestVisionRangeCreature;
  private CreatureChromosome generationLowestEnergyCreature;

  private CreatureChromosome bestCreature;
  private CreatureChromosome averageCreature;
  private CreatureChromosome worstCreature;

  private List<CreatureChromosome> population;

  public GenerationMetaInformation() {}

  public static Builder builder() {
    return new Builder();
  }

  public int getGenerationCount() {
    return generationCount;
  }

  public void setGenerationCount(int generationCount) {
    this.generationCount = generationCount;
  }

  public double getGenerationAverageSpeed() {
    return generationAverageSpeed;
  }

  public void setGenerationAverageSpeed(double generationAverageSpeed) {
    this.generationAverageSpeed = generationAverageSpeed;
  }

  public double getGenerationAverageEnergy() {
    return generationAverageEnergy;
  }

  public void setGenerationAverageEnergy(double generationAverageEnergy) {
    this.generationAverageEnergy = generationAverageEnergy;
  }

  public double getGenerationAverageEnergyDecay() {
    return generationAverageEnergyDecay;
  }

  public void setGenerationAverageEnergyDecay(double generationAverageEnergyDecay) {
    this.generationAverageEnergyDecay = generationAverageEnergyDecay;
  }

  public double getGenerationAverageVisionRange() {
    return generationAverageVisionRange;
  }

  public void setGenerationAverageVisionRange(double generationAverageVisionRange) {
    this.generationAverageVisionRange = generationAverageVisionRange;
  }

  public CreatureChromosome getGenerationHighestSpeedCreature() {
    return generationHighestSpeedCreature;
  }

  public void setGenerationHighestSpeedCreature(CreatureChromosome generationHighestSpeedCreature) {
    this.generationHighestSpeedCreature = generationHighestSpeedCreature;
  }

  public CreatureChromosome getGenerationHighestEnergyCreature() {
    return generationHighestEnergyCreature;
  }

  public void setGenerationHighestEnergyCreature(
      CreatureChromosome generationHighestEnergyCreature) {
    this.generationHighestEnergyCreature = generationHighestEnergyCreature;
  }

  public CreatureChromosome getGenerationHighestEnergyDecayCreature() {
    return generationHighestEnergyDecayCreature;
  }

  public void setGenerationHighestEnergyDecayCreature(
      CreatureChromosome generationHighestEnergyDecayCreature) {
    this.generationHighestEnergyDecayCreature = generationHighestEnergyDecayCreature;
  }

  public CreatureChromosome getGenerationHighestVisionRangeCreature() {
    return generationHighestVisionRangeCreature;
  }

  public void setGenerationHighestVisionRangeCreature(
      CreatureChromosome generationHighestVisionRangeCreature) {
    this.generationHighestVisionRangeCreature = generationHighestVisionRangeCreature;
  }

  public CreatureChromosome getGenerationLowestSpeedCreature() {
    return generationLowestSpeedCreature;
  }

  public void setGenerationLowestSpeedCreature(CreatureChromosome generationLowestSpeedCreature) {
    this.generationLowestSpeedCreature = generationLowestSpeedCreature;
  }

  public CreatureChromosome getGenerationLowestEnergyDecayCreature() {
    return generationLowestEnergyDecayCreature;
  }

  public void setGenerationLowestEnergyDecayCreature(
      CreatureChromosome generationLowestEnergyDecayCreature) {
    this.generationLowestEnergyDecayCreature = generationLowestEnergyDecayCreature;
  }

  public CreatureChromosome getGenerationLowestVisionRangeCreature() {
    return generationLowestVisionRangeCreature;
  }

  public void setGenerationLowestVisionRangeCreature(
      CreatureChromosome generationLowestVisionRangeCreature) {
    this.generationLowestVisionRangeCreature = generationLowestVisionRangeCreature;
  }

  public CreatureChromosome getGenerationLowestEnergyCreature() {
    return generationLowestEnergyCreature;
  }

  public void setGenerationLowestEnergyCreature(CreatureChromosome generationLowestEnergyCreature) {
    this.generationLowestEnergyCreature = generationLowestEnergyCreature;
  }

  public CreatureChromosome getBestCreature() {
    return bestCreature;
  }

  public void setBestCreature(CreatureChromosome bestCreature) {
    this.bestCreature = bestCreature;
  }

  public CreatureChromosome getAverageCreature() {
    return averageCreature;
  }

  public void setAverageCreature(CreatureChromosome averageCreature) {
    this.averageCreature = averageCreature;
  }

  public CreatureChromosome getWorstCreature() {
    return worstCreature;
  }

  public void setWorstCreature(CreatureChromosome worstCreature) {
    this.worstCreature = worstCreature;
  }

  public List<CreatureChromosome> getPopulation() {
    return population;
  }

  public void setPopulation(List<CreatureChromosome> population) {
    this.population = population;
  }

  public static final class Builder {
    private int generationCount;
    private double generationAverageSpeedCreature;
    private double generationAverageEnergyCreature;
    private double generationAverageEnergyDecayCreature;
    private double generationAverageVisionRangeCreature;
    private CreatureChromosome generationHighestSpeedCreature;
    private CreatureChromosome generationHighestEnergyCreature;
    private CreatureChromosome generationHighestEnergyDecayCreature;
    private CreatureChromosome generationHighestVisionRangeCreature;
    private CreatureChromosome generationLowestSpeedCreature;
    private CreatureChromosome generationLowestEnergyDecayCreature;
    private CreatureChromosome generationLowestVisionRangeCreature;
    private CreatureChromosome generationLowestEnergyCreature;
    private CreatureChromosome bestCreature;
    private CreatureChromosome averageCreature;
    private CreatureChromosome worstCreature;
    private List<CreatureChromosome> population;

    private Builder() {}

    public static Builder aGenerationMetaInformation() {
      return new Builder();
    }

    public Builder setGenerationCount(int generationCount) {
      this.generationCount = generationCount;
      return this;
    }

    public Builder setGenerationAverageSpeedCreature(double generationAverageSpeedCreature) {
      this.generationAverageSpeedCreature = generationAverageSpeedCreature;
      return this;
    }

    public Builder setGenerationAverageEnergyCreature(double generationAverageEnergyCreature) {
      this.generationAverageEnergyCreature = generationAverageEnergyCreature;
      return this;
    }

    public Builder setGenerationAverageEnergyDecayCreature(
        double generationAverageEnergyDecayCreature) {
      this.generationAverageEnergyDecayCreature = generationAverageEnergyDecayCreature;
      return this;
    }

    public Builder setGenerationAverageVisionRangeCreature(
        double generationAverageVisionRangeCreature) {
      this.generationAverageVisionRangeCreature = generationAverageVisionRangeCreature;
      return this;
    }

    public Builder setGenerationHighestSpeedCreature(
        CreatureChromosome generationHighestSpeedCreature) {
      this.generationHighestSpeedCreature = generationHighestSpeedCreature;
      return this;
    }

    public Builder setGenerationHighestEnergyCreature(
        CreatureChromosome generationHighestEnergyCreature) {
      this.generationHighestEnergyCreature = generationHighestEnergyCreature;
      return this;
    }

    public Builder setGenerationHighestEnergyDecayCreature(
        CreatureChromosome generationHighestEnergyDecayCreature) {
      this.generationHighestEnergyDecayCreature = generationHighestEnergyDecayCreature;
      return this;
    }

    public Builder setGenerationHighestVisionRangeCreature(
        CreatureChromosome generationHighestVisionRangeCreature) {
      this.generationHighestVisionRangeCreature = generationHighestVisionRangeCreature;
      return this;
    }

    public Builder setGenerationLowestSpeedCreature(
        CreatureChromosome generationLowestSpeedCreature) {
      this.generationLowestSpeedCreature = generationLowestSpeedCreature;
      return this;
    }

    public Builder setGenerationLowestEnergyDecayCreature(
        CreatureChromosome generationLowestEnergyDecayCreature) {
      this.generationLowestEnergyDecayCreature = generationLowestEnergyDecayCreature;
      return this;
    }

    public Builder setGenerationLowestVisionRangeCreature(
        CreatureChromosome generationLowestVisionRangeCreature) {
      this.generationLowestVisionRangeCreature = generationLowestVisionRangeCreature;
      return this;
    }

    public Builder setGenerationLowestEnergyCreature(
        CreatureChromosome generationLowestEnergyCreature) {
      this.generationLowestEnergyCreature = generationLowestEnergyCreature;
      return this;
    }

    public Builder setBestCreature(CreatureChromosome bestCreature) {
      this.bestCreature = bestCreature;
      return this;
    }

    public Builder setAverageCreature(CreatureChromosome averageCreature) {
      this.averageCreature = averageCreature;
      return this;
    }

    public Builder setWorstCreature(CreatureChromosome worstCreature) {
      this.worstCreature = worstCreature;
      return this;
    }

    public Builder setPopulation(List<CreatureChromosome> population) {
      this.population = population;
      return this;
    }

    public GenerationMetaInformation build() {
      GenerationMetaInformation generationMetaInformation = new GenerationMetaInformation();
      generationMetaInformation.setGenerationCount(generationCount);
      generationMetaInformation.setGenerationAverageSpeed(generationAverageSpeedCreature);
      generationMetaInformation.setGenerationAverageEnergy(generationAverageEnergyCreature);
      generationMetaInformation.setGenerationAverageEnergyDecay(
          generationAverageEnergyDecayCreature);
      generationMetaInformation.setGenerationAverageVisionRange(
          generationAverageVisionRangeCreature);
      generationMetaInformation.setGenerationHighestSpeedCreature(generationHighestSpeedCreature);
      generationMetaInformation.setGenerationHighestEnergyCreature(generationHighestEnergyCreature);
      generationMetaInformation.setGenerationHighestEnergyDecayCreature(
          generationHighestEnergyDecayCreature);
      generationMetaInformation.setGenerationHighestVisionRangeCreature(
          generationHighestVisionRangeCreature);
      generationMetaInformation.setGenerationLowestSpeedCreature(generationLowestSpeedCreature);
      generationMetaInformation.setGenerationLowestEnergyDecayCreature(
          generationLowestEnergyDecayCreature);
      generationMetaInformation.setGenerationLowestVisionRangeCreature(
          generationLowestVisionRangeCreature);
      generationMetaInformation.setGenerationLowestEnergyCreature(generationLowestEnergyCreature);
      generationMetaInformation.setBestCreature(bestCreature);
      generationMetaInformation.setAverageCreature(averageCreature);
      generationMetaInformation.setWorstCreature(worstCreature);
      generationMetaInformation.setPopulation(population);
      return generationMetaInformation;
    }
  }
}
