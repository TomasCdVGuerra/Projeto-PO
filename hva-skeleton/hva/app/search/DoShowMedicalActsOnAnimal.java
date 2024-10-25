package hva.app.search;

import hva.core.Hotel;
import hva.core.Animal;
import hva.core.MedicalAct;
import hva.app.exception.UnknownAnimalKeyException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import hva.core.Hotel;

/**
 * Show all medical acts applied to a given animal.
 **/
class DoShowMedicalActsOnAnimal extends Command<Hotel> {

  // Add command fields
  private final Input<String> _animalId;

  DoShowMedicalActsOnAnimal(Hotel receiver) {
    super(Label.MEDICAL_ACTS_ON_ANIMAL, receiver);
    _animalId = _form.addStringInput(Message.requestAnimalId());
  }

  @Override
  protected void execute() throws CommandException {
    _form.parse();
    String animalId = _animalId.value();
    
    try {
      Animal animal = _receiver.getAnimal(animalId);
      List<MedicalAct> medicalActs = animal.getMedicalActs();
      
      if (medicalActs.isEmpty()) {
        _display.popup(Message.noMedicalActs(animalId));
      } else {
        for (MedicalAct act : medicalActs) {
          _display.addLine(act.toString());
        }
        _display.display();
      }
    } catch (UnknownAnimalKeyException e) {
      throw new CommandException(Message.unknownAnimalKey(animalId), e);
    }
  }
}