package view;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AppToolbar extends HBox {

  private MainView mainView;
  private TextField generationsCount;

  public AppToolbar(MainView mainView) {
    this.mainView = mainView;

    this.generationsCount = new TextField();
    this.generationsCount
        .textProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              if (!newValue.matches("\\d*")) {
                generationsCount.setText(newValue.replaceAll("[^\\d]", ""));
              }
            });

    generateButtons();
  }

  private void generateButtons() {
    Button nextGeneration = new Button("Next Generation");
    nextGeneration.setOnAction(this::nextAction);

    Button start = new Button("Start");
    start.setOnAction(this::startAction);
    this.getChildren().addAll(start, nextGeneration, generationsCount);
  }

  private void startAction(ActionEvent actionEvent) {
    this.mainView.start();
  }

  private void nextAction(ActionEvent actionEvent) {

    int generationsCount = 1;
    String text = this.generationsCount.getText();
    if (text != null && !text.isEmpty()) generationsCount = Integer.parseInt(text);
    if (text == null) this.mainView.nextGeneration();
  }
}
