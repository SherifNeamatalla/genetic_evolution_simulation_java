package simulation;

import controller.AlgorithmController;
import creatures.PositionCreator;
import creatures.implementations.CreatureMutationManager;
import creatures.implementations.CreaturePopulationCreator;
import creatures.implementations.CreatureScoreEvaluator;
import creatures.model.CreatureChromosome;
import creatures.model.CreatureGeneConstants;
import geneticalgorithm.AlgorithmLogger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import simulation.helper.FoodGenerator;
import simulation.model.SimulationResult;
import view.MainView;

public class Simulator {

  private static final int TICKS_PER_ROUND = 15;
  private static final int GENERATIONS = 500;
  private static final int POPULATION_COUNT = 30;

  private static final double MUTATION_RATE = 0.2;

  private static final double CROSSOVER_RATE = 0.7;

  private static final double TOP_SURVIVORS_PERCENTAGE = 0.8;
  private static final int TICK_PER_SECOND = 1;

  private static final int FOOD_COUNT = 15;

  private Timeline timeline;

  private MainView mainView;

  private AlgorithmController algorithmController;

  private SimulationResult simulationResult;

  private int generationsCount = 1;

  public Simulator(MainView mainView) {
    this.mainView = mainView;
    this.algorithmController =
        new AlgorithmController(
            new CreaturePopulationCreator(),
            new CreatureScoreEvaluator(),
            new CreatureMutationManager());

    AlgorithmLogger.BEST_RESULT_LOGGING_ENABLED = true;

    this.simulationResult =
        this.algorithmController.getNextGeneration(
            generationsCount,
            POPULATION_COUNT,
            MUTATION_RATE,
            CROSSOVER_RATE,
            TOP_SURVIVORS_PERCENTAGE,
            null);
    this.simulationResult.setFood(FoodGenerator.generateFood(FOOD_COUNT));

    KeyFrame keyFrame =
        new KeyFrame(
            Duration.millis(TICK_PER_SECOND * 1000),
            actionEvent -> {
              this.simulationResult
                  .getPopulation()
                  .forEach(
                      creatureChromosome -> {
                        creatureChromosome.liveTick(this.simulationResult.getFood());
                      });
              this.mainView.draw(this.simulationResult);
            });

    this.mainView.connect(this);

    this.timeline = new Timeline(keyFrame);
    this.timeline.setCycleCount(TICKS_PER_ROUND);
    this.timeline.setOnFinished(this::onSimulationDone);
    this.mainView.draw(this.simulationResult);
    this.mainView.refreshSidebar(this.simulationResult);
  }

  private void onSimulationDone(ActionEvent actionEvent) {
    this.simulationResult =
        this.algorithmController.getNextGeneration(
            generationsCount,
            POPULATION_COUNT,
            MUTATION_RATE,
            CROSSOVER_RATE,
            TOP_SURVIVORS_PERCENTAGE,
            this.simulationResult.getPopulation());

    this.mainView.refreshSidebar(this.simulationResult);

    for (CreatureChromosome creatureChromosome : this.simulationResult.getPopulation()) {
      creatureChromosome.setEnergy(
              CreatureGeneConstants.MAX_ENERGY);
      creatureChromosome.setFoodCount(0);
    }
  }

  private void simulate(ActionEvent actionEvent) {}

  public void start(int generationsCount) {
    this.generationsCount = generationsCount;
    for (CreatureChromosome creatureChromosome : this.simulationResult.getPopulation()) {
      creatureChromosome.setPosition(PositionCreator.buildRandomPosition());
      this.simulationResult.setFood(FoodGenerator.generateFood(FOOD_COUNT));
    }
    this.timeline.play();
  }

  public void stop() {
    this.timeline.stop();
  }

  public SimulationResult getSimulationResult() {

    return simulationResult;
  }
}
