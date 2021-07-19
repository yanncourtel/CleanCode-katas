package zenika.smells.mf.primitive.exo1;

import java.time.LocalDate;
import java.util.Set;

public interface Reservations {
    
    Set<Reservation> findReservations(Salle salle, LocalDate date);
    
}
