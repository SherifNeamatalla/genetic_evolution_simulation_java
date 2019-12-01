package simulation.model;

import creatures.model.CreatureChromosome;

import java.util.List;

public class SimulationResult {

  private CreatureChromosome bestCreature;
  private CreatureChromosome averageCreature;
  private CreatureChromosome worstCreature;

  private List<CreatureChromosome> population;

  private List<Food> food;

  public SimulationResult(
      CreatureChromosome bestCreature,
      CreatureChromosome averageCreature,
      CreatureChromosome worstCreature,
      List<CreatureChromosome> population) {
    this.bestCreature = bestCreature;
    this.averageCreature = averageCreature;
    this.worstCreature = worstCreature;
    this.population = population;
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

  public List<Food> getFood() {
    return food;
  }

  public void setFood(List<Food> food) {
    this.food = food;
  }
}
