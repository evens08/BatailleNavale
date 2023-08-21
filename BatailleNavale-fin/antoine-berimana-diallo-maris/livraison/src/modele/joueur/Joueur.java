package modele.joueur;

import modele.elements.BatailleNavale;
import modele.elements.CoordonneesBataille;

/**
 * Interface représentant un joueur
 */
public interface Joueur {
    /**
     * Renvoie un coup
     * @param batailleNavale Une instance de BatailleNavale
     * @return Coup
     */
    public CoordonneesBataille choisirCoup(BatailleNavale batailleNavale);
    
}
