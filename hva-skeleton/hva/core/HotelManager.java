package hva.core;

import hva.core.exception.*;
import java.io.*;
import java.util.List;

/**
 * Class representing the manager of this application. It manages the current
 * zoo hotel.
 **/
public class HotelManager {
  /** The current zoo hotel */
  private Hotel _hotel;

  public Hotel createNewHotel() {
    return new Hotel();
  }

  /**
   * Saves the serialized application's state into the file associated to the current network.
   *
   * @throws FileNotFoundException if for some reason the file cannot be created or opened.
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   **/
  public void save() throws FileNotFoundException, MissingFileAssociationException, IOException {
    // FIXME implement serialization method
  }

  /**
   * Saves the serialized application's state into the specified file. The current network is
   * associated to this file.
   *
   * @param filename the name of the file.
   * @throws FileNotFoundException if for some reason the file cannot be created or opened.
   * @throws MissingFileAssociationException if the current network does not have a file.
   * @throws IOException if there is some error while serializing the state of the network to disk.
   **/
  public void saveAs(String filename) throws FileNotFoundException, MissingFileAssociationException, IOException {
    // FIXME implement serialization method
  }

  /**
   * @param filename name of the file containing the serialized application's state
   *        to load.
   * @throws UnavailableFileException if the specified file does not exist or there is
   *         an error while processing this file.
   **/
  public void load(String filename) throws UnavailableFileException, IOException {
    // FIXME implement serialization method
  }

  /**
   * Read text input file and initializes the current zoo hotel (which should be empty)
   * with the domain entities represented in the import file.
   *
   * @param filename name of the text input file
   * @throws ImportFileException if some error happens during the processing of the
   * import file.
   **/
  public void importFile(String filename) throws ImportFileException {
    Hotel hotel = createNewHotel();
    _hotel = hotel;
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = br.readLine()) != null) {
        String[] parts = line.split("|");
        if (parts[0].equals("ESPECIE")) {
          Species i = new Species(parts[1], parts[2], _hotel);    //getHotel?
          _hotel.getSpecies().add(i);
        } else if (parts[0].equals("ANIMAL")) {
          Animal i = new Animal(parts[1], parts[2], getFromId(HotelEntity Species,parts[3]), getFromId(EntityType Habitat,parts[4]));
          _hotel.getAnimals().add(i);
        } else if (parts[0].equals("ARVORE")) {
          Tree i = new Tree(parts[1], parts[2], parts[5], parts[3], parts[4]);
          _hotel.getTrees().add(i);
        } else if (parts[0].equals("HABITAT")) {
          Habitat i = new Habitat(parts[1], parts[2], Double.parseDouble(parts[3]), 0, _hotel.getSpecies());
          _hotel.getHabitats().add(i);
        } else if (parts[0].equals("TRATADOR")) {
          Zookeeper i = new Zookeeper(parts[1], parts[2], parts[3]);
          _hotel.getEmployees().add(i);
        } else if (parts[0].equals("VETERINARIO")) {
          Veterinarian i = new Veterinarian(parts[1], parts[2], parts[3]);
          _hotel.getEmployees().add(i);
        } else if (parts[0].equals("VACINA")) {
          Vaccine i = new Vaccine(parts[1], parts[2], parts[3]);
          _hotel.getVaccines().add(i);
        }
      }
    } catch (FileNotFoundException e) {
      throw new UnavailableFileException("File not found: " + filename);
    } catch (IOException | UnrecognizedEntryException e) {
      throw new ImportFileException(filename, e);
    }

    """ORIGINAL CODE
    try {
      _hotel.importFile(filename);
    } catch (IOException | UnrecognizedEntryException /* FIXME maybe other exceptions */ e) {
      throw new ImportFileException(filename, e);
    }"""

  }

  /**
   * Returns the zoo hotel managed by this instance.
   *
   * @return the current zoo hotel
   **/
  public final Hotel getHotel() {
    return _hotel;
  }

  // Helper method to resolve species from ID
  private Species getSpeciesFromId(String id) {
    // Implementation to get Species from ID
    return null; // Replace with actual implementation
  }
}