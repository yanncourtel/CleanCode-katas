package zenika.smells.mf.primitive.exo1;

import java.time.LocalDate;

public class Reservation {
    
    private final LocalDate jour;
    private final int heureDebut, heureFin;

    public Reservation(LocalDate jour, int heureDebut, int heureFin) {
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
    }
    
    public LocalDate getJour() {
        return this.jour;
    }

    public int getHeureDebut() {
        return this.heureDebut;
    }

    public int getHeureFin() {
        return this.heureFin;
    }
}
