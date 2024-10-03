// hva-skeleton/hva/app/vaccine/DoShowVaccinations.java
package hva.app.vaccine;

import hva.core.Hotel;
import hva.core.Vaccine;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import java.util.List;

/**
 * Show all vaccinations.
 **/
class DoShowVaccinations extends Command<Hotel> {

  DoShowVaccinations(Hotel receiver) {
    super(Label.SHOW_ALL_VACCINATIONS, receiver);
  }

  @Override
  protected final void execute() throws CommandException {
    List<Vaccine> vaccinations = _receiver.getAllVaccinations();
    for (Vaccine vaccine : vaccinations) {
      _display.addLine(String.format("REGISTO-VACINA|%s|%s|%s", vaccine.getID(), vaccine.getVeterinaryId(), vaccine.getSpeciesId()));
    }
    _display.display();
  }
}