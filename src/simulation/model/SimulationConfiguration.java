package simulation.model;

public class SimulationConfiguration {

  private int ticksPerRound = 15;
  private int startPopulationCount = 100;

  private double mutationRate = 0.2;

  private double crossoverRate = 0.7;

  private int ticksPerSecond = 1;

  private int foodCount = 50;


  public SimulationConfiguration(
      int ticksPerRound,
      int startPopulationCount,
      double mutationRate,
      double crossoverRate,
      int ticksPerSecond,
      int foodCount) {
    this.ticksPerRound = ticksPerRound;
    this.startPopulationCount = startPopulationCount;
    this.mutationRate = mutationRate;
    this.crossoverRate = crossoverRate;
    this.ticksPerSecond = ticksPerSecond;
    this.foodCount = foodCount;
  }

  public int getTicksPerRound() {
    return ticksPerRound;
  }

  public void setTicksPerRound(int ticksPerRound) {
    this.ticksPerRound = ticksPerRound;
  }

  public int getStartPopulationCount() {
    return startPopulationCount;
  }

  public void setStartPopulationCount(int startPopulationCount) {
    this.startPopulationCount = startPopulationCount;
  }

  public double getMutationRate() {
    return mutationRate;
  }

  public void setMutationRate(double mutationRate) {
    this.mutationRate = mutationRate;
  }

  public double getCrossoverRate() {
    return crossoverRate;
  }

  public void setCrossoverRate(double crossoverRate) {
    this.crossoverRate = crossoverRate;
  }

  public int getTicksPerSecond() {
    return ticksPerSecond;
  }

  public void setTicksPerSecond(int ticksPerSecond) {
    this.ticksPerSecond = ticksPerSecond;
  }

  public int getFoodCount() {
    return foodCount;
  }

  public void setFoodCount(int foodCount) {
    this.foodCount = foodCount;
  }
}
