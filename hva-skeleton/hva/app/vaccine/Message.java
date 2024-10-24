package hva.app.vaccine;

public interface Message {
  static String wrongVaccine(String vaccineKey, String animalKey) {
    return "A vacina '" + vaccineKey + "' não é apropiada para o animal '" + animalKey + "'.";
  }
  static String requestVeterinarianId() {
    return "Identificador do veterinário: ";
  }
  static String requestAnimalId() {
    return "Identificador do animal: ";
  }
  static String requestVaccineId() {
    return "Identificador da vacina: ";
  }
}
