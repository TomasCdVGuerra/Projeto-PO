package hva.app.search;

import hva.core.Hotel;
import hva.core.Animal;
import hva.core.Habitat;
import hva.app.exception.UnknownHabitatKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.form.Form;

/**
 * Show all animals of a given habitat.
 **/
class DoShowAnimalsInHabitat extends Command<Hotel> {

  DoShowAnimalsInHabitat(Hotel receiver) {
    super(Label.ANIMALS_IN_HABITAT, receiver);
    addStringField("habitatId", Message.requestHabitatId());
  }

  @Override
  protected void execute() throws CommandException {
    String habitatId = stringField("habitatId");
    Habitat habitat;

    try {
      habitat = _receiver.getHabitat(habitatId);
    } catch (UnknownHabitatKeyException e) {
      throw new UnknownHabitatKeyException(e.getMessage());
    }

    for (Animal animal : habitat.getAnimals()) {
      _display.addLine(animal.toString());
    }
    _display.display();
  }
}