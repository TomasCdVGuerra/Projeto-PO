package hva.app.animal;

import hva.core.Animal;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show all animals registered in this zoo hotel.
 */
class DoShowAllAnimals extends Command<Hotel> {

  DoShowAllAnimals(Hotel receiver) {
    super(Label.SHOW_ALL_ANIMALS, receiver);
  }
  
  @Override
  protected final void execute() throws CommandException {
    for (Animal animal : _receiver.getAnimals()) {
      _display.addLine(animal.toString());
    }
    _display.display();
  }
}