/**
 * 
 */
package bataillenavale.modele;

/**
 * @author diallo2210
 *
 */
public class DeroulerBataille1 {
	
    private BatailleNavale partie;
    
    
    public DeroulerBataille1(BatailleNavale partie){
       this.partie=partie;
    }
    
    public void play(){
    	
        CoordonneesBataille coup;
        
        while(this.partie.isOver()==false){
            System.out.println("\nA "+this.partie.getJoueurCourant()+" de jouer");
            System.out.println("\n"+this.partie.getMerJoueur()+"\n");
            System.out.println("\n"+this.partie.getMerOrdi().toStringHide()+"\n");
            coup =this.partie.getJoueurCourant().choisirCoup(this.partie);
            System.out.println("Le coup "+coup+ " a été joué par "+this.partie.getJoueurCourant());
            this.partie.jouerCoup(coup);
        }
        
        System.out.println("\n"+this.partie.getMerJoueur()+"\n");
        System.out.println("\n"+this.partie.getMerOrdi().toStringHide()+"\n");
        System.out.println("Le joueur gagnant est : "+this.partie.getWinner()+" ! Bravo !! !");
    }
}