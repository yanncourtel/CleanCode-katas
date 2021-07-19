package zenika.solid.ocp;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static zenika.solid.ocp.City.Paris;
import static zenika.solid.ocp.City.Tokyo;

public class ItinerarySearchTest {

    private final ItinerarySearchEngine search = new ItinerarySearchEngine();

    @Test public void should_find_shortest_itinerary() {
        Trip trip = Trip.from(Paris).to(Tokyo);

        Optional<Itinerary> optionalShortest =  search.optimalItinerary(trip, ItineraryPreference.SHORTEST);

        assertTrue(optionalShortest.isPresent());
        Itinerary shortest =  optionalShortest.get();
        assertEquals("Direct flight", shortest.label());
    }

    @Test public void should_find_cheapest_itinerary() {
        Trip trip = Trip.from(Paris).to(Tokyo);

        Optional<Itinerary> optionalCheapest =  search.optimalItinerary(trip, ItineraryPreference.CHEAPEST);

        assertTrue(optionalCheapest.isPresent());
        Itinerary cheapest =  optionalCheapest.get();
        assertEquals("With Dubai stopover", cheapest.label());
    }

}
