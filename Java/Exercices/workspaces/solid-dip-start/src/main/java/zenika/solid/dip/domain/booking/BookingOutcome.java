package zenika.solid.dip.domain.booking;

public class BookingOutcome {
    private final boolean successful;

    public BookingOutcome(boolean successful) {
        this.successful = successful;
    }

    public boolean isSuccessful() {
        return successful;
    }

}
