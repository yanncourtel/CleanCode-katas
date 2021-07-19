package zenika.smells.uneffjava.eqhash;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static java.util.UUID.randomUUID;
import static org.junit.Assert.assertTrue;


public class FlightTest {

    @Test public void should_find_segment_in_flight() {
        FlightSegment segment = new FlightSegment(randomUUID().toString());
        Flight flight = new Flight(segment);
        assertTrue(flight.containsSegment(new FlightSegment(segment.getUniqueId())));
    }


}
