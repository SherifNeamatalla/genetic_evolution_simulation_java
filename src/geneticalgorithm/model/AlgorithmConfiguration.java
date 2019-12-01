package geneticalgorithm.model;

public class AlgorithmConfiguration {

  private int generations;
  private int populationCount;
  private double mutationRate;
  private double crossoverRate;
  private double topSurvivorsPercentage;

  public AlgorithmConfiguration(
      int generations,
      int populationCount,
      double mutationRate,
      double crossoverRate,
      double topSurvivorsPercentage) {
    this.generations = generations;
    this.populationCount = populationCount;
    this.mutationRate = mutationRate;
    this.crossoverRate = crossoverRate;
    this.topSurvivorsPercentage = topSurvivorsPercentage;
  }

  public int getGenerations() {
    return generations;
  }

  public void setGenerations(int generations) {
    this.generations = generations;
  }

  public int getPopulationCount() {
    return populationCount;
  }

  public void setPopulationCount(int populationCount) {
    this.populationCount = populationCount;
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

  public double getTopSurvivorsPercentage() {
    return topSurvivorsPercentage;
  }

  public void setTopSurvivorsPercentage(double topSurvivorsPercentage) {
    this.topSurvivorsPercentage = topSurvivorsPercentage;
  }
}
