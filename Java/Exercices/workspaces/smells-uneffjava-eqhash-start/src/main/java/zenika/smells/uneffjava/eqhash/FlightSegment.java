package zenika.smells.uneffjava.eqhash;

import static java.util.Objects.requireNonNull;

public class FlightSegment
{
    private final String uniqueId;

    public FlightSegment(String uniqueId) {
        this.uniqueId = requireNonNull(uniqueId);
    }

    public String getUniqueId() {
        return uniqueId;
    }
}
