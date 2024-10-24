package hva.core;

import hva.app.exception.UnknownAnimalKeyException;
import hva.app.exception.UnknownEmployeeKeyException;
import hva.app.exception.UnknownHabitatKeyException;
import hva.app.exception.UnknownSpeciesKeyException;
import hva.app.exception.VeterinarianNotAuthorizedException;
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
    Habitat habitat = _habitats.stream()
                               .filter(h -> h.getId().equals(habitatId))
                               .findFirst()
                               .orElseThrow(() -> new IllegalArgumentException("Habitat not found"));
    Animal i = new Animal(animalId, name, speciesId, habitat);
    _animals.add(i);
  
    try {
      this.getSpecies(speciesId).addAnimal(animalId);
  } catch (UnknownSpeciesKeyException e) {
      throw new IllegalArgumentException("Species not found.", e);
  }

    markAsChanged();
  }

  /**
   * Registers a new species in the hotel.
   *
   * @param speciesId the ID of the species
   * @param name the name of the species
   */
  public void registerSpecies(String speciesId, String name) {
    boolean speciesExists=false;

    for(Species i: this.getSpecies()){
      if(i.getId().equals(speciesId))
        speciesExists=true;
    }
    if(speciesExists==false){
    Species i = new Species(speciesId, name);
    _species.add(i);
    markAsChanged();
    }
  }

  /**
   * Gets a species by its ID.
   *
   * @param speciesId the ID of the species
   * @return the Species object
   * @throws UnknownSpeciesKeyException if the species ID is not found
   */
  public Species getSpecies(String speciesId) throws UnknownSpeciesKeyException {
    for (Species species : _species) {
      if (species.getId().equals(speciesId)) {
        return species;
      }
    }
    throw new UnknownSpeciesKeyException(speciesId);
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
   * Assigns a habitat to a zookeeper.
   *
   * @param zookeeperId the ID of the zookeeper
   * @param habitatId the ID of the habitat
   * @throws UnknownHabitatKeyException if the habitat ID is unknown
   */
  public void assignHabitatToZookeeper(String zookeeperId, String habitatId) throws UnknownHabitatKeyException {
    Zookeeper zookeeper = (Zookeeper) _employees.stream()
                                                .filter(e -> e.getId().equals(zookeeperId) && e instanceof Zookeeper)
                                                .findFirst()
                                                .orElseThrow(() -> new IllegalArgumentException("Zookeeper not found"));
    Habitat habitat = _habitats.stream()
                               .filter(h -> h.getId().equals(habitatId))
                               .findFirst()
                               .orElseThrow(() -> new UnknownHabitatKeyException(habitatId));
    zookeeper.addHabitatResponsibility(habitatId);
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
        if (element instanceof Zookeeper zookeeper) {
          zookeeper.getHabitatsManaged().add(i.getId()); // Correct method name
        } else if (element instanceof Veterinarian veterinarian) {
          veterinarian.getSpeciesIds().add(i.getId());
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
    List<String> species = Arrays.asList(speciesIds);
    Vaccine i = new Vaccine(vaccineId, name, species);
    _vaccines.add(i);
    markAsChanged();
  }

  /**
   * Vaccinates an animal with a vaccine.
   *
   * @param animalId the ID of the animal
   * @param vaccineId the ID of the vaccine
   * @param veterinarianId the ID of the veterinarian
   */
  public void vaccinateAnimal(String animalId, String vaccineId, String veterinarianId) throws UnknownAnimalKeyException, UnknownVaccineKeyException, UnknownVeterinarianKeyException, VeterinarianNotAuthorizedException, UnknownEmployeeKeyException {
    Animal animal = getAnimal(animalId);
    Vaccine vaccine = getVaccine(vaccineId);
    if (!isAuthorized(veterinarianId, animal.getSpecies())) {
        throw new VeterinarianNotAuthorizedException(veterinarianId, animal.getSpecies());
    }
    // Implement the vaccination logic here
    // For example: animal.addVaccine(vaccine);
    markAsChanged();
  }

  /**
   * Gets a vaccine by its ID.
   *
   * @param vaccineId the ID of the vaccine
   * @return the Vaccine object
   * @throws UnknownVaccineKeyException if the vaccine ID is not found
   */
  public Vaccine getVaccine(String vaccineId) throws UnknownVaccineKeyException {
    for (Vaccine vaccine : _vaccines) {
      if (vaccine.getId().equals(vaccineId)) {
        return vaccine;
      }
    }
    throw new UnknownVaccineKeyException(vaccineId);
  }

  /**
   * Checks if a veterinarian is authorized to vaccinate the given species.
   *
   * @param veterinarianId the ID of the veterinarian
   * @param speciesId the ID of the species
   * @return true if authorized, false otherwise
   * @throws UnknownEmployeeKeyException if the veterinarian ID is not found
   */
  public boolean isAuthorized(String veterinarianId, String speciesId) throws UnknownEmployeeKeyException {
    Veterinarian veterinarian = (Veterinarian) _employees.stream()
                                                        .filter(e -> e.getId().equals(veterinarianId) && e instanceof Veterinarian)
                                                        .findFirst()
                                                        .orElseThrow(() -> new UnknownEmployeeKeyException(veterinarianId));
    return veterinarian.getSpeciesIds().contains(speciesId);
  }

  /**
   * Adds a tree to a habitat.
   *
   * @param idHabitat the ID of the habitat
   * @param idTree the ID of the tree
   */
  public void addTreeToHabitat(String idHabitat, String idTree) {
    Habitat habitat = _habitats.stream()
                               .filter(h -> h.getId().equals(idHabitat))
                               .findFirst()
                               .orElseThrow(() -> new IllegalArgumentException("Habitat not found"));
    Tree tree = _trees.stream()
                      .filter(t -> t.getId().equals(idTree))
                      .findFirst()
                      .orElseThrow(() -> new IllegalArgumentException("Tree not found"));
    habitat.addTree(tree);
    markAsChanged();
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
    Tree i = Tree.createTree(treeId, name, age, baseDiff, type);
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
   * Gets the count of animals for each species.
   *
   * @return a map of species IDs to animal counts
   */
  public Map<String, Integer> getSpeciesAnimalCount() {
    Map<String, Integer> speciesAnimalCount = new HashMap<>();
    for (Animal animal : _animals) {
      speciesAnimalCount.put(animal.getSpecies(), speciesAnimalCount.getOrDefault(animal.getSpecies(), 0) + 1);
    }
    return speciesAnimalCount;
  }

  /**
   * Gets the count of veterinarians for each species.
   *
   * @return a map of species IDs to veterinarian counts
   */
  public Map<String, Integer> getSpeciesVetCount() {
    Map<String, Integer> speciesVetCount = new HashMap<>();
    for (Employee employee : _employees) {
      if (employee instanceof Veterinarian vet) {
        for (String speciesId : vet.getSpeciesIds()) {
          speciesVetCount.put(speciesId, speciesVetCount.getOrDefault(speciesId, 0) + 1);
        }
      }
    }
    return speciesVetCount;
  }

  /**
   * Gets the count of zookeepers for each habitat.
   *
   * @return a map of habitat IDs to zookeeper counts
   */
  public Map<String, Integer> getHabitatZookeeperCount() {
    Map<String, Integer> habitatZookeeperCount = new HashMap<>();
    for (Employee employee : _employees) {
      if (employee instanceof Zookeeper keeper) {
        for (String habitatId : keeper.getHabitatsManaged()) {
          habitatZookeeperCount.put(habitatId, habitatZookeeperCount.getOrDefault(habitatId, 0) + 1);
        }
      }
    }
    return habitatZookeeperCount;
  }

  /**
   * Get animal by id in the hotel.
   *
   * @return an animal
   */
  public Animal getAnimal(String animalId) throws UnknownAnimalKeyException {
    return _animals.stream()
                   .filter(a -> a.getId().equals(animalId))
                   .findFirst()
                   .orElseThrow(() -> new UnknownAnimalKeyException(animalId));
  }

  public Habitat getHabitat(String habitatId) throws UnknownHabitatKeyException {
    return _habitats.stream()
                    .filter(h -> h.getId().equals(habitatId))
                    .findFirst()
                    .orElseThrow(() -> new UnknownHabitatKeyException(habitatId));
  }

  /**
   * Gets the list of habitats in the hotel, sorted by ID.
   *
   * @return a map of habitat IDs to habitats
   */
  public Map<String, Habitat> getMapHabitats() {
    Map<String, Habitat> habitatMap = new HashMap<>();
    for (Habitat habitat : _habitats) {
      habitatMap.put(habitat.getId(), habitat);
    }
    return habitatMap;
  }

  /**
   * Gets the list of habitats in the hotel, sorted by ID.
   *
   * @return the list of habitats
   */
  public List<Habitat> getListHabitats() {
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
  public List<Tree> getTrees(String habitatId) {
    for(Habitat i: _habitats){
      if(i.getId().equals(habitatId)){
        return i.getTrees();
      }
    }
    try {
      throw new IllegalArgumentException("Habitat ID not found");
  } catch (IllegalArgumentException e) {
      e.printStackTrace();
      return Collections.emptyList(); // Return an empty list or handle as needed
  }
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

  public Employee getEmployee(String employeeId) throws UnknownEmployeeKeyException {
    return _employees.stream()
                     .filter(e -> e.getId().equals(employeeId))
                     .findFirst()
                     .orElseThrow(() -> new UnknownEmployeeKeyException(employeeId));
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