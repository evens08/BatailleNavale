package modele.elements;

import java.util.ArrayList;
import java.util.Random;

/**
 * Classe représentant une mer de bataille navale
 */
public class Mer {

    private PieceBateau[][] grille;
    private ArrayList<Bateau> flotte;
    private Random rand;

    /**
     * Créer une Mer de 10*10, ajoute les pièces et construit la flotte
     */
    public Mer() {
        this.grille = new PieceBateau[10][10];
        this.rand = new Random();
        // Créer 5 bateaux : 2 bateaux de 3p , 1 de 5p, 1 de 4p et un de 2p
        this.setFlotte(this.consructionFlotte());
        //this.constructionFlotte();

    }

    /**
     * Créer un bateau de taille taille à un endroit possible dans une grille de taille 10 vide
     * @param taille La taille du bateau que l'on veut créer
     * @return Un bateau de taille taille à un endroit possible dans une grille de taille 10 vide
     */
    public Bateau initBateau(int taille) {
        boolean horizontal = rand.nextBoolean();
        Bateau bateau;
        if (horizontal == true) {
            bateau = new Bateau(taille, rand.nextInt(10), rand.nextInt((10 - taille) + 1), horizontal);
        } else {
            bateau = new Bateau(taille, rand.nextInt((10 - taille) + 1), rand.nextInt(10), horizontal);//Aléatoire de la position de départ du bateau et de sa direction
        }
        return bateau;
    }

    /**
     * Décide si un bateau peut être positionné dans la grille sans conflits
     * @param bateau Un bateau candidat
     * @return true si le bateau peut être positionné, faux sinon
     */
    public boolean testPosition(Bateau bateau) {
        boolean booleen = false;
        if (bateau.isHorizontal() != false) {
            for (int c = 0; c < bateau.getTaille(); c++) {
                if (grille[bateau.getLigne()][bateau.getColonne() + c] != null) {
                    return booleen;
                }
            }
        } else {
            for (int l = 0; l < bateau.getTaille(); l++) {
                if (grille[bateau.getLigne() + l][bateau.getColonne()] != null) {
                    return booleen;
                }
            }
        }
        return !booleen;
    }

    /**
     * Place les pièces du bateau dans la grille et renvoie ce bateau
     * @param bateau Un bateau
     * @return Le même bateau
     */
    public Bateau placerBateauGrille(Bateau bateau) {

        if (bateau.isHorizontal()) {
            for (int c = 0; c < bateau.getTaille(); c++) {
                grille[bateau.getLigne()][bateau.getColonne() + c] = bateau.getQuiConstitueBateau().get(c);
            }
        } else {
            for (int l = 0; l < bateau.getTaille(); l++) {
                grille[bateau.getLigne() + l][bateau.getColonne()] = bateau.getQuiConstitueBateau().get(l);
            }
        }
        return bateau;
    }

    /**
     * Construis la flotte et place les bateaux, la flotte est constituée d'un bateau de taille cinq, un de taille quatre, deux de taille trois et une de taille un
     * @return Une liste de bateaux
     */
    public ArrayList<Bateau> consructionFlotte() {
        Bateau bateau_cinq = this.initBateau(5);
        bateau_cinq = this.placerBateauGrille(bateau_cinq);

        Bateau bateau_quatre;
        do {
            bateau_quatre = this.initBateau(4);

        } while (!this.testPosition(bateau_quatre));
        bateau_quatre = this.placerBateauGrille(bateau_quatre);

        Bateau bateau_trois_1;
        do {
            bateau_trois_1 = this.initBateau(3);

        } while (!this.testPosition(bateau_trois_1));
        bateau_trois_1 = this.placerBateauGrille(bateau_trois_1);

        Bateau bateau_trois_2;
        do {
            bateau_trois_2 = this.initBateau(3);

        } while (!this.testPosition(bateau_trois_2));
        bateau_trois_2 = this.placerBateauGrille(bateau_trois_2);

        Bateau bateau_deux;
        do {
            bateau_deux = this.initBateau(2);

        } while (!this.testPosition(bateau_deux));
        bateau_deux = this.placerBateauGrille(bateau_deux);

        ArrayList<Bateau> flotte = new ArrayList<Bateau>();
        flotte.add(bateau_cinq);
        flotte.add(bateau_quatre);
        flotte.add(bateau_trois_1);
        flotte.add(bateau_trois_2);
        flotte.add(bateau_deux);
        return flotte;
    }

    /**
     * Renvoie la flotte
     * @return Liste des bateaux de la flotte
     */
    public ArrayList<Bateau> getFlotte() {
        return flotte;
    }

    /**
     *  Modifie la flotte
     * @param flotte Liste de bateaux
     */
    public void setFlotte(ArrayList<Bateau> flotte) {
        this.flotte = flotte;
    }

    /**
     * Renvoie la représentation de la grille dévoilée
     * @return La représentaion de la grille dévoilée
     */
    @Override
    public String toString() {
        StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("   ");
        for (int i = 0; i < grille[0].length; i++) {
            strBuilder.append((char) ('A' + i)).append(" ");
        }
        strBuilder.append("\n");

        for (int i = 0; i < grille.length; i++) {
            if (i == 9) {
                strBuilder.append((i + 1)).append(" ");
            } else {
                strBuilder.append(" ").append((i + 1)).append(" ");
            }
            for (int j = 0; j < grille[0].length; j++) {
                if (grille[i][j] == null) {
                    strBuilder.append(". ");
                } else if (grille[i][j].getEtatCourant() == PieceBateau.INTACTE) {
                    strBuilder.append("O ");
                } else if (grille[i][j].getEtatCourant() == PieceBateau.TOUCHEE) {
                    strBuilder.append("X ");
                } else if (grille[i][j].getEtatCourant() == PieceBateau.COULEE) {
                    strBuilder.append("! ");
                } else {
                    strBuilder.append("# ");
                }
            }
            strBuilder.append("\n");
        }
        return strBuilder.toString();
    }

    /**
     * Renvoie la grille de la mer
     * @return La grille de la mer
     */
    public PieceBateau[][] getGrille() {
        return grille;
    }

    /**
     * Renvoie la représentation cachée de la grille
     * @return La représentation cachée de la grille
     */
    public String toStringHide() {
        String representation = this.toString();
        String representationCachee = representation.replaceAll("O", ".");
        return representationCachee;
    }

    /**
     * Change l'état des bateaux dont toutes les pièces sont touchées en coulée
     */
    public void actualisationBateauCoulee() {
        for (Bateau bateau : this.flotte) {
            if (bateau.doitCouler()) {
                System.out.println(bateau+" a été coulé.");
                bateau.changerEtatPiecesCoulee();
            }

        }
    }

    /**
     * Modifie la grille
     * @param grille Grille remplaçante
     */
    public void setGrille(PieceBateau[][] grille) {
        this.grille=grille;
    }
}
