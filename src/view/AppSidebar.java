package view;

import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;

public class AppSidebar extends VBox {

  private String bestPlaceText;

  private String averagePlaceText;

  private String worstPlaceText;

  private TextArea bestTextArea;
  private TextArea averageTextArea;

  private TextArea worstTextArea;

  private MainView mainView;

  public AppSidebar(MainView mainView) {

    this.mainView = mainView;
    this.bestTextArea = new TextArea();
    this.averageTextArea = new TextArea();
    this.worstTextArea = new TextArea();

    this.bestTextArea.setDisable(true);
    this.averageTextArea.setDisable(true);
    this.worstTextArea.setDisable(true);

    this.getChildren().add(new Label("Best "));
    this.getChildren().add(bestTextArea);

    this.getChildren().add(new Label("Average  "));
    this.getChildren().add(averageTextArea);

    this.getChildren().add(new Label("Worst "));
    this.getChildren().add(worstTextArea);
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
}
