package zenika.smells.autres.getset;

//Alias SouscriptionManager / SouscriptionHelper
public class SouscriptionService {

    public boolean estAssureContre(Souscripteur souscripteur, TypeSinistre typeSinistre) {
        for(Contrat contrat : souscripteur.getSouscriptions()) {
            if(contrat.getTypeSinistre()==typeSinistre) {
                return true;
            }
        }
        return false;
    }

    public void souscritContrat(Souscripteur souscripteur, TypeSinistre typeSinistre) {
        Contrat contrat = new Contrat();
        contrat.setTypeSinistre(typeSinistre);
        souscripteur.getSouscriptions().add(contrat);
    }
}
