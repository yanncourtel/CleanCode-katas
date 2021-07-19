package zenika.smells.mf.primitive.exo1;

public class Reservation {
    
    private final CreneauHoraire creneau;

    public Reservation(CreneauHoraire creneau) {
        this.creneau = creneau;
    }

    public CreneauHoraire getCreneau() {
        return this.creneau;
    }
    
}
