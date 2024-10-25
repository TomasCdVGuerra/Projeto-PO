package hva.app.vaccine;
import hva.app.exception.UnknownAnimalKeyException;
import hva.app.exception.UnknownVaccineKeyException;
import hva.app.exception.UnknownSpeciesKeyException;
import hva.app.exception.VeterinarianNotAuthorizedException;
import hva.core.Hotel;
import hva.core.Animal;
import hva.core.Vaccine;
import pt.tecnico.uilib.menus.Command;

/**
 * Vaccinate by a given veterinarian a given animal with a given vaccine.
 **/
class DoVaccinateAnimal extends Command<Hotel> {
  
  DoVaccinateAnimal(Hotel receiver) {
    super(Label.VACCINATE_ANIMAL, receiver);
    addStringField("vaccineId", Prompt.vaccineKey());
    addStringField("veterinarianId", Prompt.veterinarianKey());
    addStringField("animalId", hva.app.vaccine.Prompt.animalKey());
  }

  @Override
  protected final void execute() throws UnknownSpeciesKeyException, UnknownAnimalKeyException, UnknownVaccineKeyException, VeterinarianNotAuthorizedException {
    String vaccineId = stringField("vaccineId");
    String veterinarianId = stringField("veterinarianId");
    String animalId = stringField("animalId");

    try {
      if (!_receiver.vetIsAuthorized(veterinarianId, _receiver.getAnimal(animalId).getSpecies())) 
        throw new VeterinarianNotAuthorizedException(veterinarianId, _receiver.getAnimal(animalId).getSpecies());
      
      else if(!_receiver.vacIsAuthorized(vaccineId, _receiver.getAnimal(animalId).getSpecies()))
        _display.popup(Message.wrongVaccine(vaccineId, animalId));
      
      else{
      _receiver.vaccinateAnimal(animalId, vaccineId, veterinarianId);
      Animal animal = _receiver.getAnimal(animalId);
      Vaccine vaccine = _receiver.getVaccine(vaccineId);
      _receiver.addVaxHistory(vaccineId, veterinarianId, animal.getSpecies());
      animal.addVaccinationResult(vaccine.calculateDamage(_receiver.getSpecies(animal.getSpecies())));
    }
    }catch (UnknownAnimalKeyException e) {
      throw new UnknownAnimalKeyException(animalId);
  } catch (UnknownSpeciesKeyException e) {
    throw new UnknownSpeciesKeyException(animalId);
}
  }
}