// hva-skeleton/hva/app/employee/Veterinarian.java
package hva.app.employee;

import hva.core.Hotel;
import java.util.List;

public class Veterinarian extends Employee {

    public Veterinarian(String id, String name, int satisfactionLevel, Hotel hotel) {
        super(id, name, satisfactionLevel, true, hotel);
    }

    @Override
    public List<Responsibility> getResponsibilities() {
        // Implement method to return responsibilities
        return null;
    }
}