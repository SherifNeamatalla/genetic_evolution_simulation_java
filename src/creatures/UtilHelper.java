package creatures;

import java.util.Random;

public class UtilHelper {

  public static double getDistance(double lat1, double lng1, double lat2, double lng2) {

    double firstSum = Math.abs(lat1 - lat2);
    double secondSum = Math.abs(lng1 - lng2);

    return Math.sqrt(Math.pow(firstSum, 2) + Math.pow(secondSum, 2));
  }

  public static double randomDouble(double min, double max) {
    if (min >= max) {
      throw new IllegalArgumentException("max must be greater than min");
    }
    Random r = new Random(System.currentTimeMillis());
    return min + (max - min) * r.nextDouble();
  }
}
