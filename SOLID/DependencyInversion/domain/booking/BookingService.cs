namespace SOLID.DependencyInversion.domain.booking
{
    public class BookingService
    {
        private readonly IAvailabilityDao bookings;

        public BookingService(IAvailabilityDao bookings)
        {
            this.bookings = bookings;
        }

        public BookingOutcome Book()
        {
            bool successful = bookings.IsAvailable();
            return new BookingOutcome(successful);
        }
    }
}