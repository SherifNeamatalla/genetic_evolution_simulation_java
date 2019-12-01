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
import simulation.model.SimulationConfiguration;
import simulation.model.SimulationResult;
import view.MainView;

public class Simulator {

  private Timeline timeline;

  private MainView mainView;

  private AlgorithmController algorithmController;

  private SimulationResult simulationResult;

  private SimulationConfiguration simulationConfiguration;

  private int generationsCount = 1;

  public Simulator(MainView mainView, SimulationConfiguration simulationConfiguration) {
    this.mainView = mainView;
    this.simulationConfiguration = simulationConfiguration;
    this.algorithmController =
        new AlgorithmController(
            new CreaturePopulationCreator(),
            new CreatureScoreEvaluator(),
            new CreatureMutationManager());

    AlgorithmLogger.BEST_RESULT_LOGGING_ENABLED = true;

    this.simulationResult =
        this.algorithmController.getNextGeneration(
            generationsCount,
            simulationConfiguration.getStartPopulationCount(),
            simulationConfiguration.getMutationRate(),
            simulationConfiguration.getCrossoverRate(),
            0,
            null);
    this.simulationResult.setFood(
        FoodGenerator.generateFood(simulationConfiguration.getFoodCount()));

    KeyFrame keyFrame =
        new KeyFrame(
            Duration.millis(simulationConfiguration.getTicksPerSecond() * 1000),
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
    this.timeline.setCycleCount(simulationConfiguration.getTicksPerRound());
    this.timeline.setOnFinished(this::onSimulationDone);
    this.mainView.draw(this.simulationResult);
    this.mainView.refreshSidebar(this.simulationResult);
    this.mainView.refreshSidebarConfigurationTextValue(this.simulationConfiguration);
  }

  private void onSimulationDone(ActionEvent actionEvent) {
    this.simulationResult =
        this.algorithmController.getNextGeneration(
            generationsCount,
            simulationConfiguration.getStartPopulationCount(),
            simulationConfiguration.getMutationRate(),
            simulationConfiguration.getCrossoverRate(),
            0,
            this.simulationResult.getPopulation());

    this.mainView.refreshSidebar(this.simulationResult);

    for (CreatureChromosome creatureChromosome : this.simulationResult.getPopulation()) {
      creatureChromosome.setEnergy(CreatureGeneConstants.MAX_ENERGY);
      creatureChromosome.setFoodCount(0);
    }
  }

  private void simulate(ActionEvent actionEvent) {}

  public void start(int generationsCount) {
    this.generationsCount = generationsCount;
    for (CreatureChromosome creatureChromosome : this.simulationResult.getPopulation()) {
      creatureChromosome.setPosition(PositionCreator.buildRandomPosition());
      this.simulationResult.setFood(
          FoodGenerator.generateFood(simulationConfiguration.getFoodCount()));
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
