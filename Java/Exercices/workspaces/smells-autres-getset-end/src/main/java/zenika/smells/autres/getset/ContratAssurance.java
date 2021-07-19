package zenika.smells.autres.getset;

public class ContratAssurance {

    private final TypeSinistre typeSinistre;

    public ContratAssurance(TypeSinistre typeSinistre) {
        this.typeSinistre = typeSinistre;
    }

    public boolean couvre(TypeSinistre typeSinistre) {
        return typeSinistre == this.typeSinistre;
    }
}
