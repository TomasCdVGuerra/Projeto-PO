package hva.core.exception;

import hva.app.habitat.Message;
import java.io.Serial;
import pt.tecnico.uilib.menus.CommandException;

public class UnknownTreeKeyException extends CommandException {
  @Serial
  private static final long serialVersionUID = 202407081733L;
  
  public UnknownTreeKeyException(String id) {
    super(Message.unknownTreeKey(id));
  }
}