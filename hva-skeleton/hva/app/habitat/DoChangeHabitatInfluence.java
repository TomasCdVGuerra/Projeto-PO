package hva.app.habitat;

import hva.app.exception.InvalidInfluenceValueException;
import hva.app.exception.UnknownHabitatKeyException;
import hva.app.exception.UnknownSpeciesKeyException;
import hva.core.Adequation;
import hva.core.Adequation.AdequationValue;
import hva.core.Habitat;
import hva.core.Hotel;
import hva.core.Species;
import pt.tecnico.uilib.menus.Command;

/**
 * Associate (positive or negatively) a species to a given habitat.
 **/
class DoChangeHabitatInfluence extends Command<Hotel> {

  DoChangeHabitatInfluence(Hotel receiver) {
    super(Label.CHANGE_HABITAT_INFLUENCE, receiver);
    addStringField("habitatId", "Habitat ID");
    addStringField("speciesId", "Species ID");
    addStringField("influence", "Influence (POSITIVE, NEUTRAL, NEGATIVE)");
  }
  
  @Override
  protected void execute() {
    String habitatId = stringField("habitatId");
    String speciesId = stringField("speciesId");
    String influenceStr = stringField("influence");

    try {
      Habitat habitat = _receiver.getHabitat(habitatId);
      Species species = _receiver.getSpecies(speciesId);

      AdequationValue influence = switch (influenceStr.toUpperCase()) {
        case "POSITIVE" -> AdequationValue.POSITIVE;
        case "NEUTRAL" -> AdequationValue.NEUTRAL;
        case "NEGATIVE" -> AdequationValue.NEGATIVE;
        default -> throw new InvalidInfluenceValueException(influenceStr);
      };

      Adequation adequation = new Adequation(species, influence);
      habitat.setAdequationForSpecies(speciesId, adequation);

      _display.popup("Influence of species " + speciesId + " on habitat " + habitatId + " set to " + influenceStr);

    } catch (UnknownHabitatKeyException e) {
      _display.popup("Unknown habitat ID: " + habitatId);
    } catch (UnknownSpeciesKeyException e) {
      _display.popup("Unknown species ID: " + speciesId);
    } catch (InvalidInfluenceValueException e) {
      _display.popup("Invalid influence value: " + influenceStr);
    }
  }
}