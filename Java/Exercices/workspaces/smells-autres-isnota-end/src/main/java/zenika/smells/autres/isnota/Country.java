package zenika.smells.autres.isnota;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Country {

    private final CodeLabel codeLabel;
    private final Set<City> cities = new HashSet<>();

    public Country(CodeLabel codeLabel) {
        this.codeLabel = codeLabel;
    }

    //Comportement sur cities?


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Objects.equals(codeLabel, country.codeLabel) &&
            Objects.equals(cities, country.cities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeLabel, cities);
    }
}
