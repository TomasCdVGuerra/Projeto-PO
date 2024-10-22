package hva.app.animal;

import hva.app.exception.UnknownAnimalKeyException;
import hva.core.Animal;
import hva.core.Habitat;
import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Shows the satisfaction of a given animal.
 */
class DoShowSatisfactionOfAnimal extends Command<Hotel> {

  DoShowSatisfactionOfAnimal(Hotel receiver) {
    super(Label.SHOW_SATISFACTION_OF_ANIMAL, receiver);
    addStringField("animalId", "Animal ID");
  }

  @Override
  protected final void execute() throws CommandException {
    String animalId = stringField("animalId");

    // Assuming getAnimal may return null if the animal is not found, handle that case
    Animal animal = _receiver.getAnimal(animalId);
    if (animal == null) {
      // Directly throw the UnknownAnimalKeyException if the animal is not found
      throw new UnknownAnimalKeyException(animalId);
    }

    Habitat habitat = animal.getHabitat();

    int especieIgual = habitat.countSameSpecies(animal);
    int especieDiferente = habitat.countDifferentSpecies(animal);

    double area = habitat.getArea();
    int populacao = habitat.getPopulation();
    double adequacao = habitat.getAdequacy(animal);

    double satisfacao = 20 + 3 * especieIgual - 2 * especieDiferente + (area / populacao) + adequacao;

    _display.popup("Satisfaction of animal " + animalId + ": " + satisfacao);
  }
}
