package hva.app.main;

import hva.app.exception.FileOpenFailedException;
import hva.core.HotelManager;
import hva.core.exception.UnavailableFileException;
import java.io.*;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

//FIXME add more imports if needed

/**
 * Command to open a file.
 */
class DoOpenFile extends Command<HotelManager> {
  DoOpenFile(HotelManager receiver) {
    super(Label.OPEN_FILE, receiver);
    addStringField("filename", Prompt.openFile());
  }

  @Override
  protected final void execute() throws CommandException {
    String filename=stringField("filename");

      try {
      _receiver.load(filename);
      } 
      catch (UnavailableFileException exc) {
        throw new FileOpenFailedException(exc);
      }
      catch (IOException exc){
        exc.printStackTrace();
      }
    /*
      try {
      //FIXME implement command
      } catch (UnavailableFileException efe) {
      throw new FileOpenFailedException(efe);
      }
    */
  }
}
