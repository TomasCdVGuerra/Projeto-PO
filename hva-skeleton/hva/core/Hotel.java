// hva-skeleton/hva/core/Hotel.java
package hva.core;

import hva.app.vaccine.Vaccine;
import hva.app.habitat.Habitat;
import hva.core.exception.*;
import java.io.*;
import java.util.*;

public class Hotel implements Serializable {

  @Serial
  private static final long serialVersionUID = 202407081733L;

  private List<Vaccine> vaccines;
  private List<Habitat> habitats;

  public Hotel() {
    vaccines = new ArrayList<>();
    habitats = new ArrayList<>();
  }

  public List<Vaccine> getAllVaccines() {
    return vaccines;
  }

  public List<Habitat> getHabitats() {
    return habitats;
  }

  public List<Vaccine> getVaccinesForAnimal(String animalId) {
    List<Vaccine> animalVaccines = new ArrayList<>();
    for (Vaccine vaccine : vaccines) {
      if (vaccine.getAnimalId().equals(animalId)) {
        animalVaccines.add(vaccine);
      }
    }
    return animalVaccines;
  }

  public List<Vaccine> getAllVaccinations() {
    return vaccines;
  }

  /**
   * Read text input file and create corresponding domain entities.
   *
   * @param filename name of the text input file
   * @throws UnrecognizedEntryException if some entry is not correct
   * @throws IOException if there is an IO erro while processing the text file
   **/
  void importFile(String filename) throws UnrecognizedEntryException, IOException {
    // Implement method
  }
}