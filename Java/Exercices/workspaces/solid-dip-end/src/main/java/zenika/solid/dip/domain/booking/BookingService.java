package zenika.solid.dip.domain.booking;

import zenika.solid.dip.domain.availability.Availabilities;

public class BookingService {
    
    private final Availabilities bookings;

    public BookingService(Availabilities bookings) {
        this.bookings = bookings;
    }

    public BookingOutcome book() {
        boolean successful = bookings.isAvailable();
        return new BookingOutcome(successful);
    }
    
}
