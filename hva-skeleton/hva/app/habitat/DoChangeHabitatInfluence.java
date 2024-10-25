package hva.app.habitat;

import hva.app.animal.Prompt;
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
    addStringField("habitatId", Prompt.habitatKey());
    addStringField("speciesId", Prompt.speciesKey());
    addOptionField("influence", hva.app.habitat.Prompt.habitatInfluence(), "POS", "NEG", "NEU");
  }
  
  @Override
protected void execute() {
    String habitatId = stringField("habitatId");
    String speciesId = stringField("speciesId");
    String influenceStr = optionField("influence");

    try {
        Habitat habitat = _receiver.getHabitat(habitatId);
        Species species = _receiver.getSpecies(speciesId);

        AdequationValue influence;
        if (influenceStr.equals("POS")) {
            influence = AdequationValue.POSITIVE;
        } else if (influenceStr.equals("NEU")) {
            influence = AdequationValue.NEUTRAL;
        } else if (influenceStr.equals("NEG")) {
            influence = AdequationValue.NEGATIVE;
        } else {
            throw new IllegalArgumentException("Invalid influence value: " + influenceStr);
        }

        Adequation adequation = new Adequation(species, influence);
        habitat.setAdequationForSpecies(speciesId, adequation);

        _display.popup("Influence of species " + speciesId + " on habitat " + habitatId + " set to " + influenceStr);

    } catch (UnknownHabitatKeyException e) {
        _display.popup("Unknown habitat ID: " + habitatId);
    } catch (UnknownSpeciesKeyException e) {
        _display.popup("Unknown species ID: " + speciesId);
    } catch (IllegalArgumentException e) {
        _display.popup(e.getMessage());
    }
}
}