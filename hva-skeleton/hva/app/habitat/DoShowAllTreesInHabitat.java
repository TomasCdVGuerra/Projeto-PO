package hva.app.habitat;

import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show all trees in a given habitat.
 **/
class DoShowAllTreesInHabitat extends Command<Hotel> {

  DoShowAllTreesInHabitat(Hotel receiver) {
    super(Label.SHOW_TREES_IN_HABITAT, receiver);
    addStringField("idHabitat", Prompt.habitatKey());
  }
  
  @Override
  protected void execute() throws CommandException {
    String habitatId = stringField("idHabitat");
    
    _display.popup(_receiver.getTrees(habitatId));
  }
}
