package hva.app.vaccine;

import hva.core.Hotel;
import hva.app.exception.UnknownAnimalKeyException;
import hva.app.exception.VeterinarianNotAuthorizedException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

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
  protected final void execute() throws CommandException {
    String animalId = stringField("animalId");
    String vaccineId = stringField("vaccineId");
    String veterinarianId = stringField("veterinarianId");

    try {
      _receiver.vaccinateAnimal(animalId, vaccineId, veterinarianId);
      _display.popup("Vacinação realizada com sucesso.");
    } catch (UnknownAnimalKeyException e) {
      throw new CommandException(Message.unknownAnimalKey(animalId));
    } catch (VeterinarianNotAuthorizedException e) {
      throw new CommandException(Message.veterinarianNotAuthorized(veterinarianId));
    }
  }
}