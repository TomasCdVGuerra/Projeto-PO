package hva.app.search;

import hva.core.Animal;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show all vaccines applied to animals belonging to an invalid species.
 **/
class DoShowWrongVaccinations extends Command<Hotel> {

  DoShowWrongVaccinations(Hotel receiver) {
    super(Label.WRONG_VACCINATIONS, receiver);
  }

  @Override
  protected void execute() throws CommandException {
    for (String[] record : _receiver.getVaxHistory()) {
      String vaccineId = record[0];
      String veterinarianId = record[1];
      String animalId = record[2];

      try {
        Animal animal = _receiver.getAnimal(animalId);
        String healthHistory = animal.getHealthHistory();

        if (!healthHistory.equals("NORMAL")) {
          _display.addLine("REGISTO-VACINA|" + vaccineId + "|" + veterinarianId + "|" + animalId);
        }
      } catch (Exception e) {
        _display.popup("Error processing record: " + String.join(", ", record) + ". Error: " + e.getMessage());
      }
    }
    _display.display();
  }
}