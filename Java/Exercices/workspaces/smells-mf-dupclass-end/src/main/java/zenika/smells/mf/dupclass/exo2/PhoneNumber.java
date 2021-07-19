package zenika.smells.mf.dupclass.exo2;

public class PhoneNumber {

    private final String internationalCode; //like +33
    private final String phoneNumber; //phone number after the area code

    public PhoneNumber(String rawPhoneNumber) {
        this.internationalCode = extractInternationalCode(rawPhoneNumber);
        this.phoneNumber = extractPhoneNumber(rawPhoneNumber);
    }

    @Override
    public String toString() {
        return String.join(internationalCode, " ", phoneNumber);
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
