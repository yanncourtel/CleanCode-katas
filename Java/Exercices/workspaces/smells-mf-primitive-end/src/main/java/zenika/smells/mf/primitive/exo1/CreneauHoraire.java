package zenika.smells.mf.primitive.exo1;

import java.time.LocalDate;
import java.util.Objects;

import static java.lang.String.format;

public class CreneauHoraire {
    private final LocalDate jour;
    private final int heureDebut;
    private final int heureFin;

    public CreneauHoraire(LocalDate jour, int heureDebut, int heureFin) {
        this.jour = Objects.requireNonNull(jour);
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        valider();
    }

    private void valider() {
        if(heureFin < heureDebut) throw new IllegalArgumentException(format(
                "L'heure de fin doit etre superieure a l'heure de debut: %s",
                this
        ));
        if(heureFin == heureDebut) throw new IllegalArgumentException(format(
                "Le creneau ne peut pas etre vide: %s",
                this
        ));
        if(heureFin < 0 || heureFin > 23) throw new IllegalArgumentException(format(
                "L'heure de fin doit etre entre 0h et 23h: %s",
                this
        ));
        if(heureDebut < 0 || heureDebut > 23) throw new IllegalArgumentException(format(
                "L'heure de debut doit etre entre 0h et 23h: %s",
                this
        ));
    }

    public LocalDate getJour() {
        return jour;
    }

    public boolean chevauche(CreneauHoraire dejaPris) {
        return this.jour.equals(dejaPris.jour)
           &&  dejaPris.heureFin > this.heureDebut 
           &&  dejaPris.heureDebut < this.heureFin;
    }

    public static Builder aujourdhui() {
        return new Builder(LocalDate.now());
    }
    
    public static Builder demain() {
        return new Builder(LocalDate.now().plusDays(1));
    }

    public static class Builder {
        private final LocalDate jour;
        private int heureDebut;
        private int heureFin;

        public Builder(LocalDate jour) {
            this.jour = jour;    
        }

        public Builder de(int heureDebut) {
            this.heureDebut = heureDebut;
            return this;
        }
        
        public CreneauHoraire a(int heureFin) {
            this.heureFin = heureFin;
            return new CreneauHoraire(this.jour, this.heureDebut, this.heureFin);
        }
    }

    @Override public String toString() {
        return format("%s [%dh->%dh]", jour, heureDebut, heureFin);
    }
}
