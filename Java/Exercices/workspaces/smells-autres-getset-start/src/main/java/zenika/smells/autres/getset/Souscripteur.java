package zenika.smells.autres.getset;

import java.util.HashSet;
import java.util.Set;

public class Souscripteur {

    private Set<Contrat> souscriptions = new HashSet<>();

    public Set<Contrat> getSouscriptions() {
        return this.souscriptions;
    }

    public void setSouscriptions(Set<Contrat> souscriptions) {
        this.souscriptions = souscriptions;
    }

}
