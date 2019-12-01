package geneticalgorithm;

public class AlgorithmLogger {

  public static boolean BEST_RESULT_LOGGING_ENABLED = false;
  public static boolean LOGGING_ENABLED = false;
  public static boolean MUTATION_LOGGING_ENABLED = false;

  static void log(String message) {
    if (LOGGING_ENABLED) System.out.println(message);
  }

  public static void logMutation() {
    if (MUTATION_LOGGING_ENABLED) System.out.println("Mutation happened!");
  }

  static void logGenerationResults(
      int generationNumber, double bestScore, double averageScore, double worstScore) {

    if (BEST_RESULT_LOGGING_ENABLED) {
      System.out.println("Generation " + generationNumber + " : ");
      System.out.println(
          "Best : " + bestScore + " Avg: " + averageScore + " Worst : " + worstScore);
    }
  }

  static void logGenerationResults(
      int generationNumber,
      double bestScore,
      String bestIndex,
      double averageScore,
      String averageIndex,
      double worstScore,
      String worstIndex) {

    if (BEST_RESULT_LOGGING_ENABLED) {
      System.out.println("Generation " + generationNumber + " : ");
      System.out.println(
          "Best : "
              + bestScore
              + " Index : "
              + bestIndex
              + " Avg: "
              + averageScore
              + " Index : "
              + averageIndex
              + " Worst : "
              + worstScore
              + " Index : "
              + worstIndex);
    }
  }
}
