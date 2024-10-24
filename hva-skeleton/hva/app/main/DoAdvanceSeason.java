package hva.app.main;

import hva.core.Habitat;
import hva.core.Hotel;
import hva.core.Tree;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Command for advancing the season of the system.
 **/
class DoAdvanceSeason extends Command<Hotel> {
  DoAdvanceSeason(Hotel receiver) {
    super(Label.ADVANCE_SEASON, receiver);
  }

  @Override
  protected final void execute() throws CommandException {
    for (Habitat habitat : _receiver.getListHabitats()) {
      for (Tree tree : habitat.getTrees()) {
        tree.incrementSeason();
      }
    }
  }
}