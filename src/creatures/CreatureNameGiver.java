package creatures;

public class CreatureNameGiver {

  private static int currentCount = 0;

  public static String getNextCount() {
    return String.valueOf(currentCount++);
  }
}
