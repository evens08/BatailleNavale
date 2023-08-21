/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;

import controller.EcouteurModele;
import controller.ModelEcoutable;
import modele.elements.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;



/**
 *
 * @author ANTOINE
 */
public class GrilleGraphique extends JPanel implements EcouteurModele {
    public static final Color COULEUR_BATEAU_5=Color.CYAN;
    public static final Color COULEUR_BATEAU_4=Color.YELLOW;
    public static final Color COULEUR_BATEAU_3_1=Color.ORANGE;
    public static final Color COULEUR_BATEAU_3_2=Color.MAGENTA;
    public static final Color COULEUR_BATEAU_2=Color.GREEN;

    public static final Color[] COULEURS_FLOTTES={COULEUR_BATEAU_5,COULEUR_BATEAU_4,COULEUR_BATEAU_3_1,COULEUR_BATEAU_3_2,COULEUR_BATEAU_2};
    private static final int LARGEUR = 10;
    private static final int HAUTEUR = 10;
    private JPanel[][] grille;
    private BatailleNavale bataille;
    private Mer mer;

    boolean ecoute;

    public GrilleGraphique() {
        this(new BatailleNavale(),new Mer(), true);
    }
    public GrilleGraphique(BatailleNavale bataille,Mer mer, boolean ecoute){
        this.mer = mer;
        this.bataille=bataille;
        this.ecoute = ecoute;
        this.grille = new JPanel[LARGEUR][HAUTEUR];
        /*System.out.println(mer);
        for (Bateau bateau : mer.getFlotte()) {
            System.out.println(bateau);

        }*/
        this.bataille.ajouterEcouteur(this);
        this.add(this.creerGrille(grille, LARGEUR, HAUTEUR));

    }

    public BatailleNavale getBataille() {
        return bataille;
    }

    private JPanel creerCase(int i, int j) {
        JPanel caseGrille = new JPanel();
        caseGrille.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        if (this.mer.getGrille()[i][j] != null) {
            switch (mer.getGrille()[i][j].getEtatCourant()) {
                case PieceBateau.INTACTE:
                    caseGrille.setBackground(Color.WHITE);
                    break;
                case PieceBateau.TOUCHEE:
                    caseGrille.setBackground(Color.PINK);
                    System.out.println("on est dans le vide");
                    break;
                case PieceBateau.COULEE:
                    caseGrille.setBackground(Color.RED);
                    break;
                case PieceBateau.LOUPEE:
                    caseGrille.setBackground(Color.BLACK);
                    break;
                default:
                    caseGrille.setBackground(Color.WHITE);
                    break;
            }
        } else {
            caseGrille.setBackground(Color.GRAY);
        }


        if(ecoute) {
            caseGrille.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent event) {
                    System.out.println("Case cliquée : (" + i + "," + j + ")");

                    CoordonneesBataille coup;
                    coup = new CoordonneesBataille(i, j);
                    //System.out.println(coup);
                    System.out.println(bataille.getMerOrdi());
                    System.out.println(bataille.getMerJoueur());
                   // System.out.println(bataille.isValid(coup));
                    if (bataille.isValid(coup)) {
                        bataille.jouerCoup(coup);
                        bataille.jouerCoup(bataille.getJoueurCourant().choisirCoup(bataille));


                    }
                    if (bataille.isOver()) {
                        System.out.println("fin");
                    }

                }
            });
        }
        return caseGrille;
    }

    private JPanel creerGrille(JPanel[][] grille, int ligne, int colonne) {
        JPanel joueur = new JPanel(new GridLayout(ligne, colonne));
//        this.creerLigne(joueur, colonne);

        // Récupération de la flotte de la mer
        ArrayList<Bateau> flotte = mer.getFlotte();

        for (int i = 0; i < ligne; i++) {
//            this.creerColonne(joueur, i + 1);
            for (int j = 0; j < colonne; j++) {
                this.grille[i][j] = creerCase(i, j);
                //this.grille[i][j].setBackground(Color.lightGray);
                /*if (this.mer.getGrille()[i][j] != null) {
                    switch (mer.getGrille()[i][j].getEtatCourant()) {
                        case PieceBateau.INTACTE:
                            this.grille[i][j].setBackground(Color.WHITE);
                            break;
                        case PieceBateau.TOUCHEE:
                            this.grille[i][j].setBackground(Color.PINK);
                            System.out.println("on est dans le vide");
                            break;
                        case PieceBateau.COULEE:
                            this.grille[i][j].setBackground(Color.RED);
                            break;
                        case PieceBateau.LOUPEE:
                            this.grille[i][j].setBackground(Color.BLACK);
                            break;
                        default:
                            this.grille[i][j].setBackground(Color.WHITE);
                            break;
                    }
                } else {
                    //grille[i][j].setBackground(Color.GRAY);
                }*/
                joueur.add(this.grille[i][j]).setPreferredSize(new Dimension(((ligne + colonne) * 3) / 2, ((ligne + colonne) * 3) / 2));
            }
        }

        if(ecoute){
        int c=0;
        for (Bateau bateau : mer.getFlotte()) {
            Color couleur = COULEURS_FLOTTES[c];
            for (int i = 0; i < bateau.getTaille(); i++) {
                if (bateau.isHorizontal()) {
                    grille[bateau.getLigne()][bateau.getColonne() + i].setBorder(
                            BorderFactory.createLineBorder(couleur, 3));
                } else {
                    grille[bateau.getLigne() + i][bateau.getColonne()].setBorder(
                            BorderFactory.createLineBorder(couleur, 3));
                }
            }
            c++;
        }

            /*               for (Bateau bateau : flotte) {
                    int bateauPosX = bateau.getLigne();
                    int bateauPosY = bateau.getColonne();
                    for (int k = 0; k < bateau.getTaille(); k++) {
                        if (bateauPosX == i && bateauPosY == j) {
                            grille[i][j].setBackground(Color.GREEN);
                            break;
                        }

                        if (bateau.isHorizontal()) {
                            bateauPosY++;
                        } else {
                            bateauPosX++;
                        }
                    }
               }*/
        }
//        }
        return joueur;
    }

    private void creerLigne(JPanel jpanel, int iterations) {
        jpanel.add(new JLabel());
        for (int i = 0; i < iterations; i++) {
            jpanel.add(new JLabel(Character.toString((char) ('A' + i))));
        }
    }

    private void creerColonne(JPanel jpanel, int iterations) {
        jpanel.add(new JLabel(Integer.toString(iterations)));
    }

    public JPanel[][] getGrille() {
        return grille;
    }

    public void setGrille(JPanel[][] grille) {
        this.grille = grille;
    }

    public void setColor(int x, int y, int etat) {
        if (x >= 0 && x < 10 && y >= 0 && y < 10) {
            if (grille[x][y] != null) {
                switch (etat) {
                    case 0:
                        grille[x][y].setBackground(Color.BLUE);
                        break;
                    case 1:
                        grille[x][y].setBackground(Color.PINK);
                        break;
                    case 2:
                        grille[x][y].setBackground(Color.RED);
                        break;
                    case 3:
                        grille[x][y].setBackground(Color.BLACK);
                        break;
                }
            } else {
                grille[x][y].setBackground(Color.WHITE);
            }
        }
    }

    @Override
    public void modeleMisAJour(ModelEcoutable source) {
        if(source==bataille){
            //this.removeAll();
            this.grille=new JPanel[10][10];
            this.add(this.creerGrille(grille, LARGEUR, HAUTEUR));

        }
    }
}

