package zenika.solid.dip.domain.booking;

import org.junit.Before;
import org.junit.Test;
import zenika.solid.dip.domain.availability.Availabilities;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingTest {
    
    private Availabilities availabilities;
    private BookingService booking;
    
    @Before public void setup() {
        availabilities = mock(Availabilities.class);
        booking = new BookingService(availabilities);
    }  
    
    @Test public void should_book_when_available() {
        when(availabilities.isAvailable()).thenReturn(true);
        
        BookingOutcome outcome = booking.book();
        
        assertTrue(outcome.isSuccessful());
    } 
    
    @Test public void should_not_book_when_not_available() {
        when(availabilities.isAvailable()).thenReturn(false);
        
        BookingOutcome outcome = booking.book();
        
        assertFalse(outcome.isSuccessful());
    }
    
}
