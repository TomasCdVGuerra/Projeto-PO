package hva.app.employee;

import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Adds a new employee to this zoo hotel.
 **/
class DoRegisterEmployee extends Command<Hotel> {

  DoRegisterEmployee(Hotel receiver) {
    super(Label.REGISTER_EMPLOYEE, receiver);
    addStringField("idEmployee", Prompt.employeeKey());
    addStringField("nomeEmployee", Prompt.employeeName());
    addOptionField("typeEmployee", Prompt.employeeType(), "TRT", "VET");
  }
  
  @Override
  protected void execute() throws CommandException {
    String employeeId = stringField("idEmployee");
    String name = stringField("nomeEmployee");
    String empType = stringField("typeEmployee");

    _receiver.registerEmployee(employeeId, name, empType);
  }
}
