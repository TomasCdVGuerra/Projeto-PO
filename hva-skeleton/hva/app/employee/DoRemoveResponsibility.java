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
 * Remove a given responsibility from a given employee of this zoo hotel.
 */
class DoRemoveResponsibility extends Command<Hotel> {

    DoRemoveResponsibility(Hotel receiver) {
        super(Label.REMOVE_RESPONSIBILITY, receiver);
        addStringField("employeeId", "Employee ID");
        addStringField("responsibility", "Responsibility");
    }

    @Override
    protected void execute() throws CommandException {
        String employeeId = stringField("employeeId");
        String responsibility = stringField("responsibility");

        try {
            Employee employee = _receiver.getEmployee(employeeId);

            if (employee instanceof Veterinarian vet) {
                if (!vet.getSpeciesIds().remove(responsibility)) {
                    throw new NoResponsibilityException(employeeId, responsibility);
                }
            } else if (employee instanceof Zookeeper keeper) {
                if (!keeper.getHabitatsManaged().remove(responsibility)) {
                    throw new NoResponsibilityException(employeeId, responsibility);
                }
            } else {
                throw new NoResponsibilityException(employeeId, responsibility);
            }

            _display.popup("Responsibility removed from employee " + employeeId);

        } catch (UnknownEmployeeKeyException e) {
            throw new UnknownEmployeeKeyException("Unknown employee ID: " + employeeId);
        } catch (NoResponsibilityException e) {
            throw new UnknownEmployeeKeyException("Employee " + employeeId + " does not have this responsibility.");
        }
    }
}