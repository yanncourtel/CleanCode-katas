package zenika.solid.ocp;

import java.time.Duration;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class ItinerarySearchEngine {

    //Pour une API plus souple: Function<? super Itinerary,U>
    public <U extends Comparable<? super U>> Optional<Itinerary> optimalItinerary(
            Trip trip, Function<Itinerary,U> criterion
    ) {
        return itinerariesFor(trip).min(comparing(criterion));
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
