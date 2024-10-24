package hva.app.vaccine;
//FIXME
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;

/**
 * Vaccinate by a given veterinarian a given animal with a given vaccine.
 **/
class DoVaccinateAnimal extends Command<Hotel> {
  
  DoVaccinateAnimal(Hotel receiver) {
    super(Label.VACCINATE_ANIMAL, receiver);
    addStringField("animalId", Prompt.animalKey());
    addStringField("vaccineId", Prompt.vaccineKey());
    addStringField("veterinarianId", Prompt.veterinarianKey());
  }

  @Override
  protected final void execute() {
    String animalId = stringField("animalId");
    String vaccineId = stringField("vaccineId");
    String veterinarianId = stringField("veterinarianId");
/*
    try {
      if (!_receiver.isAuthorized(veterinarianId, _receiver.getAnimal(animalId).getSpecies())) {
        throw new VeterinarianNotAuthorizedException(veterinarianId, _receiver.getAnimal(animalId).getSpecies());
      }
      _receiver.vaccinateAnimal(animalId, vaccineId, veterinarianId);
      _display.popup("Vacinação realizada com sucesso.");
    } catch (UnknownAnimalKeyException e) {
      throw new UnknownAnimalKeyException("Unknown animal ID: " + animalId, e);
    } catch (UnknownVaccineKeyException e) {
      throw new UnknownVaccineKeyException("Unknown vaccine ID: " + vaccineId, e);
    } catch (UnknownVeterinarianKeyException e) {
      throw new UnknownVeterinarianKeyException("Unknown veterinarian ID: " + veterinarianId, e);
    } catch (VeterinarianNotAuthorizedException e) {
      throw new VeterinarianNotAuthorizedException("Veterinarian not authorized to vaccinate this species: " + veterinarianId, e);
    }
  }
  */
}
}