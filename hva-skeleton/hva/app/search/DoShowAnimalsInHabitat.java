package hva.app.search;

import hva.app.exception.UnknownHabitatKeyException;
import hva.core.Animal;
import hva.core.Habitat;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Show all animals of a given habitat.
 **/
class DoShowAnimalsInHabitat extends Command<Hotel> {

  DoShowAnimalsInHabitat(Hotel receiver) {
    super(Label.ANIMALS_IN_HABITAT, receiver);
    addStringField("habitatId", "Identificador único do habitat: ");
  }

  @Override
  protected void execute() throws CommandException {
    String habitatId = stringField("habitatId");
    Habitat habitat;

    try {
      habitat = _receiver.getHabitat(habitatId);
    } catch (UnknownHabitatKeyException e) {
      throw new UnknownHabitatKeyException(habitatId);
    }

    List<Animal> animals = habitat.getAnimals();
    
    // Sort the animals by their ID
    Collections.sort(animals, new Comparator<Animal>() {
      @Override
      public int compare(Animal a1, Animal a2) {
        return a1.getId().compareTo(a2.getId());
      }
    });

    // Add each animal to the display
    for (Animal animal : animals) {
      _display.addLine(animal.toString());
    }
    
    // Display the sorted list
    _display.display();
  }
}