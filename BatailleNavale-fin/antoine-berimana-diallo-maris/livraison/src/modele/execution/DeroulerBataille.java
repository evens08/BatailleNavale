package modele.execution;

import modele.elements.BatailleNavale;
import modele.elements.CoordonneesBataille;

/**
 * Classe pour dérouler une partie de bataille navale
 */
public class DeroulerBataille {
    private BatailleNavale partie;

    /**
     * Créer une instance de DéroulerBataille avec une instance de BatailleNavale
     * @param partie Une instance de BatailleNavale
     */
    public DeroulerBataille(BatailleNavale partie){
       this.partie=partie;
    }

    /**
     * Déroule une partie tant qu'elle n'est pas finie.
     */
    public void play(){
        CoordonneesBataille coup;
        while(!this.partie.isOver()){
            System.out.println("\nA "+this.partie.getJoueurCourant()+" de jouer");
            System.out.println("\n"+this.partie.getMerJoueur()+"\n");
            System.out.println("\n"+this.partie.getMerOrdi().toStringHide()+"\n");
            coup =this.partie.getJoueurCourant().choisirCoup(this.partie);
            System.out.println("Le coup "+coup+ " a été joué par "+this.partie.getJoueurCourant());
            this.partie.jouerCoup(coup);



        }
        System.out.println("\n"+this.partie.getMerJoueur()+"\n");
        System.out.println("\n"+this.partie.getMerOrdi().toStringHide()+"\n");
        System.out.println("Le joueur gagnant est : "+this.partie.getWinner()+" ! Bravo <3 !");
    }

    /**
     * Renvoie la partie de BatailleNavale
     * @return la partie de BatailleNavale
     */
    public BatailleNavale getPartie() {
        return partie;
    }
}
