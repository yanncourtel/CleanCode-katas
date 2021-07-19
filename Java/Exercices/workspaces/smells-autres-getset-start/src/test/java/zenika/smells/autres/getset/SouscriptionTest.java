package zenika.smells.autres.getset;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SouscriptionTest {
    
    private final SouscriptionService souscriptionService = new SouscriptionService();
    
    @Test public void un_souscripteur_sans_contrat_specifique_ne_devrait_pas_etre_assure_contre_la_grele() {
        Souscripteur monsieurDupont = new Souscripteur();
        assertFalse(souscriptionService.estAssureContre(monsieurDupont, TypeSinistre.GRELE)); 
    }
    
    @Test public void un_souscripteur_du_contrat_grele_devrait_etre_assure_contre_la_grele() {
        Souscripteur monsieurDupont = new Souscripteur();
        souscriptionService.souscritContrat(monsieurDupont, TypeSinistre.GRELE);
        assertTrue(souscriptionService.estAssureContre(monsieurDupont, TypeSinistre.GRELE));
    }
    
    @Test public void un_souscripteur_du_contrat_auto_ne_devrait_pas_etre_assure_contre_la_grele() {
        Souscripteur monsieurDupont = new Souscripteur();
        souscriptionService.souscritContrat(monsieurDupont, TypeSinistre.AUTOMOBILE);
        assertFalse(souscriptionService.estAssureContre(monsieurDupont, TypeSinistre.GRELE)); 
    }
    
}
