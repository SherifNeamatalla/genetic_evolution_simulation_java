package view.helper;

import creatures.model.CreatureChromosome;
import simulation.model.SimulationConfiguration;
import simulation.model.SimulationResult;

public class TextValueExtractor {

  public static String getSimulationResultTextValue(SimulationResult simulationResult) {

    return "Total creatures count : " + simulationResult.getPopulation().size();
  }

  public static String getChromosomeTextValue(CreatureChromosome creatureChromosome) {

    String status = creatureChromosome.getEnergy() > 0 ? "Alive" : "Dead";
    return "Name : "
        + creatureChromosome.getCreatureName()
        + "\n"
        + "Food count : "
        + creatureChromosome.getFoodCount()
        + "\n"
        + "Energy left : "
        + creatureChromosome.getEnergy()
        + "\n"
        + "Speed per tick : "
        + creatureChromosome.getGene().getSpeedPixelsPerTick()
        + "\n"
        + "Vision range : "
        + creatureChromosome.getGene().getVisionRange()
        + " blocks"
        + "\n"
        + "Energy decay : "
        + creatureChromosome.getGene().getEnergyDecayPerTick()
        + "\n"
        + "Status : "
        + status
        + "\n";
  }

  public static String getSimulationConfigurationTextValue(
      SimulationConfiguration simulationConfiguration) {
    return "Ticks per second : "
        + simulationConfiguration.getTicksPerSecond()
        + "\n"
        + "Ticks per round : "
        + simulationConfiguration.getTicksPerRound()
        + "\n"
        + "Food cound : "
        + simulationConfiguration.getFoodCount()
        + "\n"
        + "Start population count : "
        + simulationConfiguration.getStartPopulationCount()
        + "\n"
        + "Crossover rate : "
        + simulationConfiguration.getCrossoverRate()
        + "\n"
        + "Mutation rate : "
        + simulationConfiguration.getMutationRate()
        + "\n";
  }
}
