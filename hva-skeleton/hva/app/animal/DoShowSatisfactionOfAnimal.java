package hva.app.animal;

import hva.app.exception.UnknownAnimalKeyException;
import hva.app.exception.UnknownHabitatKeyException;
import hva.core.Animal;
import hva.core.Habitat;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Shows the satisfaction of a given animal.
 */
class DoShowSatisfactionOfAnimal extends Command<Hotel> {

  DoShowSatisfactionOfAnimal(Hotel receiver) {
    super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);
    addStringField("animalId", hva.app.animal.Prompt.animalKey());
  }

  @Override
  protected final void execute() throws CommandException {
    String animalId = stringField("animalId");

    // Assuming getAnimal may return null if the animal is not found, handle that case
    Animal animal = _receiver.getAnimal(animalId);
    if (animal == null) {
      // Directly throw the UnknownAnimalKeyException if the animal is not found
      throw new UnknownAnimalKeyException(animalId);
    }

    Habitat habitat = animal.getHabitat();
    if (habitat == null) {
      // Directly throw the UnknownAnimalKeyException if the animal is not found
      throw new UnknownHabitatKeyException(animalId);
    }
    
    _display.popup("Identificador único do animal: " + Math.round(animal.satisfaction()));
  }
}
