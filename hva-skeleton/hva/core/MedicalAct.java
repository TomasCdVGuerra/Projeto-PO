package hva.core;

public class MedicalAct {
    private String description;
    private String date;

    public MedicalAct(String description, String date) {
        this.description = description;
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "MedicalAct{" +
                "description='" + description + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}