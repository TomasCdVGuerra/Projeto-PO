package hva.core.exception;

import hva.app.habitat.Message;
import java.io.Serial;
import pt.tecnico.uilib.menus.CommandException;

public class UnknownVaccineKeyException extends CommandException {
    @Serial
    private static final long serialVersionUID = 202407081733L;

    public UnknownVaccineKeyException(String key) {
        super("Unknown vaccine key: " + key);
    }
}
