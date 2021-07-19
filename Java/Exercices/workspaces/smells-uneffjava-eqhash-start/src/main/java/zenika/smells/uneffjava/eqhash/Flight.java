package zenika.smells.uneffjava.eqhash;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static java.util.Collections.unmodifiableSet;

public class Flight {
    private final Set<FlightSegment> segments;

    public Flight(FlightSegment... segments) {
        this.segments = unmodifiableSet(new HashSet<>(asList(segments)));
    }

    public boolean containsSegment(FlightSegment segment) {
        for(FlightSegment seg : segments) {
            if(seg.getUniqueId().equals(segment.getUniqueId())) {
                return true;
            }
        }
        return false;
    }
}
