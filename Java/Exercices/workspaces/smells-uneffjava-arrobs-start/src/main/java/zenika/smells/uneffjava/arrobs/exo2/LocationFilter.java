package zenika.smells.uneffjava.arrobs.exo2;


import java.util.ArrayList;
import java.util.List;

//Code vu dans la nature, anonymisé
public class LocationFilter {
    
    private final List<String> countries = new ArrayList<String>();
    private final List<String> cities = new ArrayList<String>();
    private final List<String> airports = new ArrayList<String>();
    private final List<String> railStations = new ArrayList<String>();
 
    /**
     * Adds the list of countries codes to the filter
     *
     * @param countries
     *            The list of countries codes to add
     * @return The filter
     */
    public LocationFilter withCountries(final List<String> countries) {
        this.countries.addAll(countries);
        return this;
    }
    
    /**
     * Adds the list of cities codes to the filter
     *
     * @param cities
     *            The list of cities codes to add
     * @return The filter
     */
    public LocationFilter withCities(final List<String> cities) {
        this.cities.addAll(cities);
        return this;
    }
    
    /**
     * Adds the list of airports codes to the filter
     *
     * @param airports
     *            The list of airports codes to add
     * @return The filter
     */
    public LocationFilter withAirports(final List<String> airports) {
        this.airports.addAll(airports);
        return this;
    }
    
    /**
     * Adds the list of railStations codes to the filter
     *
     * @param railStations
     *            The list of railStations codes to add
     * @return The filter
     */
    public LocationFilter withRailStations(final List<String> railStations) {
        this.railStations.addAll(railStations);
        return this;
    }

    /**
     * Checks whether the filter contains the country code
     * @param code
     *            The code to check
     * @return <code>true</code> if the code is in the country filter. <code>false</code> otherwise
     */
    public boolean containsCountry(final String code) {
        for (String country : this.countries) {
            if (code.equals(country)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the filter contains the city code
     *
     * @param code
     *            The code to check
     *
     * @return <code>true</code> if the code is in the city filter. <code>false</code> otherwise
     */
    public boolean containsCity(final String code) {
        for (String city : this.cities) {
            if (code.equals(city)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the filter contains the airport code
     *
     * @param code
     *            The code to check
     *
     * @return <code>true</code> if the code is in the airport filter. <code>false</code> otherwise
     */
    public boolean containsAirport(final String code) {
        for (String airport : this.airports) {
            if (code.equals(airport)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the filter contains the rail station code
     *
     * @param code
     *            The code to check
     *
     * @return <code>true</code> if the code is in the rail station filter. <code>false</code> otherwise
     */
    public boolean containsRailStation(final String code) {
        for (String railStation : this.railStations) {
            if (code.equals(railStation)) {
                return true;
            }
        }
        return false;
    }
}
