package zenika.solid.ocp;

import java.time.Duration;

public class Itinerary {

    private final Trip trip;
    private final String label;
    private final Duration duration;
    private final int cost;

    public Itinerary(Trip trip, String label, Duration duration, int cost) {
        this.trip = trip;
        this.label = label;
        this.duration = duration;
        this.cost = cost;
    }

    public Duration duration() {
        return this.duration;
    }
    
    public int cost() {
        return this.cost;
    }
    
    public String label() {
        return this.label;
    }

    public static ItineraryBuilder of(Trip trip) {
        return new ItineraryBuilder(trip);
    }

    public static class ItineraryBuilder {

        private Trip trip;
        private String label;
        private Duration duration;
        private int cost;

        public ItineraryBuilder(Trip trip) {
            this.trip = trip;
        }

        public ItineraryBuilder lasting(Duration duration) {
            this.duration = duration;
            return this;
        }

        public ItineraryBuilder labelled(String label) {
            this.label = label;
            return this;
        }
        
        //TODO use Value Object MonetaryAmount
        public Itinerary costing(int euros) {
            this.cost = euros;
            return new Itinerary(this.trip, this.label, this.duration, this.cost);
        }
        
    }
}
