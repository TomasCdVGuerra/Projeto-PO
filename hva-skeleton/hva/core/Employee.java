package hva.core;

public abstract class Employee extends HotelEntity {
    private int _satisfLevel;
    private String _type;

    public Employee(String id, String name, String type) {
        super(id, name);
        if (type.equals("VETERINÁRIO") || type.equals("TRATADOR")) {
            _type = type;
        }
    }

    public String getType() {
        return _type;
    }

    @Override
    public String toString(){
        return "";
    }
}