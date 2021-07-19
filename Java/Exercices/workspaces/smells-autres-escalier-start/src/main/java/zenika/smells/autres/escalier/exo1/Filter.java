package zenika.smells.autres.escalier.exo1;

import java.util.regex.Pattern;

public class Filter {
    
    private static final Pattern COUNTRY_ISO_CODE = Pattern.compile("[A-Z]{2}");
    
    void addCountryFilter(String countryEntry) {
        if(countryEntry != null) {
            if(COUNTRY_ISO_CODE.matcher(countryEntry).matches()) {
                // Implémentation du filtrage
                //
                //
                //
                //
                //
                //
                //
            }    
        }
    }
    
}
