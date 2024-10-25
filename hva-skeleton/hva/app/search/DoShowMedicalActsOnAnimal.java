package hva.app.search;

import hva.app.animal.Prompt;
import hva.app.exception.UnknownAnimalKeyException;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;

/**
 * Show all medical acts applied to a given animal.
 **/
class DoShowMedicalActsOnAnimal extends Command<Hotel> {

  DoShowMedicalActsOnAnimal(Hotel receiver) {
    super(Label.MEDICAL_ACTS_ON_ANIMAL, receiver);
    addStringField("animalId", Prompt.animalKey());
  }

  @Override
  protected void execute() throws UnknownAnimalKeyException {
    String animalId = stringField("animalId");
    try {
      _receiver.getAnimal(animalId); // Check if animal exists
    } catch (UnknownAnimalKeyException e) {
      throw new UnknownAnimalKeyException(animalId);
    }

    StringBuilder result = new StringBuilder();
    for (String[] record : _receiver.getVaxHistory()) {
      if (record[2].equals(animalId)) {
        result.append("Vaccine ID: ").append(record[0])
              .append(", Veterinarian ID: ").append(record[1])
              .append("\n");
      }
    
      _display.popup(result.toString());
    
    }
  }
}