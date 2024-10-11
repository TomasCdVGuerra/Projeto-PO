package hva.app.habitat;

import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME add more imports if needed

/**
 * Add a new habitat to this zoo hotel.
 **/
class DoRegisterHabitat extends Command<Hotel> {

  DoRegisterHabitat(Hotel receiver) {
    super(Label.REGISTER_HABITAT, receiver);
    addStringField("idHabitat", Prompt.habitatKey());
    addStringField("nomeHabitat", Prompt.habitatName());
    addIntegerField("areaHabitat", Prompt.habitatArea());
    //FIXME add command fields
  }
  
  @Override
  protected void execute() throws CommandException {
    String habitatId = stringField("idHabitat");
    String name = stringField("nomeHabitat");
    int area = integerField("areaHabitat");
    _receiver.registerHabitat(habitatId, name, area);
    //FIXME implement command
  }
}
