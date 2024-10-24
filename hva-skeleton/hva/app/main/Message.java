package hva.app.main;

public interface Message {
  static String fileNotFound() {
    return "O ficheiro não existe.";
  }

  static String fileNotFound(String filename) {
    return "O ficheiro '" + filename + "' não existe.";
  }

  static String unknownEmployeeKey(String key) {
    return "Não existe nenhum funcionário com a chave '" + key + "'.";
  }
}
