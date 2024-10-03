package hva.app.habitat;

import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import java.util.List;

/**
 * Show all habitats of this zoo hotel.
 **/
class DoShowAllHabitats extends Command<Hotel> {

  DoShowAllHabitats(Hotel receiver) {
    super(Label.SHOW_ALL_HABITATS, receiver);
  }

  @Override
  protected void execute() throws CommandException {
    List<Habitat> habitats = _receiver.getHabitats();
    for (Habitat habitat : habitats) {
      _display.addLine(habitat.getID() + " - " + habitat.getName() + " - Area: " + habitat.getArea());
    }
    _display.display();
  }
}
