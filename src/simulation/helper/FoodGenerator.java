package simulation.helper;

import creatures.PositionCreator;
import simulation.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FoodGenerator {

  public static List<Food> generateFood(int count) {

    List<Food> food = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      food.add(new Food(PositionCreator.buildRandomPosition()));
    }
    return food;
  }
}
