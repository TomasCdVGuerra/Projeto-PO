package hva.app.vaccine;

import hva.core.Hotel;
import hva.core.Vaccine;
import hva.core.Animal;
import hva.core.Veterinarian;
import hva.app.exception.UnknownAnimalKeyException;
import hva.app.exception.UnknownVaccineKeyException;
import hva.app.exception.UnknownVeterinarianKeyException;
import hva.app.exception.VeterinarianNotAuthorizedException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;

// Add more imports if needed

/**
 * Vaccinate by a given veterinarian a given animal with a given vaccine.
 **/
class DoVaccinateAnimal extends Command<Hotel> {
  private Form _form = new Form();
  private String _veterinarianId;
  private String _animalId;
  private String _vaccineId;

  DoVaccinateAnimal(Hotel receiver) {
    super(Label.VACCINATE_ANIMAL, receiver);
    _form.addFieldString("veterinarianId", Message.requestVeterinarianId());
    _form.addFieldString("animalId", Message.requestAnimalId());
    _form.addFieldString("vaccineId", Message.requestVaccineId());
  }

  @Override
  protected final void execute() throws CommandException {
    _form.parse();
    _veterinarianId = _form.stringField("veterinarianId");
    _animalId = _form.stringField("animalId");
    _vaccineId = _form.stringField("vaccineId");

    try {
      Vaccine vaccine = _receiver.getVaccine(_vaccineId);
      Animal animal = _receiver.getAnimal(_animalId);
      if (!_receiver.isAuthorized(_veterinarianId, animal.getSpeciesId())) {
        throw new VeterinarianNotAuthorizedException(_veterinarianId, animal.getSpeciesId());
      }
      animal.vaccinate(vaccine);
    } catch (UnknownVaccineKeyException | UnknownAnimalKeyException | UnknownVeterinarianKeyException e) {
      throw new CommandException(e.getMessage());
    }
  }
}