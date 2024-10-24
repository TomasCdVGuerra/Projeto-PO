package hva.app.vaccine;

import hva.core.Hotel;
import hva.core.Vaccine;
import hva.core.Animal;
import hva.app.exception.UnknownAnimalKeyException;
import hva.app.exception.UnknownVaccineKeyException;
import hva.app.exception.UnknownVeterinarianKeyException;
import hva.app.exception.VeterinarianNotAuthorizedException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import pt.tecnico.uilib.forms.Form;

/**
 * Vaccinate by a given veterinarian a given animal with a given vaccine.
 **/
class DoVaccinateAnimal extends Command<Hotel> {
  private final Form _form = new Form();
  private String _veterinarianId;
  private String _animalId;
  private String _vaccineId;

  DoVaccinateAnimal(Hotel receiver) {
    super(Label.VACCINATE_ANIMAL, receiver);
    _form.addStringField("veterinarianId", Message.requestVeterinarianId());
    _form.addStringField("animalId", Message.requestAnimalId());
    _form.addStringField("vaccineId", Message.requestVaccineId());
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
      if (!_receiver.isAuthorized(_veterinarianId, animal.getSpecies())) {
        throw new VeterinarianNotAuthorizedException(_veterinarianId, animal.getSpecies());
      }
      _receiver.vaccinateAnimal(_animalId, _vaccineId, _veterinarianId);
    } catch (UnknownVaccineKeyException | UnknownAnimalKeyException | UnknownVeterinarianKeyException e) {
      throw new CommandException(e.getMessage());
    }
  }
}