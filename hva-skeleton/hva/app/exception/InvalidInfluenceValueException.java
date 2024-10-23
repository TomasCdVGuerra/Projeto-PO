package hva.app.exception;

/**
 * Exception thrown when an invalid influence value is provided.
 */
public class InvalidInfluenceValueException extends Exception {
  private static final long serialVersionUID = 1L;

  public InvalidInfluenceValueException(String influence) {
    super("Invalid influence value: " + influence);
  }
}