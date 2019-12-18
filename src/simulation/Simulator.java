package simulation;

import controller.AlgorithmController;
import creatures.PositionCreator;
import creatures.implementations.CreatureMutationManager;
import creatures.implementations.CreaturePopulationCreatorNoDeathRate;
import creatures.implementations.CreatureScoreEvaluator;
import creatures.model.CreatureChromosome;
import geneticalgorithm.AlgorithmLogger;
import geneticalgorithm.model.GenerationMetaInformation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;
import simulation.helper.FoodGenerator;
import simulation.model.Simulation;
import simulation.model.SimulationConfiguration;
import view.MainView;

public class Simulator {

  private Timeline timeline;

  private MainView mainView;

  private AlgorithmController algorithmController;

  private Simulation simulation;

  private SimulationConfiguration simulationConfiguration;

  private GenerationMetaInformation lastGenerationMetaInformation;

  private int generationsCount = 1;

  public Simulator(MainView mainView, SimulationConfiguration simulationConfiguration) {
    this.mainView = mainView;
    this.simulationConfiguration = simulationConfiguration;
    this.algorithmController =
        new AlgorithmController(
            new CreaturePopulationCreatorNoDeathRate(),
            new CreatureScoreEvaluator(),
            new CreatureMutationManager());

    AlgorithmLogger.BEST_RESULT_LOGGING_ENABLED = true;

    this.simulation =
        new Simulation(
            this.algorithmController.getNextGeneration(
                simulationConfiguration.getStartPopulationCount(),
                simulationConfiguration.getMutationRate(),
                simulationConfiguration.getCrossoverRate(),
                simulationConfiguration.getTopPopulationRate(),
                simulationConfiguration.getSuddenDeathRate(),
                null));
    this.simulation.setFood(FoodGenerator.generateFood(simulationConfiguration.getFoodCount()));

    this.lastGenerationMetaInformation =
        algorithmController.getGenerationMetaInformation(
            this.generationsCount, this.simulation.getPopulation());
    this.generationsCount++;

    KeyFrame keyFrame =
        new KeyFrame(
            Duration.millis(simulationConfiguration.getTicksPerSecond() * 256),
            actionEvent -> {
              this.simulation
                  .getPopulation()
                  .forEach(
                      creatureChromosome -> {
                        creatureChromosome.liveTick(this.simulation.getFood());
                      });
              this.mainView.draw(this.simulation);
            });

    this.mainView.connect(this);
    this.timeline = new Timeline(keyFrame);
    this.timeline.setCycleCount(simulationConfiguration.getTicksPerRound());
    this.timeline.setOnFinished(this::onSimulationDone);
   // this.mainView.draw(this.simulation);
    this.mainView.refreshSidebar(this.lastGenerationMetaInformation);
    this.mainView.refreshSidebarConfigurationTextValue(this.simulationConfiguration);
  }

  private void onSimulationDone(ActionEvent actionEvent) {

    this.lastGenerationMetaInformation =
        algorithmController.getGenerationMetaInformation(
            this.generationsCount, this.simulation.getPopulation());
    this.generationsCount++;

    this.mainView.refreshSidebar(this.lastGenerationMetaInformation);

    this.simulation =
        new Simulation(
            this.algorithmController.getNextGeneration(
                simulationConfiguration.getStartPopulationCount(),
                simulationConfiguration.getMutationRate(),
                simulationConfiguration.getCrossoverRate(),
                simulationConfiguration.getSuddenDeathRate(),
                0,
                this.simulation.getPopulation()));
  }

  public void start() {
    for (CreatureChromosome creatureChromosome : this.simulation.getPopulation()) {
      creatureChromosome.setPosition(PositionCreator.buildRandomPosition());
      this.simulation.setFood(FoodGenerator.generateFood(simulationConfiguration.getFoodCount()));
      // creatureChromosome.setEnergy(CreatureGeneConstants.MAX_ENERGY);
      creatureChromosome.setFoodCount(0);
    }
    this.timeline.play();
  }

  public void stop() {
    this.timeline.stop();
  }

  public Simulation getSimulation() {

    return simulation;
  }
}
