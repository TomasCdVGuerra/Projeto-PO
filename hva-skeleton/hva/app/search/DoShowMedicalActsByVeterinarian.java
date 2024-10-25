package hva.app.search;

import hva.app.exception.UnknownEmployeeKeyException;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show all medical acts of a given veterinarian.
 **/
class DoShowMedicalActsByVeterinarian extends Command<Hotel> {
  DoShowMedicalActsByVeterinarian(Hotel receiver) {
    super(Label.MEDICAL_ACTS_BY_VET, receiver);
    addStringField("vetId", hva.app.employee.Prompt.employeeKey());
  }
  
  @Override
  protected void execute() throws CommandException {
    String vetId = stringField("vetId");
    try {
      _receiver.getEmployee(vetId); // Check if veterinarian exists
    } catch (UnknownEmployeeKeyException e) {
      throw new UnknownEmployeeKeyException(vetId);
    }

    StringBuilder result = new StringBuilder();
    for (String[] record : _receiver.getVaxHistory()) {
      if (record[1].equals(vetId)) {
        result.append("Vaccine ID: ").append(record[0])
              .append(", Animal ID: ").append(record[2])
              .append("\n");
      }
    }
}
}