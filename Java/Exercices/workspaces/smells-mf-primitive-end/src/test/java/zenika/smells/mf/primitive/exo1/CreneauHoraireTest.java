package zenika.smells.mf.primitive.exo1;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static zenika.smells.mf.primitive.exo1.CreneauHoraire.aujourdhui;
import static zenika.smells.mf.primitive.exo1.CreneauHoraire.demain;

public class CreneauHoraireTest {

    private static final CreneauHoraire 
        DE_10_A_12 = aujourdhui().de(10).a(12),
        DE_13_A_14 = aujourdhui().de(13).a(14),
        DE_13_A_15 = aujourdhui().de(13).a(15),
        DE_14_A_17 = aujourdhui().de(14).a(17),
        DE_15_A_16 = aujourdhui().de(15).a(16),
        DE_16_A_18 = aujourdhui().de(16).a(18),
        DE_17_A_18 = aujourdhui().de(17).a(18),
        DEMAIN_DE_10_A_12 = demain().de(10).a(12);

    @Test public void deux_creneaux_a_des_jours_differents_ne_devraient_pas_se_chevaucher() {
        assertFalse(DE_10_A_12.chevauche(DEMAIN_DE_10_A_12));    
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void un_creneau_dont_la_fin_est_anterieure_au_debut_devrait_etre_rejete() {
        aujourdhui().de(17).a(16);
    }
    
    @Test(expected = IllegalArgumentException.class) 
    public void un_creneau_vide_devrait_etre_rejete() {
        aujourdhui().de(16).a(16);
    }
    
    @Test public void un_creneau_strictement_anterieur_ne_devrait_pas_chevaucher() {
        assertFalse(DE_10_A_12.chevauche(DE_14_A_17));
    }
    
    @Test public void un_creneau_strictement_posterieur_ne_devrait_pas_chevaucher() {
        assertFalse(DE_14_A_17.chevauche(DE_10_A_12));
    }
    
    @Test public void un_creneau_frolant_le_bord_gauche_ne_devrait_pas_chevaucher() {
        assertFalse(DE_13_A_14.chevauche(DE_14_A_17));
    }
    
    @Test public void un_creneau_frolant_le_bord_droit_ne_devrait_pas_chevaucher() {
        assertFalse(DE_14_A_17.chevauche(DE_17_A_18));
    }
    
    @Test public void un_creneau_strictement_inclus_devrait_chevaucher() {
        assertTrue(DE_15_A_16.chevauche(DE_14_A_17));
    }
    
    @Test public void un_creneau_chevauchant_le_bord_gauche_devrait_chevaucher() {
        assertTrue(DE_13_A_15.chevauche(DE_14_A_17));
    }
    
    @Test public void un_creneau_chevauchant_le_bord_droit_devrait_chevaucher() {
        assertTrue(DE_16_A_18.chevauche(DE_14_A_17));
    }
    
}
