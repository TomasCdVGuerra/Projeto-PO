package hva.app.habitat;

public interface Message {

  static String noAssociation(String idHabitat, String idSpecies) {
    return "Não existe associação entre o habitat '" + idHabitat + "' e a espécie '" + idSpecies + "' ";
  }

  static String unknownTreeKey(String idTree) {
    return "A árvore com o ID '" + idTree + "' não foi encontrada.";
  }
}