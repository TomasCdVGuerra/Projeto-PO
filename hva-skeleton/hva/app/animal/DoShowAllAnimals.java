package hva.app.animal;

import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import java.util.Iterator;

//FIXME add more imports if needed

/**
 * Show all animals registered in this zoo hotel.
 */
class DoShowAllAnimals extends Command<Hotel> {
  private String _toPrint;


  DoShowAllAnimals(Hotel receiver) {
    super(Label.SHOW_ALL_ANIMALS, receiver);
  }
  
  @Override
  protected final void execute() {
    _display.popup(_receiver.getAnimals());
    //FIXME implement command
  }
}
