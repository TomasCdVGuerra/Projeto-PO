package hva.app.vaccine;

import hva.app.exception.DuplicateVaccineKeyException;
import hva.app.exception.UnknownSpeciesKeyException;
import hva.core.Hotel;
import hva.core.Vaccine;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Apply a vaccine to a given animal.
 **/
class DoRegisterVaccine extends Command<Hotel> {

  DoRegisterVaccine(Hotel receiver) {
    super(Label.REGISTER_VACCINE, receiver);
    addStringField("idVaccine", Prompt.vaccineKey());
    addStringField("nameVaccine", Prompt.vaccineName());
    addStringField("idSpecies", Prompt.listOfSpeciesKeys());
  }

  @Override
  protected final void execute() throws CommandException {
    String vaccineId = stringField("idVaccine");
    for(Vaccine i : _receiver.getVaccines()){
      if(i.getId().equals(vaccineId))
        throw new DuplicateVaccineKeyException(vaccineId);
    }
    String name = stringField("nameVaccine");
    String speciesIds = stringField("idSpecies");
    String[] arraySpeciesIds = speciesIds.split(",");
    for(String i : arraySpeciesIds){
      if(_receiver.getSpecies(i)==null)
        throw new UnknownSpeciesKeyException(i);
    }

    _receiver.registerVaccine(vaccineId, name, arraySpeciesIds);
  }
}
