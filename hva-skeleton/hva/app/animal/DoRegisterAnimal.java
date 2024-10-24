package hva.app.animal;

import hva.app.exception.UnknownSpeciesKeyException;
import hva.core.Habitat;
import hva.core.Hotel;
import hva.core.Species;
import pt.tecnico.uilib.forms.Form;
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
    addStringField("idHabitat", Prompt.habitatKey());

  }
  
  @Override
  protected final void execute() throws CommandException {
    String animalId = stringField("idAnimal");
    String name = stringField("nomeAnimal");
    String speciesId = stringField("idSpecies");

    String habitatId = stringField("idHabitat");

    try {
      Species species = _receiver.getSpecies(speciesId);
    } catch (UnknownSpeciesKeyException e) {
      String newSpeciesName = Form.requestString("Species not found. Enter the name of the new species:");
      _receiver.registerSpecies(speciesId, newSpeciesName);
    }

    _receiver.registerAnimal(animalId, name, speciesId, habitatId);
    Species species = _receiver.getSpecies(speciesId);
    species.addAnimal(animalId);
    Habitat habitat = _receiver.getHabitat(habitatId);
    habitat.addAnimal(_receiver.getAnimal(animalId));
    habitat.addSpecies(species);
  }
}