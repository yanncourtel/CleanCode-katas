package zenika.smells.mf.primitive.exo1;

import java.time.LocalDate;
import java.util.Optional;

public class ReservationService {
        
    private final Salles salles;      	
	private final Reservations reservations;

    public ReservationService(Salles salles, Reservations reservations) {
        this.salles = salles;
        this.reservations = reservations;
    }
    
    public Optional<Salle> findSalleReservable(int nbPersonnes, LocalDate jour, int heureDebut, int heureFin) {
		return salles.findSallesByCapacite(nbPersonnes)
            .stream()
			.filter(salle -> reservationPossible(salle, jour, heureDebut, heureFin))
            .findAny();		
	}
    
	private boolean reservationPossible(Salle salle, LocalDate jour, int heureDebut, int heureFin) {		
		return reservations.findReservations(salle, jour)
            .stream()
            .noneMatch(reservation -> chevauche(reservation, jour, heureDebut, heureFin));
	}

    private boolean chevauche(Reservation reservation, LocalDate jour, int heureDebut, int heureFin) {
        return reservation.getHeureFin() > heureDebut
            && reservation.getHeureDebut() < heureFin;
    }
    
}
