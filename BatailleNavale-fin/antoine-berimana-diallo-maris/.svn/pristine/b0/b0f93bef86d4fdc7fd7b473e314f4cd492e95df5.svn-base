package premieremisecommun;

/**
 *
 * @author antoine222
 */
public class PieceBateau {

    private int ligne;
    private int colonne;
    private static final int INTACTE=0;
    private static final int TOUCHEE=1;
    private static final int COULEE=2;
    
    /*public enum Etat {
        INTACTE, TOUCHEE, COULEE;
    }*/

    //private Etat etatCourant;
    protected int etatCourant;

    public PieceBateau() {
        this(0, 0);
    }

    public PieceBateau(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.etatCourant = INTACTE;
    }

    public void etatPieceBateau() {
        switch (this.etatCourant) {
            case INTACTE:
                this.etatCourant = 0;
                System.out.println("La pièce est intacte.");
                break;

            case TOUCHEE:
                this.etatCourant = 1;
                System.out.println("La pièce a été touchée.");
                break;

            case COULEE:
                this.etatCourant = 2;
                System.out.println("La pièce est coulée.");
                break;

            default:
                System.out.println("Fates rien");
        }
    }
    public void changerEtatIntacteToTouchee() {
    	if (this.etatCourant==INTACTE) {
    		this.etatCourant=TOUCHEE;
    	}
    }


    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    /*public Etat getEtatCourant() {
        return etatCourant;
    }*/
    public int getEtatCourant() {
        return etatCourant;
    }

    /*public void setEtatCourant(Etat etatCourant) {
        this.etatCourant = etatCourant;
    }*/
    public void setEtatCourant(int etatCourant) {
        this.etatCourant = etatCourant;
    }

}
