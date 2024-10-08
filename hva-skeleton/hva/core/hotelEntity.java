package hva.core;

public abstract class HotelEntity {
    private String id;
    private String name;

    public HotelEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getEntityDetails();
}