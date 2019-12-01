package view;

import creatures.model.CreatureChromosome;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import simulation.Simulator;
import simulation.model.SimulationResult;
import view.helper.CreatureChromosomeTextValue;

public class MainView extends BorderPane {

  private Simulator simulator;
  private CreaturesCanvas creaturesCanvas;
  private AppSidebar appSidebar;

  public MainView() {
    this.creaturesCanvas = new CreaturesCanvas(1024, 1024);
    this.appSidebar = new AppSidebar(this);
    this.setTop(new VBox(new AppToolbar(this)));

    this.setLeft(appSidebar);
    this.setCenter(creaturesCanvas);
  }

  public void nextGeneration(int generationsCount) {

    this.simulator.start(generationsCount);
    SimulationResult simulationResult = this.simulator.getSimulationResult();

    this.draw(simulationResult);

    refreshSidebar(simulationResult);
  }

  public void refreshSidebar(SimulationResult simulationResult) {
    this.appSidebar.setBestPlaceText(
        CreatureChromosomeTextValue.getTextValue(simulationResult.getBestCreature()));
    this.appSidebar.setAveragePlaceText(
        CreatureChromosomeTextValue.getTextValue(simulationResult.getAverageCreature()));

    this.appSidebar.setWorstPlaceText(
        CreatureChromosomeTextValue.getTextValue(simulationResult.getWorstCreature()));
  }

  public void connect(Simulator simulator) {
    this.simulator = simulator;
  }

  public void start() {

    this.simulator.start(1);
  }

  public void draw(SimulationResult simulationResult) {
    this.creaturesCanvas.draw(simulationResult);
  }

  public void drawCreature(CreatureChromosome creatureChromosome) {
    this.creaturesCanvas.drawCreature(creatureChromosome);
  }

  public void generateFood() {
    this.creaturesCanvas.generateFood();
  }
}