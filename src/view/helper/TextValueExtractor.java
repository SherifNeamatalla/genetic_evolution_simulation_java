package view.helper;

import creatures.model.CreatureChromosome;
import geneticalgorithm.model.GenerationMetaInformation;
import simulation.model.SimulationConfiguration;

public class TextValueExtractor {

  public static String getSimulationResultTextValue(
      GenerationMetaInformation generationMetaInformation) {

    return "Generation : "
        + String.format("%d", generationMetaInformation.getGenerationCount())
        + "\n"
        + "Total creatures count : "
        + String.format("%d", generationMetaInformation.getPopulation().size())
        + "\n"
        + "\n"
        + "Highest Speed : "
        + String.format(
            "%.2f",
            generationMetaInformation
                .getGenerationHighestSpeedCreature()
                .getGene()
                .getSpeedPixelsPerTick())
        + "\n"
        + "Average Speed : "
        + String.format("%.2f", generationMetaInformation.getGenerationAverageSpeed())
        + "\n"
        + "Lowest Speed : "
        + String.format(
            "%.2f",
            generationMetaInformation
                .getGenerationLowestSpeedCreature()
                .getGene()
                .getSpeedPixelsPerTick())
        + "\n"
        + "\n"
        + "Highest vision range : "
        + String.format(
            "%.2f",
            generationMetaInformation
                .getGenerationHighestVisionRangeCreature()
                .getGene()
                .getVisionRange())
        + "\n"
        + "Average vision range : "
        + String.format("%.2f", generationMetaInformation.getGenerationAverageVisionRange())
        + "\n"
        + "Lowest vision range : "
        + String.format(
            "%.2f",
            generationMetaInformation
                .getGenerationLowestVisionRangeCreature()
                .getGene()
                .getVisionRange())
        + "\n"
        + "\n"
        + "Highest energy decay : "
        + String.format(
            "%.2f",
            generationMetaInformation
                .getGenerationHighestEnergyDecayCreature()
                .getGene()
                .getEnergyDecayPerTick())
        + "\n"
        + "Average energy decay : "
        + String.format("%.2f", generationMetaInformation.getGenerationAverageEnergyDecay())
        + "\n"
        + "Lowest energy decay : "
        + String.format(
            "%.2f",
            generationMetaInformation
                .getGenerationLowestEnergyDecayCreature()
                .getGene()
                .getEnergyDecayPerTick())
        + "\n"
        + "\n"
        + "Highest energy : "
        + String.format(
            "%.2f", generationMetaInformation.getGenerationHighestEnergyCreature().getEnergy())
        + "\n"
        + "Average energy : "
        + String.format("%.2f", generationMetaInformation.getGenerationAverageEnergy())
        + "\n"
        + "Lowest energy : "
        + String.format(
            "%.2f", generationMetaInformation.getGenerationLowestEnergyCreature().getEnergy())
        + "\n";
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
        + String.format("%.2f", creatureChromosome.getEnergy())
        + "\n"
        + "Speed per tick : "
        + String.format("%.2f", creatureChromosome.getGene().getSpeedPixelsPerTick())
        + "\n"
        + "Vision range ( in pixels ) : "
        + String.format("%.2f", creatureChromosome.getGene().getVisionRange())
        + "\n"
        + "Energy decay : "
        + String.format("%.2f", creatureChromosome.getGene().getEnergyDecayPerTick())
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
        + "\n"
        + "Sudden death rate : "
        + simulationConfiguration.getSuddenDeathRate()
        + "\n"
        + "Top population rate : "
        + simulationConfiguration.getTopPopulationRate()
        + "\n";
  }
}
