package zenika.smells.mf.dupclass.exo2;

public class Enterprise {
    
    private final String name;
    private PhoneNumber phoneNumber;

    public Enterprise(String name) {
        this.name = name;
    }

    public void setPhoneNumber(PhoneNumber phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
