package hva.app.animal;

import hva.app.exception.UnknownAnimalKeyException;
import hva.app.exception.UnknownHabitatKeyException;
import hva.core.Animal;
import hva.core.Habitat;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Transfers a given animal to a new habitat of this zoo hotel.
 */
class DoTransferToHabitat extends Command<Hotel> {

  DoTransferToHabitat(Hotel hotel) {
    super(Label.TRANSFER_ANIMAL_TO_HABITAT, hotel);
    addStringField("animalId", "Animal ID");
    addStringField("habitatId", "New Habitat ID");
  }
  
  @Override
  protected final void execute() throws CommandException {
  String animalId = stringField("animalId");
  String habitatId = stringField("habitatId");

  try {
    Animal animal = _receiver.getAnimal(animalId);  // Ensure _receiver has this method
    Habitat newHabitat = _receiver.getHabitat(habitatId);  // Ensure _receiver has this method

    animal.setHabitat(newHabitat);  // Ensure Animal class has this method

    _display.popup("Animal " + animalId + " has been transferred to habitat " + habitatId);

  } catch (UnknownAnimalKeyException e) {
    throw new UnknownAnimalKeyException(animalId);  // Re-throw the correct exception
  } catch (UnknownHabitatKeyException e) {
    throw new UnknownHabitatKeyException(habitatId);  // Re-throw the correct exception
  }
  }
}

