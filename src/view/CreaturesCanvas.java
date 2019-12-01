package view;

import creatures.model.CreatureChromosome;
import creatures.model.CreatureGeneConstants;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import simulation.model.Food;
import simulation.model.SimulationResult;

import java.util.List;

public class CreaturesCanvas extends Canvas {

  public CreaturesCanvas(double width, double height) {
    super(width, height);
    this.getGraphicsContext2D().setFill(Color.GREEN);
    this.getGraphicsContext2D().fillRect(0, 0, this.getWidth(), this.getHeight());
  }

  public void draw(SimulationResult simulation) {

    List<CreatureChromosome> creatures = simulation.getPopulation();
    List<Food> food = simulation.getFood();
    GraphicsContext gc = this.getGraphicsContext2D();

    gc.clearRect(0, 0, this.getWidth(), this.getHeight());
    this.getGraphicsContext2D().setFill(Color.GREEN);
    this.getGraphicsContext2D().fillRect(0, 0, this.getWidth(), this.getHeight());

    if (creatures != null)
      for (CreatureChromosome creature : creatures) {
        this.drawCreature(creature);
      }
    if (food != null)
      for (Food foodItem : food) {
        this.drawFood(foodItem);
      }
  }

  public void drawCreature(CreatureChromosome creature) {
    GraphicsContext gc = this.getGraphicsContext2D();

    gc.setFill(Color.BLACK);
    if (creature.getEnergy() <= 0) gc.setFill(Color.RED);
    else if (creature.getFoodCount() > 0) gc.setFill(Color.BLUE);
    gc.fillText(
        ""
            + String.format("%.2f", creature.getEnergy())
            + " "
            + String.format("%.2f", creature.getGene().getSpeedPixelsPerTick())
            + " "
            + String.format("%.2f", creature.getGene().getVisionRange())
            + " "
            + String.format("%.2f", creature.getGene().getEnergyDecayPerTick()),
        creature.getPosition().getX() - 10,
        creature.getPosition().getY());
    gc.fillOval(
        creature.getPosition().getX(),
        creature.getPosition().getY(),
        CreatureGeneConstants.CREATURE_RADIUS,
        CreatureGeneConstants.CREATURE_RADIUS);
  }

  public void drawFood(Food food) {
    GraphicsContext gc = this.getGraphicsContext2D();

    gc.setFill(Color.YELLOW);

    gc.fillOval(food.getPosition().getX(), food.getPosition().getY(), 10, 10);
  }

  public void generateFood() {}
}
