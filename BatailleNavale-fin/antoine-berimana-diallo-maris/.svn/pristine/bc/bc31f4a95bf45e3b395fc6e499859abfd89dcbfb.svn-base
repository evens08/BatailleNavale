package modele.elements;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Classe représentant un bateau pour une bataille navale
 */
public class Bateau {

    private int taille, ligne, colonne;
    private boolean coulee, horizontal;
    private ArrayList<PieceBateau> quiConstitueBateau;

    /**
     * Créer un bateau de taille, de position et d'indices (coordonnées) spécifiés.
     * @param taille La taille du bateau
     * @param ligne La ligne de la première pièce du bateau
     * @param colonne La colonne de la première pièce de bateau
     * @param horizontal L'horizontalité du bateau
     */
    public Bateau(int taille, int ligne, int colonne, boolean horizontal) {
        this.taille = taille;
        this.ligne = ligne;
        this.colonne = colonne;
        this.coulee=false;
        this.horizontal = horizontal;
        this.quiConstitueBateau = this.creationPieces();
    }

    /**
     * Créer une liste de pièces de bateau dépendant de l'horizontalité du bateau.
     * @return Liste de pièce de bateau
     */
    public ArrayList<PieceBateau> creationPieces() {
        ArrayList<PieceBateau> listePiece = new ArrayList<PieceBateau>();
        if (this.horizontal == true) {
            for (int i = 0; i < this.taille; i++) {
                listePiece.add(new PieceBateau(this.ligne, this.colonne + i));
            }
        } else {
            for (int i = 0; i < taille; i++) {
                listePiece.add(new PieceBateau(this.ligne + i, this.colonne));
            }
        }
        return listePiece;
    }

    /**
     * Renvoie si le bateau est coulé
     * @return true si le bateau est coulé, faux sinon
     */
    public boolean isCoulee() {
        return coulee;
    }



    /**
     * Renvoie la taille du bateau
     * @return La taille du bateau
     */
    public int getTaille() {
        return taille;
    }



    /**
     * Renvoie la ligne de la première pièce du bateau
     * @return La ligne de la première pièce du bateau
     */
    public int getLigne() {
        return ligne;
    }

    /**
     * Modifie la ligne de la première pièce du bateau
     * @param ligne La ligne de la première pièce du bateau
     */
    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    /**
     * Renvoie la colonne de la première pièce du bateau
     * @return La colonne de la première pièce du bateau
     */
    public int getColonne() {
        return colonne;
    }

    /**
     * Modifie la colonne de la première pièce du bateau
     * @param colonne La colonne de la première pièce du bateau
     */
    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    /**
     * Getter de horizontal
     * @return true si le bateau est horizontal , faux sinon
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * Modifie le booléen horizontal
     * @param horizontal Le booléen remplaçant
     */
    public void setHorizontal(boolean horizontal) {
        this.horizontal = horizontal;
    }

    /**
     * Renvoie la liste des pièces du bateau
     * @return La liste des pièces du bateau
     */
    public ArrayList<PieceBateau> getQuiConstitueBateau() {
        return quiConstitueBateau;
    }


    /**
     * Change l'état des pièces du bateau en COULEE et met le booleen coulee à true
     */
    public void changerEtatPiecesCoulee() {
        for (int i = 0; i < this.taille; i++) {
            this.quiConstitueBateau.get(i).setEtatCourant(PieceBateau.COULEE);//coulee toutes les pices du bateau
            this.coulee = true;
        }

    }

    /**
     * Décide si le bateau doit couler
     * @return true si le bateau doit couler, faux sinon
     */
    public boolean doitCouler() {
        for (PieceBateau piece : this.quiConstitueBateau) {
            if (piece.getEtatCourant() != PieceBateau.TOUCHEE ) {
                return false;
            }
        }

        return true;
    }


    @Override
    public String toString() {
        return "bateau de taille " + this.taille +"("+this.ligne+","+this.colonne+") " + this.horizontal;
    }


    @Override
    public boolean equals(Object other){
        if (other==null){
            return false;
        }
        if (!(other instanceof Bateau)){
            return false;
        }
        Bateau otherAsBateau=(Bateau) other;
        return this.ligne==otherAsBateau.getLigne() && this.colonne== otherAsBateau.getColonne() && this.taille==otherAsBateau.getTaille() && this.horizontal==otherAsBateau.isHorizontal() && this.coulee==otherAsBateau.isCoulee() && this.quiConstitueBateau==otherAsBateau.getQuiConstitueBateau();
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.ligne,this.colonne,this.taille,this.horizontal,this.coulee,this.quiConstitueBateau);
    }
}

