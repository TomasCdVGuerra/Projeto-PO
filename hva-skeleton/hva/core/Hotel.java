package hva.core;

import hva.core.exception.*;
import java.io.*;
import java.util.*;

public class Hotel implements Serializable {

  @Serial
  private static final long serialVersionUID = 202407081733L;

  private List<Animal> _animals;
  private List<Species> _species;
  private List<Employee> _employees;
  private Map<String, List<String>> _responsibilities;
  private List<Vaccine> _vaccines;
  private List<Tree> _trees;
  private List<Habitat> _habitats;
  private String _season;

  public Hotel() {
    _animals = new ArrayList<>();
    _species = new ArrayList<>();
    _employees = new ArrayList<>();
    _responsibilities = new HashMap<>();
    _vaccines = new ArrayList<>();
    _trees = new ArrayList<>();
    _habitats = new ArrayList<>();
    _season = "Spring"; // Default season
  }

  public void registerAnimal(String animalId, String name, String habitatId, String speciesId) throws OneOrMoreCoreExceptions {
    // Implementation here
  }

  public void registerSpecies(String speciesId, String name) throws OneOrMoreCoreExceptions {
    // Implementation here
  }

  public void registerEmployee(String employeeId, String name, String empType) throws OneOrMoreCoreExceptions {
    // Implementation here
  }

  public void addResponsibility(String employeeId, String responsibility) throws OneOrMoreCoreExceptions {
    // Implementation here
  }

  public void registerVaccine(String vaccineId, String name, String[] speciesIds) throws OneOrMoreCoreExceptions {
    // Implementation here
  }

  public void createTree(String treeId, String name, String type, int age, String diff) throws OneOrMoreCoreExceptions {
    Tree tree = new Tree(treeId, name, type, age, diff, _season);
    _trees.add(tree);
  }

  public Habitat registerHabitat(String habitatId, String name, double area) throws OneOrMoreCoreExceptions {
    // Implementation here
    return null;
  }

  public void setSeason(String season) {
    this._season = season;
    for (Tree tree : _trees) {
      tree.setSeason(season);
    }
  }

  /**
   * Read text input file and create corresponding domain entities.
   * 
   * @param filename name of the text input file
   * @throws UnrecognizedEntryException if some entry is not correct
   * @throws IOException if there is an IO erro while processing the text file
   **/
  void importFile(String filename) throws UnrecognizedEntryException, IOException {
    // Implementation here
  }
}