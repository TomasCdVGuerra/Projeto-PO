package hva.core.exception;

import pt.tecnico.uilib.menus.CommandException;

public class UnknownAnimalKeyException extends CommandException {
  private static final long serialVersionUID = 1L;

  public UnknownAnimalKeyException(String animalId) {
    super("Unknown animal key: " + animalId);
  }
}