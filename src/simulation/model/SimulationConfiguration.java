package simulation.model;

public class SimulationConfiguration {

  private int ticksPerRound;
  private int startPopulationCount;

  private double mutationRate;

  private double crossoverRate;

  private int ticksPerSecond;

  private int foodCount;

  private double suddenDeathRate;

  private double topPopulationRate;

  public SimulationConfiguration(
      int ticksPerRound,
      int startPopulationCount,
      double mutationRate,
      double crossoverRate,
      int ticksPerSecond,
      int foodCount,
      double suddenDeathRate,
      double topPopulationRate) {
    this.ticksPerRound = ticksPerRound;
    this.startPopulationCount = startPopulationCount;
    this.mutationRate = mutationRate;
    this.crossoverRate = crossoverRate;
    this.ticksPerSecond = ticksPerSecond;
    this.foodCount = foodCount;
    this.suddenDeathRate = suddenDeathRate;
    this.topPopulationRate = topPopulationRate;
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

  public double getSuddenDeathRate() {
    return suddenDeathRate;
  }

  public void setSuddenDeathRate(double suddenDeathRate) {
    this.suddenDeathRate = suddenDeathRate;
  }

  public double getTopPopulationRate() {
    return topPopulationRate;
  }

  public void setTopPopulationRate(double topPopulationRate) {
    this.topPopulationRate = topPopulationRate;
  }
}
