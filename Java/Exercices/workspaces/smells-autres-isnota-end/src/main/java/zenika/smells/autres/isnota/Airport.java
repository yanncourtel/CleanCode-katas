package zenika.smells.autres.isnota;

import java.util.Objects;

public class Airport {
    private final CodeLabel codeLabel;

    public Airport(CodeLabel codeLabel) {
        this.codeLabel = codeLabel;
    }

    // Comportement sur Airport ?


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airport airport = (Airport) o;
        return Objects.equals(codeLabel, airport.codeLabel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeLabel);
    }
}
