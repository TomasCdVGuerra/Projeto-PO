package hva.app.exception;

import pt.tecnico.uilib.menus.CommandException;

public class NoResponsibilityException extends CommandException {
  private static final long serialVersionUID = 202207081733L;

  public NoResponsibilityException(String employeeId, String responsibility) {
    super("Employee " + employeeId + " cannot have responsibility: " + responsibility);
  }
}