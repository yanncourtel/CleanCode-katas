package zenika.solid.ocp;

import static java.util.Objects.requireNonNull;

public class Trip {
    
    private final City departure, arrival;

    private Trip(City departure, City arrival) {
        this.departure = departure;
        this.arrival = arrival;
    }

    public static TripBuilder from(City departure) {
        return new TripBuilder(departure);
    }

    public static class TripBuilder {
        private City departure, arrival;
        
        public TripBuilder(City departure) {
            this.departure = requireNonNull(departure);
        }

        public Trip to(City arrival) {
            this.arrival = requireNonNull(arrival);
            return new Trip(this.departure, this.arrival);
        }
    }
}
