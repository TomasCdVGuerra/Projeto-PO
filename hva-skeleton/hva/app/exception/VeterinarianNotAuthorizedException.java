package hva.app.exception;

public class VeterinarianNotAuthorizedException extends Exception {
  private static final long serialVersionUID = 1L;

  public VeterinarianNotAuthorizedException(String veterinarianId, String species) {
    super("Veterinarian " + veterinarianId + " is not authorized for species " + species);
  }
}