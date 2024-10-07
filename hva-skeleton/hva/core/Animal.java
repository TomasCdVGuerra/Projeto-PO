public class Animal {
    private Hotel _hotel;   //vem do hotel
    private Species _species;
    private Habitat _habitat;
    private String _id;
    private String _name;
    private String _healthState;
    private int _adequacao; //<-animal ou species??


    public Animal(String idAnimal, String name, String idSpecies, String idHabitat){
        
        _species = idSpecies;
        _id = idAnimal;
        _name= name;
        _habitat = idHabitat;
    }
}
