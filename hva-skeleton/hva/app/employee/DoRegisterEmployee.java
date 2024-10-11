package hva.app.employee;

import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME add more imports if needed

/**
 * Adds a new employee to this zoo hotel.
 **/
class DoRegisterEmployee extends Command<Hotel> {

  DoRegisterEmployee(Hotel receiver) {
    super(Label.REGISTER_EMPLOYEE, receiver);
    addStringField("idEmployee", Prompt.employeeKey());
    addStringField("nomeEmployee", Prompt.employeeName());
    addStringField("typeEmployee", Prompt.employeeType());
    //FIXME add command fields
  }
  
  @Override
  protected void execute() throws CommandException {
    String employeeId = stringField("idEmployee");
    String name = stringField("nomeEmployee");
    String empType= stringField("typeEmployee");
    _receiver.registerEmployee(employeeId, name, empType);
    //FIXME implement command
  }
}
