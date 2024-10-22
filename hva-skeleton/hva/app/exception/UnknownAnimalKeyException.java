package hva.app.exception;

import java.io.Serial;
import pt.tecnico.uilib.menus.CommandException;

public class UnknownAnimalKeyException extends CommandException {
  @Serial
  private static final long serialVersionUID = 202407081733L;
  
  public UnknownAnimalKeyException(String id) {
    super("Unknown animal key: " + id);
  }
}