package hva.app.main;

import hva.app.exception.FileOpenFailedException;
import hva.core.HotelManager;
import hva.core.exception.UnavailableFileException;
import java.io.IOException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

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
    if (_receiver.getHotel().hasUnsavedChanges()) {
      boolean saveChanges = requestBoolean(Prompt.saveBeforeExit());
      if (saveChanges) {
        try {
          if (_receiver.getFilename() == null) {
            _receiver.saveAs(Form.requestString(Prompt.newSaveAs()));
          } else {
            _receiver.save();
          }
        } catch (Exception exc) {
          exc.printStackTrace();
        }
      }
    }

    String filename = stringField("filename");
    try {
      _receiver.load(filename);
    } catch (UnavailableFileException exc) {
      throw new FileOpenFailedException(exc);
    } catch (IOException exc) {
      exc.printStackTrace();
    }
  }

  private boolean requestBoolean(String prompt) {
    String response = Form.requestString(prompt + " (s/n)");
    return response.equalsIgnoreCase("s");
  }
}