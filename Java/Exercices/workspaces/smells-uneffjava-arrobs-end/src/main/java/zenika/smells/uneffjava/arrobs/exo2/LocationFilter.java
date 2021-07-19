package zenika.smells.uneffjava.arrobs.exo2;


import java.util.*;

//Code vu dans la nature, anonymisé
public class LocationFilter {
    
    private final Set<String> countries = new HashSet<>();
    private final Set<String> cities = new HashSet<>();
    private final Set<String> airports = new HashSet<>();
    private final Set<String> railStations = new HashSet<>();
 
    public LocationFilter withCountries(final Collection<String> countries) {
        this.countries.addAll(countries);
        return this;
    }
    
    public LocationFilter withCities(final Collection<String> cities) {
        this.cities.addAll(cities);
        return this;
    }
    
    public LocationFilter withAirports(final Collection<String> airports) {
        this.airports.addAll(airports);
        return this;
    }
    
    public LocationFilter withRailStations(final Collection<String> railStations) {
        this.railStations.addAll(railStations);
        return this;
    }

    public boolean containsCountry(final String countryCode) {
        return countries.contains(countryCode);
    }

    public boolean containsCity(final String cityCode) {
        return cities.contains(cityCode);
    }

    public boolean containsAirport(final String airportCode) {
        return airports.contains(airportCode);
    }

    public boolean containsRailStation(final String railStationCode) {
        return railStations.contains(railStationCode);
    }
}
