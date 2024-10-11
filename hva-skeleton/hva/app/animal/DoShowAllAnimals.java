package hva.app.animal;

import hva.core.Hotel;
import pt.tecnico.uilib.Display;
import pt.tecnico.uilib.menus.Command;

//FIXME add more imports if needed

/**
 * Show all animals registered in this zoo hotel.
 */
class DoShowAllAnimals extends Command<Hotel> {


  DoShowAllAnimals(Hotel receiver) {
    super(Label.SHOW_ALL_ANIMALS, receiver);
  }
  
  @Override
  protected final void execute() {
    Display display = new Display();
    display.popup(_receiver.getAnimals());
    //FIXME implement command
  }
}

