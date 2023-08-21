package modele.elements;

import java.util.Objects;

/**
 * Classe représentant une pièce de bateau pour bataille navale
 * @author antoine222
 */
public class PieceBateau {

    private int ligne;
    private int colonne;
    public static final int INTACTE=0;
    public static final int TOUCHEE=1;
    public static final int COULEE=2;
    public static final int LOUPEE=3;

    protected int etatCourant;


    /**
     * Créer une pièce de bateau INTACTE
     * @param ligne L'indice ligne de la pièce
     * @param colonne L'indice colonne de la pièce
     */
    public PieceBateau(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.etatCourant = INTACTE;
    }

    /**
     * Créer une pièce de bateau avec un état choisi
     * @param ligne L'indice ligne de la pièce
     * @param colonne L'indice colonne de la pièce
     * @param etat un entier entre 0 et 3
     */
    public PieceBateau(int ligne,int colonne, int etat){
        this(ligne,colonne);
        this.etatCourant= etat % 4;
    }


    /**
     * Affiche ce qui correspond a l'état
     * @return Message indiquand l'état de la pièce
     */
    public String etatPieceBateau() {
        switch (this.etatCourant) {
            case INTACTE:
                //this.etatCourant = 0;
                return "Intact !";

            case TOUCHEE:
                //this.etatCourant = 1;
                return "Touché !";

            case COULEE:
                //this.etatCourant = 2;
                return "Coulé !";

            case LOUPEE:
                //this.etatCourant=3;
               return "Loupé !";
            default:
                return "Fates rien";
        }
    }

    /**
     * Change l'état de la pièce si elle est intacte en touchée sinon ne fait rien
     */
    public void changerEtat() {
    	if (this.etatCourant==INTACTE) {
    		this.etatCourant=TOUCHEE;
    	}
    }

    /**
     * Renvoie la ligne de la pièce
     * @return La ligne de la pièce
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * Modifie la ligne de la pièce
     * @param ligne La ligne de la pièce
     */
    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    /**
     * Renvoie la colonne de la pièce
     * @return La colonne de la pièce
     */
    public int getColonne() {
        return colonne;
    }

    /**
     * Modifie la colonne de la pièce
     * @param colonne La colonne de la pièce
     */
    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    /**
     * Renvoie l'état courant de la pièce
     * @return L'état de la pièce sous forme d'entier
     */
    public int getEtatCourant() {
        return etatCourant;
    }

    /**
     * Modifie l'état courant de la pièce
     * @param etatCourant Etat nouveau
     */
    public void setEtatCourant(int etatCourant) {
        this.etatCourant = etatCourant % 4;
    }

    public String toString(){
        return "("+this.getLigne()+","+this.getColonne()+")";
    }


    @Override
    public boolean equals(Object other){
        if (other==null){
            return false;
        }
        if (!(other instanceof PieceBateau)){
            return false;
        }
        PieceBateau otherAsPieceBat=(PieceBateau) other;
        return this.ligne==otherAsPieceBat.getLigne() && this.colonne== otherAsPieceBat.getColonne() && this.etatCourant==otherAsPieceBat.getEtatCourant();
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode(){
        return Objects.hash(this.ligne,this.colonne,this.etatCourant);
    }


}
