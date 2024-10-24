package hva.app.animal;

import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME
/**
 * Register a new animal in this zoo hotel.
 */
class DoRegisterAnimal extends Command<Hotel> {

  DoRegisterAnimal(Hotel receiver) {
    super(Label.REGISTER_ANIMAL, receiver);
    addStringField("idAnimal", Prompt.animalKey());
    addStringField("nomeAnimal", Prompt.animalName());
    addStringField("idSpecies", Prompt.speciesKey());
    
    /* String speciesId = stringField("idSpecies");
    addStringField("nomeSpecies", Prompt.speciesName());
    String speciesName = stringField("nomeSpecies");
    _receiver.registerSpecies(speciesId, speciesName);
     */
    addStringField("idHabitat", Prompt.habitatKey());

  }
  
  @Override
  protected final void execute() throws CommandException {
    String animalId = stringField("idAnimal");
    String name = stringField("nomeAnimal");
    String speciesId = stringField("idSpecies");

    String habitatId = stringField("idHabitat");
    _receiver.registerAnimal(animalId, name, speciesId, habitatId);
  }
}
