package zenika.rappel.java8;

public class Person {
    private final String name;
    
    public Person (String name) {
//            requireNonNull(name);
        this.name = name;
    }
    
    public String getName() {return name;}

    @Override public String toString() {return name;}
}