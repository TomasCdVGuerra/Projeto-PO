package hva.app.exception;

public class VeterinarianNotAuthorizedException extends Exception {
  private static final long serialVersionUID = 1L;

  public VeterinarianNotAuthorizedException(String veterinarianId) {
    super("Veterinarian " + veterinarianId + " is not authorized to vaccinate this species.");
  }
}