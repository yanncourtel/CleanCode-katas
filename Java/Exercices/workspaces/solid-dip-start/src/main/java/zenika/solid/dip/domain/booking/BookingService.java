package zenika.solid.dip.domain.booking;

import zenika.solid.dip.infrastructure.AvailabilityDao;

public class BookingService {
    
    private final AvailabilityDao bookings;

    public BookingService(AvailabilityDao bookings) {
        this.bookings = bookings;
    }

    public BookingOutcome book() {
        boolean successful = bookings.isAvailable();
        return new BookingOutcome(successful);
    }
    
}
