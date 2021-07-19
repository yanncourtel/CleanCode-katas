package zenika.smells.mf.dupclass.exo2;

public class Person {
    
    private final String firstName;
    private final String lastName;
    private String internationalCode; //like +33
    private String phoneNumber; //phone number after the area code

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public void setPhoneNumber(String rawPhoneNumber) {
        this.internationalCode = extractInternationalCode(rawPhoneNumber);
        this.phoneNumber = extractPhoneNumber(rawPhoneNumber);
    }

    //Parses rawPhoneNumber to extract the international code.
    // If absent, from rawPhoneNumber, local code +33 will be set by default. 
    private String extractInternationalCode(String rawPhoneNumber) {
        return null; //dummy impl
    }

    //Parses rawPhoneNumber to extract the local phone number, which follows the international code (if any).
    // If the international code is missing from phoneNumber, 
    // this will return the whole rawPhoneNumber
    private String extractPhoneNumber(String rawPhoneNumber) {
        return null; //dummy impl
    }
}
