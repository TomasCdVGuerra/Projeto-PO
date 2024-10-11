package hva.app.vaccine;

import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME add more imports if needed

/**
 * Apply a vaccine to a given animal.
 **/
class DoRegisterVaccine extends Command<Hotel> {

  DoRegisterVaccine(Hotel receiver) {
    super(Label.REGISTER_VACCINE, receiver);
    addStringField("idVaccine", Prompt.vaccineKey());
    addStringField("nameVaccine", Prompt.vaccineName());
    addStringField("idSpecies", Prompt.listOfSpeciesKeys());
    //FIXME add command fields
  }

  @Override
  protected final void execute() throws CommandException {
    String vaccineId = stringField("idVaccine");
    String name = stringField("nameVaccine");
    String speciesIds = stringField("idSpecies");
    String[] arraySpeciesIds = speciesIds.split(",");
    _receiver.registerVaccine(vaccineId, name, arraySpeciesIds);
    //FIXME implement command
  }
}
