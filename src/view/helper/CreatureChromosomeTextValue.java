package view.helper;

import creatures.model.CreatureChromosome;

public class CreatureChromosomeTextValue {

  public static String getTextValue(CreatureChromosome creatureChromosome) {

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
        + "\n";
  }
}
