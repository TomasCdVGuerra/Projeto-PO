package hva.core.exception;

import hva.app.main.Message; // Corrected import statement
import java.io.Serial;
import pt.tecnico.uilib.menus.CommandException;

public class UnknownEmployeeKeyException extends CommandException {
  @Serial
  private static final long serialVersionUID = 202407081733L;

  public UnknownEmployeeKeyException(String key) {
    super(Message.unknownEmployeeKey(key));
  }
}