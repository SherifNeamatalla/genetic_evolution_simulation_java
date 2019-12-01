package simulation.model;

import creatures.model.CreatureChromosome;

import java.util.List;

public class Simulation {
  private List<CreatureChromosome> population;

  private List<Food> food;

  public Simulation(List<CreatureChromosome> population, List<Food> food) {
    this.population = population;
    this.food = food;
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
