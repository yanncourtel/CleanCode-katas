package zenika.solid.ocp;

import java.time.Duration;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class ItinerarySearchEngine {
    
    public Optional<Itinerary> optimalItinerary(Trip trip, ItineraryPreference pref) {
        switch(pref) {
            case CHEAPEST: 
                return itinerariesFor(trip).min(comparing(Itinerary::cost));
            case SHORTEST: 
                return itinerariesFor(trip).min(comparing(Itinerary::duration));
            default:
                throw new IllegalArgumentException("Unknown ItineraryType: " + pref);
        }
    }

    private Stream<Itinerary> itinerariesFor(Trip trip) {
        //fake implementation
        Itinerary directFlight = Itinerary.of(trip)
                .labelled("Direct flight")
                .lasting(Duration.ofHours(12))
                .costing(400);
        
        Itinerary withDubaiStopover = Itinerary.of(trip)
                .labelled("With Dubai stopover")
                .lasting(Duration.ofHours(16))
                .costing(200);
        
        return Stream.of(directFlight, withDubaiStopover);
    }

}
