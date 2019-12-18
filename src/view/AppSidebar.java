package view;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class AppSidebar extends VBox {

  private String bestPlaceText;

  private String averagePlaceText;

  private String worstPlaceText;

  private String generalInformationText;

  private String simulationConfigurationText;

  private TextArea bestTextArea;
  private TextArea averageTextArea;

  private TextArea worstTextArea;

  private TextArea generalInformationTextArea;

  private TextArea simulationConfigurationTextArea;

  private MainView mainView;

  public AppSidebar(MainView mainView) {

    this.mainView = mainView;
    this.bestTextArea = new TextArea();
    this.averageTextArea = new TextArea();
    this.worstTextArea = new TextArea();
    this.generalInformationTextArea = new TextArea();
    this.simulationConfigurationTextArea = new TextArea();

    this.bestTextArea.setEditable(false);
    this.averageTextArea.setEditable(false);
    this.worstTextArea.setEditable(false);
    this.generalInformationTextArea.setEditable(false);
    this.simulationConfigurationTextArea.setEditable(false);


    this.getChildren().add(new Label("Simulation configuration "));
    this.getChildren().add(simulationConfigurationTextArea);

    this.getChildren().add(new Label("Best "));
    this.getChildren().add(bestTextArea);

    this.getChildren().add(new Label("Average  "));
    this.getChildren().add(averageTextArea);

    this.getChildren().add(new Label("Worst "));
    this.getChildren().add(worstTextArea);

    this.getChildren().add(new Label("General Information "));
    this.getChildren().add(generalInformationTextArea);
  }

  public void setBestPlaceText(String bestPlaceText) {
    this.bestTextArea.setText(bestPlaceText);
  }

  public void setAveragePlaceText(String averagePlaceText) {
    this.averageTextArea.setText(averagePlaceText);
  }

  public void setWorstPlaceText(String worstPlaceText) {
    this.worstTextArea.setText(worstPlaceText);
  }

  public void setGeneralInformationText(String generalInformation) {
    this.generalInformationTextArea.setText(generalInformation);
  }

  public void setSimulationConfigurationText(String simulationConfiguration) {
    this.simulationConfigurationTextArea.setText(simulationConfiguration);
  }
}
