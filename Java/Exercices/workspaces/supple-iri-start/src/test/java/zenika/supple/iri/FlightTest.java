package zenika.supple.iri;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static zenika.supple.iri.City.Paris;
import static zenika.supple.iri.City.Tokyo;

public class FlightTest {
    
    @Test public void should_retrieve_departure_airport_from_flight() {
        Flight f = Flight.from(Paris).to(Tokyo);
        f.setSuffix("CDG");
        
        assertEquals("Paris-Tokyo-CDG", f.getCode());
        assertEquals("CDG", f.getSuffix()); 
    }
    
}
