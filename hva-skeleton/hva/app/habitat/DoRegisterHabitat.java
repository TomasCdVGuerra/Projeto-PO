package hva.app.habitat;

import hva.app.exception.DuplicateHabitatKeyException;
import hva.core.Habitat;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Add a new habitat to this zoo hotel.
 **/
class DoRegisterHabitat extends Command<Hotel> {

  DoRegisterHabitat(Hotel receiver) {
    super(Label.REGISTER_HABITAT, receiver);
    addStringField("idHabitat", Prompt.habitatKey());
    addStringField("nomeHabitat", Prompt.habitatName());
    addIntegerField("areaHabitat", Prompt.habitatArea());
  }
  
  @Override
  protected void execute() throws CommandException {
    String habitatId = stringField("idHabitat");
    String name = stringField("nomeHabitat");
    int area = integerField("areaHabitat");

    for(Habitat hbtId : _receiver.getHabitats()){
      if (habitatId.equals(hbtId.getId()))
        throw new DuplicateHabitatKeyException(habitatId);
    }

    _receiver.registerHabitat(habitatId, name, area);
  }
}
