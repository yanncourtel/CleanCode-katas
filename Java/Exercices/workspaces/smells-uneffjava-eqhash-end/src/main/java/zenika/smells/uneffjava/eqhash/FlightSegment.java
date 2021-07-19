package zenika.smells.uneffjava.eqhash;

import java.util.concurrent.ThreadLocalRandom;

import static java.util.Objects.hash;
import static java.util.Objects.requireNonNull;

public class FlightSegment 
{
    private final String uniqueId;

    public FlightSegment(String uniqueId) {
        this.uniqueId = requireNonNull(uniqueId);
    }

    @Override public boolean equals(Object obj) {
        if(!(obj instanceof  FlightSegment)) return false;
        FlightSegment that = (FlightSegment) obj;
        return this.uniqueId.equals(that.uniqueId);
    }

    @Override public int hashCode() {
        return uniqueId.hashCode();
        //return ThreadLocalRandom.current().nextInt();
    }

}
