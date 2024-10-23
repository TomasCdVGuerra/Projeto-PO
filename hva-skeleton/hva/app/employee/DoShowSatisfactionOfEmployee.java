package hva.app.employee;

import hva.app.exception.UnknownEmployeeKeyException;
import hva.core.Employee;
import hva.core.Habitat;
import hva.core.Hotel;
import hva.core.Veterinarian;
import hva.core.Zookeeper;
import java.util.Map;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show the satisfaction of a given employee.
 **/
class DoShowSatisfactionOfEmployee extends Command<Hotel> {

  DoShowSatisfactionOfEmployee(Hotel receiver) {
    super(Label.SHOW_SATISFACTION_OF_EMPLOYEE, receiver);
    addStringField("employeeId", "Employee ID");
  }
  
  @Override
  protected void execute() throws CommandException {
    String employeeId = stringField("employeeId");

    try {
      Employee employee = _receiver.getEmployee(employeeId);
      int satisfaction = 0;

      if (employee instanceof Veterinarian vet) {
        Map<String, Integer> speciesAnimalCount = _receiver.getSpeciesAnimalCount();
        Map<String, Integer> speciesVetCount = _receiver.getSpeciesVetCount();
        satisfaction = vet.calculateSatisfaction(speciesAnimalCount, speciesVetCount);
      } else if (employee instanceof Zookeeper keeper) {
        Map<String, Habitat> habitats = _receiver.getMapHabitats(); // Use getMapHabitats
        Map<String, Integer> habitatZookeeperCount = _receiver.getHabitatZookeeperCount();
        satisfaction = keeper.calculateSatisfaction(habitats, habitatZookeeperCount);
      }

      _display.popup("Satisfaction of employee " + employeeId + ": " + satisfaction);

    } catch (UnknownEmployeeKeyException e) {
      throw new UnknownEmployeeKeyException("Unknown employee ID: " + employeeId);
    }
  }
}