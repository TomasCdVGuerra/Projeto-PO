package hva.app.habitat;

import hva.app.exception.DuplicateTreeKeyException;
import hva.app.exception.UnknownHabitatKeyException;
import hva.core.Habitat;
import hva.core.Hotel;
import hva.core.Tree;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Add a new tree to a given habitat of the current zoo hotel.
 **/
class DoAddTreeToHabitat extends Command<Hotel> {

  DoAddTreeToHabitat(Hotel receiver) {
    super(Label.ADD_TREE_TO_HABITAT, receiver);
    addStringField("idHabitat", Prompt.habitatKey());
    addStringField("idTree", Prompt.treeKey());
    addStringField("nomeArvore", Prompt.treeName());
    addIntegerField("ageTree", Prompt.treeAge());
    addIntegerField("baseDiff", Prompt.treeDifficulty());
    addOptionField("typeTree", Prompt.treeType(), "CADUCA", "PERENE");
  }

  @Override
  protected void execute() throws CommandException {
    String idHabitat = stringField("idHabitat");
    Habitat habitat;
    try {
      habitat = _receiver.getHabitat(idHabitat);
    } catch (UnknownHabitatKeyException e) {
      throw new UnknownHabitatKeyException("Unknown habitat key: " + idHabitat);
    }

    String idTree = stringField("idTree");

    for (Tree tree : _receiver.getTrees(idHabitat)) {
      if (tree.getId().equals(idTree)) {
        throw new DuplicateTreeKeyException("Duplicate tree key: " + idTree);
      }
    }

    String name = stringField("nomeArvore");
    int age = integerField("ageTree");
    int baseDiff = integerField("baseDiff");
    String type = stringField("typeTree");

    _receiver.createTree(idTree, name, type, age, baseDiff);
    _receiver.addTreeToHabitat(idHabitat, idTree);
  }
}



