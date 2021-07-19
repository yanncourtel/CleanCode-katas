package zenika.supple.iri;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static zenika.supple.iri.City.*;

public class FlightTest {
    
    @Test public void should_retrieve_departure_airport_from_flight() {
        Flight f = Flight.from(Paris).to(Tokyo);
        f.setDepartureAirport("CDG");
        
        assertEquals("Paris-Tokyo-CDG", f.getCode());
        assertEquals("CDG", f.getDepartureAirport()); 
    }
    
}
