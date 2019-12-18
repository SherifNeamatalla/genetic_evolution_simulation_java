package view;

import creatures.model.CreatureChromosome;
import geneticalgorithm.model.GenerationMetaInformation;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import simulation.Simulator;
import simulation.model.Simulation;
import simulation.model.SimulationConfiguration;
import view.helper.TextValueExtractor;

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

  public void nextGeneration() {

    this.simulator.start();
    Simulation simulation = this.simulator.getSimulation();

    this.draw(simulation);
  }

  public void refreshSidebar(GenerationMetaInformation generationMetaInformation) {
    this.appSidebar.setBestPlaceText(
        TextValueExtractor.getChromosomeTextValue(generationMetaInformation.getBestCreature()));
    this.appSidebar.setAveragePlaceText(
        TextValueExtractor.getChromosomeTextValue(generationMetaInformation.getAverageCreature()));

    this.appSidebar.setWorstPlaceText(
        TextValueExtractor.getChromosomeTextValue(generationMetaInformation.getWorstCreature()));
    this.appSidebar.setGeneralInformationText(
        TextValueExtractor.getSimulationResultTextValue(generationMetaInformation));
  }

  public void refreshSidebarConfigurationTextValue(
      SimulationConfiguration simulationConfiguration) {
    this.appSidebar.setSimulationConfigurationText(
        TextValueExtractor.getSimulationConfigurationTextValue(simulationConfiguration));
  }

  public void connect(Simulator simulator) {
    this.simulator = simulator;
  }

  public void start() {

    this.simulator.start();
  }

  public void draw(Simulation simulation) {
    this.creaturesCanvas.draw(simulation);
  }

  public void drawCreature(CreatureChromosome creatureChromosome) {
    this.creaturesCanvas.drawCreature(creatureChromosome);
  }

  public void generateFood() {
    this.creaturesCanvas.generateFood();
  }
}
