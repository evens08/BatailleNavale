/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bataillenavale;

/**
 *
 * @author antoine222
 */
public class PieceBateau {

    private int ligne;
    private int colonne;

    private enum Etat {
        INTACTE, TOUCHEE, COULEE;
    }

    private Etat etatCourant;

    public PieceBateau() {
        this(0, 0);
    }

    public PieceBateau(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.etatCourant = Etat.INTACTE;
    }

    public void etatPieceBateau() {
        switch (this.etatCourant) {
            case INTACTE:
                this.etatCourant = Etat.INTACTE;
                System.out.println("La pièce est intacte.");
                break;

            case TOUCHEE:
                this.etatCourant = Etat.TOUCHEE;
                System.out.println("La pièce a été touchée.");
                break;

            case COULEE:
                this.etatCourant = Etat.COULEE;
                System.out.println("La pièce est coulée.");
                break;

            default:
                System.out.println("Fates rien");
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

    public Etat getEtatCourant() {
        return etatCourant;
    }

    public void setEtatCourant(Etat etatCourant) {
        this.etatCourant = etatCourant;
    }

}
