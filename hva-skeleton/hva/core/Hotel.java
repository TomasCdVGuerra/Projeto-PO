package hva.core;

import hva.core.exception.*;
import java.io.*;
import java.util.*;

/**
 * Represents a Hotel in the system.
 * This class implements Serializable to allow its instances to be serialized.
 */
public class Hotel implements Serializable {

  @Serial
  private static final long serialVersionUID = 202407081733L;

  private final List<Animal> _animals;
  private final List<Species> _species;
  private final List<Employee> _employees;
  private final List<Responsibility> _responsibilities;
  private final List<Vaccine> _vaccines;
  private final List<Tree> _trees;
  private final List<Habitat> _habitats;
  private final String _season;
  private boolean _hasUnsavedChanges = false;

  /**
   * Constructs a new Hotel with default values.
   */
  public Hotel() {
      _animals = new ArrayList<>();
      _species = new ArrayList<>();
      _employees = new ArrayList<>();
      _responsibilities = new ArrayList<>();
      _vaccines = new ArrayList<>();
      _trees = new ArrayList<>();
      _habitats = new ArrayList<>();
      _season = "Spring";
  }

  /**
   * Gets the current season of the hotel.
   *
   * @return the current season
   */
  public String getSeason() {
    return _season;
  }

  /**
   * Registers a new animal in the hotel.
   *
   * @param animalId the ID of the animal
   * @param name the name of the animal
   * @param speciesId the species ID of the animal
   * @param habitatId the habitat ID of the animal
   */
  public void registerAnimal(String animalId, String name, String speciesId, String habitatId) {
    Animal i = new Animal(animalId, name, speciesId, habitatId);
    _animals.add(i);
    markAsChanged();
  }

  /**
   * Registers a new species in the hotel.
   *
   * @param speciesId the ID of the species
   * @param name the name of the species
   */
  public void registerSpecies(String speciesId, String name) {
    Species i = new Species(speciesId, name, this);
    _species.add(i);
    markAsChanged();
  }

  /**
   * Registers a new employee in the hotel.
   *
   * @param employeeId the ID of the employee
   * @param name the name of the employee
   * @param empType the type of the employee (e.g., "TRT" for Zookeeper, "VET" for Veterinarian)
   */
  public void registerEmployee(String employeeId, String name, String empType) {
    Employee i = null;
    if (empType.equals("TRT")) {
      i = new Zookeeper(employeeId, name);
    } else if (empType.equals("VET")) {
      i = new Veterinarian(employeeId, name);
    }
    if (i != null) {
      _employees.add(i);
      markAsChanged();
    }
  }

  /**
   * Adds a responsibility to an employee.
   *
   * @param employeeId the ID of the employee
   * @param responsibility the responsibility to add
   */
  public void addResponsibility(String employeeId, String responsibility) {
    Responsibility i = new Responsibility(responsibility, employeeId);
    for (Employee element : _employees) {
      if (element.getId().equals(employeeId)) {
        if (element instanceof Zookeeper) {
          ((Zookeeper) element).getHabitatsM().add(i.getId());
        } else if (element instanceof Veterinarian) {
          ((Veterinarian) element).getSpeciesIds().add(i.getId());
        }
      }
    }
    _responsibilities.add(i);
    markAsChanged();
  }

  /**
   * Registers a new vaccine in the hotel.
   *
   * @param vaccineId the ID of the vaccine
   * @param name the name of the vaccine
   * @param speciesIds the IDs of the species the vaccine is for
   */
  public void registerVaccine(String vaccineId, String name, String[] speciesIds) {
    List<String> species = new ArrayList<>();
    for (String element : speciesIds) {
      species.add(element);
    }
    Vaccine i = new Vaccine(vaccineId, name, species);
    _vaccines.add(i);
    markAsChanged();
  }

  /**
   * Adds a tree to a habitat.
   *
   * @param idHabitat the ID of the habitat
   * @param idTree the ID of the tree
   */
  public void addTreeToHabitat(String idHabitat, String idTree) {
    for (Habitat element : _habitats) {
      if (element.getId().equals(idHabitat)) {
        element.addTree(idTree);
        markAsChanged();
      }
    }
  }

  /**
   * Creates a new tree and adds it to the hotel.
   *
   * @param treeId the ID of the tree
   * @param name the name of the tree
   * @param type the type of the tree
   * @param age the age of the tree
   * @param baseDiff the base difficulty of the tree
   */
  public void createTree(String treeId, String name, String type, int age, int baseDiff) {
    Tree i = new Tree(treeId, name, type, age, baseDiff);
    _trees.add(i);
    markAsChanged();
  }

  /**
   * Registers a new habitat in the hotel.
   *
   * @param habitatId the ID of the habitat
   * @param name the name of the habitat
   * @param area the area of the habitat
   */
  public void registerHabitat(String habitatId, String name, int area) {
    Habitat i = new Habitat(habitatId, name, area);
    _habitats.add(i);
    markAsChanged();
  }

  /**
   * Gets the list of species in the hotel, sorted by ID.
   *
   * @return the list of species
   */
  public List<Species> getSpecies() {
    _species.sort((s1, s2) -> s1.getId().compareToIgnoreCase(s2.getId()));
    return _species;
  }

  /**
   * Gets the list of animals in the hotel, sorted by ID.
   *
   * @return the list of animals
   */
  public List<Animal> getAnimals() {
    _animals.sort((a1, a2) -> a1.getId().compareToIgnoreCase(a2.getId()));
    return _animals;
  }

  /**
   * Gets the list of habitats in the hotel, sorted by ID.
   *
   * @return the list of habitats
   */
  public List<Habitat> getHabitats() {
    _habitats.sort((h1, h2) -> h1.getId().compareToIgnoreCase(h2.getId()));
    return _habitats;
}

  /**
   * Gets the list of vaccines in the hotel, sorted by ID.
   *
   * @return the list of vaccines
   */
  public List<Vaccine> getVaccines() {
    _vaccines.sort((v1, v2) -> v1.getId().compareToIgnoreCase(v2.getId()));
    return _vaccines;
  }

  /**
   * Gets the list of trees in the hotel, sorted by ID.
   *
   * @return the list of trees
   */
  public List<Tree> getTrees() {
    _trees.sort((t1, t2) -> t1.getId().compareToIgnoreCase(t2.getId()));
    return _trees;
  }

  /**
 * Gets the list of employees in the hotel, sorted by ID.
 *
 * @return the list of employees
 */
public List<Employee> getEmployees() {
  _employees.sort((e1, e2) -> e1.getId().compareToIgnoreCase(e2.getId()));
  return _employees;
}

/**
* Marks the hotel as having no unsaved changes.
*/
public void markAsUnchanged() {
  _hasUnsavedChanges = false;
}

/**
* Marks the hotel as having unsaved changes.
*/
public void markAsChanged() {
  _hasUnsavedChanges = true;
}

/**
* Checks if the hotel has unsaved changes.
*
* @return true if there are unsaved changes, false otherwise
*/
public boolean hasUnsavedChanges() {
  return _hasUnsavedChanges;
}

/**
* Reads a text input file and creates corresponding domain entities.
*
* @param filename the name of the text input file
* @throws UnrecognizedEntryException if some entry is not correct
* @throws IOException if there is an IO error while processing the text file
*/
void importFile(String filename) throws UnrecognizedEntryException, IOException {
  Parser parser = new Parser(this);
  parser.parseFile(filename);
  }
}