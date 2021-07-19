package zenika.smells.autres.getset;

import java.util.HashSet;
import java.util.Set;

public class Souscripteur {
    
    private final Set<ContratAssurance> souscriptions = new HashSet<>();
    
    public boolean estAssureContre(TypeSinistre typeSinistre) {
        return souscriptions.stream().anyMatch(
                contrat -> contrat.couvre(typeSinistre)
        );
    }
    
    public void souscrit(ContratAssurance contrat) {
        souscriptions.add(contrat);    
    }
}
