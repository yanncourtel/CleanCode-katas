package zenika.smells.autres.getset;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SouscriptionTest {
    
    @Test public void un_souscripteur_sans_contrat_specifique_ne_devrait_pas_etre_assure_contre_la_grele() {
        Souscripteur monsieurDupont = new Souscripteur();
        assertFalse(monsieurDupont.estAssureContre(TypeSinistre.GRELE)); 
    }
    
    @Test public void un_souscripteur_du_contrat_grele_devrait_etre_assure_contre_la_grele() {
        Souscripteur monsieurDupont = new Souscripteur();
        monsieurDupont.souscrit(new ContratAssurance(TypeSinistre.GRELE));
        assertTrue(monsieurDupont.estAssureContre(TypeSinistre.GRELE)); 
    }
    
    @Test public void un_souscripteur_du_contrat_auto_ne_devrait_pas_etre_assure_contre_la_grele() {
        Souscripteur monsieurDupont = new Souscripteur();
        monsieurDupont.souscrit(new ContratAssurance(TypeSinistre.AUTOMOBILE));
        assertFalse(monsieurDupont.estAssureContre(TypeSinistre.GRELE)); 
    }
    
}
