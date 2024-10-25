package hva.app.vaccine;
import hva.app.exception.UnknownAnimalKeyException;
import hva.app.exception.UnknownVaccineKeyException;
import hva.app.exception.VeterinarianNotAuthorizedException;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;

/**
 * Vaccinate by a given veterinarian a given animal with a given vaccine.
 **/
class DoVaccinateAnimal extends Command<Hotel> {
  
  DoVaccinateAnimal(Hotel receiver) {
    super(Label.VACCINATE_ANIMAL, receiver);
    addStringField("vaccineId", Prompt.vaccineKey());
    addStringField("veterinarianId", Prompt.veterinarianKey());
    addStringField("animalId", Prompt.animalKey());
  }

  @Override
  protected final void execute() throws UnknownAnimalKeyException, UnknownVaccineKeyException, VeterinarianNotAuthorizedException {
    String vaccineId = stringField("vaccineId");
    String veterinarianId = stringField("veterinarianId");
    String animalId = stringField("animalId");

    try {
      if (!_receiver.vetIsAuthorized(veterinarianId, _receiver.getAnimal(animalId).getSpecies())) {
        throw new VeterinarianNotAuthorizedException(veterinarianId, _receiver.getAnimal(animalId).getSpecies());
      }
      else if(!_receiver.vacIsAuthorized(vaccineId, _receiver.getAnimal(animalId).getSpecies())){
        throw new IllegalArgumentException(hva.app.vaccine.Message.wrongVaccine(vaccineId, animalId));
      }
      _receiver.vaccinateAnimal(animalId, vaccineId, veterinarianId);
      _display.popup("Vacinação realizada com sucesso.");
    } catch (UnknownAnimalKeyException e) {
      throw new UnknownAnimalKeyException(animalId);
  }
  }
}