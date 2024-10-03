package hva.app.vaccine;

import hva.core.Hotel;
import hva.core.Vaccine;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Show all vaccines.
 **/
class DoShowAllVaccines extends Command<Hotel> {

  DoShowAllVaccines(Hotel receiver) {
    super(Label.SHOW_ALL_VACCINES, receiver);
  }

  @Override
  protected final void execute() throws CommandException {
    List<Vaccine> vaccines = _receiver.getAllVaccines();
    for (Vaccine vaccine : vaccines) {
      String species = String.join(",", vaccine.getPossibleSpecies());
      _display.addLine(String.format("VACINA|%s|%s|%d|%s", vaccine.getID(), vaccine.getName(), vaccine.getNumApplications(), species));
    }
    _display.display();
  }
