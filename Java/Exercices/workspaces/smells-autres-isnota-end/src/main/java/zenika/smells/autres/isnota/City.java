package zenika.smells.autres.isnota;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class City {

    private final CodeLabel codeLabel;
    private final Set<Airport> airports = new HashSet<>();

    public City(CodeLabel codeLabel) {
        this.codeLabel = codeLabel;
    }

    //Comportement sur airports?

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(codeLabel, city.codeLabel) &&
            Objects.equals(airports, city.airports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeLabel, airports);
    }
}
