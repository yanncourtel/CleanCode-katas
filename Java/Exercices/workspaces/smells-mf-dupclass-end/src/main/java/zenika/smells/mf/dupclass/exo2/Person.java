package zenika.smells.mf.dupclass.exo2;

public class Person {
    
    private final String firstName;
    private final String lastName;
    private PhoneNumber phoneNumber;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
