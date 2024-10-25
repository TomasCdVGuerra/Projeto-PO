package hva.app.employee;

import hva.app.exception.NoResponsibilityException;
import hva.app.exception.UnknownEmployeeKeyException;
import hva.core.Employee;
import hva.core.Hotel;
import hva.core.Veterinarian;
import hva.core.Zookeeper;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Add a new responsibility to an employee: species to veterinarians and 
 * habitats to zookeepers.
 **/
class DoAddResponsibility extends Command<Hotel> {

  DoAddResponsibility(Hotel receiver) {
    super(Label.ADD_RESPONSIBILITY, receiver);  // Corrected constant name
    addStringField("employeeId", hva.app.employee.Prompt.employeeKey());
    addStringField("responsibility", hva.app.employee.Prompt.responsibilityKey());
  }
  
  @Override
  protected void execute() throws CommandException {
    String employeeId = stringField("employeeId");
    String responsibility = stringField("responsibility");

    try {
      Employee employee = _receiver.getEmployee(employeeId);

      if (employee instanceof Veterinarian vet) {
        vet.addSpeciesResponsibility(responsibility);
      } else if (employee instanceof Zookeeper keeper) {
        keeper.addHabitatResponsibility(responsibility);
      } else {
        throw new NoResponsibilityException(employeeId, responsibility);
      }

      _display.popup("Responsibility added to employee " + employeeId);

    } catch (UnknownEmployeeKeyException e) {
      throw new UnknownEmployeeKeyException("Unknown employee ID: " + employeeId);
    } catch (NoResponsibilityException e) {
      throw new NoResponsibilityException(employeeId, responsibility);
    }
  }
}