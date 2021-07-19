package zenika.smells.mf.primitive.exo1;

import java.util.Optional;

public class ReservationService {
        
    private final Salles salles;      	
	private final Reservations reservations;

    public ReservationService(Salles salles, Reservations reservations) {
        this.salles = salles;
        this.reservations = reservations;
    }
    
    public Optional<Salle> findSalleReservable(int nbPersonnes, CreneauHoraire creneau) {
		return salles.findSallesByCapacite(nbPersonnes)
            .stream()
			.filter(salle -> reservationPossible(salle, creneau))
            .findAny();		
	}

	private boolean reservationPossible(Salle salle, CreneauHoraire creneauSouhaite ) {		
		return reservations.findReservations(salle, creneauSouhaite.getJour())
            .stream()
            .map(Reservation::getCreneau)
            .noneMatch(creneauReserve -> creneauSouhaite.chevauche(creneauReserve));
	}
}
