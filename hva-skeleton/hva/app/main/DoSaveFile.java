package hva.app.main;

import hva.core.HotelManager;
import hva.core.exception.MissingFileAssociationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;

/**
 * Save to file under current name (if unnamed, query for name).
 */
class DoSaveFile extends Command<HotelManager> {
  DoSaveFile(HotelManager receiver) {
    super(Label.SAVE_FILE, receiver, r -> r.getHotel() != null);
  }

  @Override
  protected final void execute() {
    try {
      _receiver.save();
    } catch (MissingFileAssociationException exc1) {
      try {
        _receiver.saveAs(Form.requestString(Prompt.newSaveAs()));
      } catch (MissingFileAssociationException exc2) {
        exc2.printStackTrace();
      } catch (FileNotFoundException exc3) {
        exc3.printStackTrace();
      } catch (IOException exc4) {
        exc4.printStackTrace();
      }
    } catch (FileNotFoundException exc5) {
      exc5.printStackTrace();
    } catch (IOException exc6) {
      exc6.printStackTrace();
  }
}

private void saveAs(){
  try {
    _receiver.saveAs(Form.requestString(Prompt.newSaveAs()));
  }
  catch (Exception exc) {
    exc.printStackTrace();
  }
  }
}
