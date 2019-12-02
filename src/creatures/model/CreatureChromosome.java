package creatures.model;

import creatures.CreatureNameGiver;
import creatures.UtilHelper;
import simulation.model.Food;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CreatureChromosome {
  private String creatureName;
  private double energy;
  private CreatureGene gene;
  private Position position;
  private int xDirection;
  private int yDirection;
  private int foodCount;

  public CreatureChromosome(CreatureGene gene, Position position) {
    this.position = position;
    this.creatureName = CreatureNameGiver.getNextCount();
    this.energy = CreatureGeneConstants.MAX_ENERGY;
    this.gene = gene;
    this.xDirection = ThreadLocalRandom.current().nextInt(2) == 1 ? 1 : -1;
    this.yDirection = ThreadLocalRandom.current().nextInt(2) == 1 ? 1 : -1;
    this.foodCount = 0;
  }

  public void liveTick(List<Food> food) {
    // Dead
    if (this.energy <= 0) return;
    this.move(food);
    this.energy -= this.gene.getEnergyDecayPerTick();
  }

  private void move(List<Food> foods) {
    Food ateFood = null;
    boolean foundTarget = false;
    double minDistanceFood = Integer.MAX_VALUE;
    for (Food food : foods) {
      double xDiff = (food.getPosition().getX() - this.getPosition().getX());
      double yDiff = (food.getPosition().getY() - this.getPosition().getY());

      var distanceToCurrentFood =
          UtilHelper.getDistance(
              food.getPosition().getX(),
              food.getPosition().getY(),
              this.getPosition().getX(),
              this.getPosition().getY());
      // Eat food
      if (Math.abs(xDiff) <= CreatureGeneConstants.CREATURE_RADIUS
          && Math.abs(yDiff) <= CreatureGeneConstants.CREATURE_RADIUS) {

        ateFood = food;
        break;
      } else {
        if (distanceToCurrentFood <= minDistanceFood) {
          if (Math.abs(xDiff) < this.gene.getVisionRange()) {
            this.xDirection = xDiff > 0 ? 1 : -1;
            foundTarget = true;
            minDistanceFood = distanceToCurrentFood;
          }
          if (Math.abs(yDiff) < this.gene.getVisionRange()) {
            this.yDirection = yDiff > 0 ? 1 : -1;
            foundTarget = true;
            minDistanceFood = distanceToCurrentFood;
          }
        }
      }
    }
    if (ateFood != null) {
      this.energy += CreatureGeneConstants.FOOD_REWARD;
      if (this.energy > CreatureGeneConstants.MAX_ENERGY)
        this.energy = CreatureGeneConstants.MAX_ENERGY;
      foods.remove(ateFood);
      this.foodCount++;
    }
    if (!foundTarget) {
      this.xDirection = ThreadLocalRandom.current().nextInt(2) == 1 ? 1 : -1;
      this.yDirection = ThreadLocalRandom.current().nextInt(2) == 1 ? 1 : -1;
    }

    this.position.setX(this.getPosition().getX() + xDirection * this.gene.getSpeedPixelsPerTick());
    this.position.setY(this.getPosition().getY() + yDirection * this.gene.getSpeedPixelsPerTick());
  }

  public void mutate() {
    this.gene.mutateGene();
  }

  public double getEnergy() {
    return energy;
  }

  public String getCreatureName() {
    return creatureName;
  }

  public void setCreatureName(String creatureName) {
    this.creatureName = creatureName;
  }

  public void setEnergy(double energy) {
    this.energy = energy;
  }

  public CreatureGene getGene() {
    return gene;
  }

  public void setGene(CreatureGene gene) {
    this.gene = gene;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public int getFoodCount() {
    return foodCount;
  }

  public void setFoodCount(int foodCount) {
    this.foodCount = foodCount;
  }
}
