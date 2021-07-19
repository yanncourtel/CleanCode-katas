package zenika.smells.autres.isnota;

import java.util.List;

public class Country extends CodeLabel {
    
    /** The country's cities */
    private List<City> cities;

    public List<City> getCities() {
	    return cities;
    }

    public void setCities(final List<City> cities) {
	    this.cities = cities;
    }
    
}
