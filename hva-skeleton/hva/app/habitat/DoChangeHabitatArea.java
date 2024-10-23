package hva.app.habitat;

import hva.app.exception.UnknownHabitatKeyException;
import hva.core.Habitat;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Change the area of a given habitat.
 **/
class DoChangeHabitatArea extends Command<Hotel> {

  DoChangeHabitatArea(Hotel receiver) {
    super(Label.CHANGE_HABITAT_AREA, receiver);
    addStringField("habitatId", "Habitat ID");
    addIntegerField("habitatArea", "New Habitat Area");
  }
  
  @Override
  protected void execute() throws CommandException {
    String habitatId = stringField("habitatId");
    int habitatArea = integerField("habitatArea");
    
    if (habitatArea < 0) {
      throw new IllegalArgumentException("Area cannot be negative");
    }

    try {
    Habitat habitat = _receiver.getHabitat(habitatId);

    habitat.setArea(habitatArea);

  } catch (UnknownHabitatKeyException e) {
    throw new UnknownHabitatKeyException(habitatId);
  }
  }
}
