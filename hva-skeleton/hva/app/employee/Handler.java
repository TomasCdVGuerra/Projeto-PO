// hva-skeleton/hva/app/employee/Handler.java
package hva.app.employee;

import hva.core.Hotel;
import hva.core.Habitat;
import hva.core.Tree;
import java.util.ArrayList;
import java.util.List;

public class Handler extends Employee {
    private List<Habitat> assignedHabitats;

    public Handler(String id, String name, int satisfactionLevel, Hotel hotel, List<Habitat> assignedHabitats) {
        super(id, name, satisfactionLevel, false, hotel);
        this.assignedHabitats = assignedHabitats != null ? assignedHabitats : new ArrayList<>();
    }

    @Override
    public List<Responsibility> getResponsibilities() {
        List<Responsibility> responsibilities = new ArrayList<>();
        for (Habitat habitat : assignedHabitats) {
            responsibilities.add(new Responsibility(habitat));
        }
        return responsibilities;
    }

    public double getWorkload() {
        double totalWorkload = 0;
        for (Habitat habitat : assignedHabitats) {
            double workload = habitat.getArea() + 3 * habitat.getPopulation();
            for (Tree tree : habitat.getTrees()) {
                workload += tree.getFinalCleanDiff();
            }
            totalWorkload += workload;
        }
        return totalWorkload;
    }

    public double getSatisfaction() {
        double totalWorkload = 0;
        for (Habitat habitat : assignedHabitats) {
            double habitatWorkload = habitat.calculateHabitatCleanDiff();
            int numberOfKeepers = habitat.getNumberOfKeepers();
            totalWorkload += habitatWorkload / numberOfKeepers;
        }
        return 300 - totalWorkload;
    }

    public void assignHabitat(Habitat habitat) {
        if (!assignedHabitats.contains(habitat)) {
            assignedHabitats.add(habitat);
        }
    }

    public void removeHabitat(Habitat habitat) {
        assignedHabitats.remove(habitat);
    }

    public List<Habitat> viewHabitats() {
        return new ArrayList<>(assignedHabitats);
    }
}