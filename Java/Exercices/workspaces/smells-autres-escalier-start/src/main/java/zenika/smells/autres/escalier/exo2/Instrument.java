package zenika.smells.autres.escalier.exo2;

public class Instrument {

    private final Kind kind;

    private Instrument(Kind kind) {
        this.kind = kind;
    }

    public static Instrument of(Kind kind) {
        return new Instrument(kind);
    }

    public Kind kind() {
        return this.kind;
    }

    public enum Kind {
        COPPER, PERCUSSION, CORDS
    }
    
}
