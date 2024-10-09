package hva.core;

import hva.core.exception.*;
import java.io.*;

// FIXME import classes

/**
 * Class representing the manager of this application. It manages the current
 * zoo hotel.
 **/
public class HotelManager {
  /** The current zoo hotel */ // Should we initialize this field?
  private Hotel _hotel;

  public void createNewHotel(){
    _hotel = new Hotel();
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
  public void load(String filename) throws UnavailableFileException {
    Hotel hotel = createNewHotel();
    _hotel=hotel;
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
          String[] parts = line.split("|");
          if (parts[0].equals("ESPECIE")) {
            Species i = new Species(parts[1], parts[2], _hotel);
            _hotel._species.add(i);
          }
          else if (parts[0].equals("ANIMAL")) {
            Animal i = new Animal(parts[1], parts[2], getFromId(parts[3]), getFromId(parts[4]));
            _hotel._animals.add(i);
          }
          else if (parts[0].equals("ARVORE")) {
            Arvore i = new Arvore(parts[1], parts[2], parts[5], parts[3], parts[4]);   //tirar habitat d arvore
            _hotel._trees.add(i);
          }
          else if (parts[0].equals("HABITAT")) {
            Habitat i = new Habitat(parts[1], parts[2], parts[3], 0, 0, parts[4]);
            _hotel._habitats.add(i);
          }
          else if (parts[0].equals("TRATADOR")) {
            Zookepper i = new Zookepper(parts[1], parts[2], parts[3]);
            _hotel._employees.add(i);
          }
          else if (parts[0].equals("VETERINARIO")) {
            Veterinarian i = new Veterinarian(parts[1], parts[2], parts[3]);
            _hotel._employees.add(i);
          }
          else if (parts[0].equals("VACINA")) {
            Vaccine i = new Vaccine(parts[1], parts[2], parts[3]);
            _hotel._vaccines.add(i);
          }
      }
    }
      // FIXME implement serialization method
  }
  
  /**
   * Read text input file and initializes the current zoo hotel (which should be empty)
   * with the domain entitiesi representeed in the import file.
   *
   * @param filename name of the text input file
   * @throws ImportFileException if some error happens during the processing of the
   * import file.
   **/
  public void importFile(String filename) throws ImportFileException {
    try {
      _hotel.importFile(filename);
    } catch (IOException | UnrecognizedEntryException /* FIXME maybe other exceptions */ e) {
      throw new ImportFileException(filename, e);
    }
  } 
  
  /**
   * Returns the zoo hotel managed by this instance.
   *
   * @return the current zoo hotel
   **/
  public final Hotel getHotel() {
    return _hotel;
  }
}
