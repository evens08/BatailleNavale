/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.EcouteurModele;

import controller.ModelEcoutable;
import modele.elements.BatailleNavale;
import modele.elements.Bateau;
import modele.elements.Mer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANTOINE
 */
public class VueBataille extends JPanel implements EcouteurModele {

    private static final int LARGEUR = 10;
    private static final int HAUTEUR = 10;
    private JPanel[][] grilleJoueur;
    private JPanel[][] grilleAdverse;
    private Mer mer;

    private BatailleNavale bataille;

    public VueBataille(BatailleNavale bataille) {
        this.mer = new Mer();
        this.bataille = bataille;
        this.bataille.ajouterEcouteur(this);

        this.grilleJoueur = new JPanel[LARGEUR][HAUTEUR];
        this.grilleAdverse = new JPanel[LARGEUR][HAUTEUR];

        this.add(this.creerGrilleAdverse(grilleAdverse, LARGEUR, HAUTEUR));
        this.add(this.creerGrilleJoueur(grilleJoueur, LARGEUR, HAUTEUR));

    }

    private JPanel creerGrilleJoueur(JPanel[][] grille, int ligne, int colonne) {
        JPanel joueur = new JPanel(new GridLayout(ligne + 1, colonne + 1));
        this.creerLigne(joueur, colonne);

        // Récupération de la flotte de la mer
        ArrayList<Bateau> flotte = mer.getFlotte();

        for (int i = 0; i < ligne; i++) {
            this.creerColonne(joueur, i + 1);
            for (int j = 0; j < colonne; j++) {
                grille[i][j] = new JPanel();
                final int x = i;
                final int y = j;
                grille[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                grille[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent event) {
                        System.out.println("Case cliquée : (" + x + "," + y + ")");
                    }
                });
                joueur.add(grille[i][j]).setPreferredSize(new Dimension(((ligne + colonne) * 3) / 2, ((ligne + colonne) * 3) / 2));

                // Parcours de chaque bateau de la flotte pour le placer sur la grille joueur
                for (Bateau bateau : flotte) {
                    int bateauPosX = bateau.getLigne();
                    int bateauPosY = bateau.getColonne();
                    for (int k = 0; k < bateau.getTaille(); k++) {
                        // Vérification si la case courante correspond à une case occupée par le bateau
                        if (bateauPosX == i && bateauPosY == j) {
                            grille[i][j].setBackground(Color.GRAY);
                            break; // On a trouvé la case occupée par le bateau, on peut sortir de la boucle
                        }
                        // Passage à la case suivante occupée par le bateau
                        if (bateau.isHorizontal()) {
                            bateauPosY++;
                        } else {
                            bateauPosX++;
                        }
                    }
                }

            }
        }
        return joueur;
    }

    private JPanel creerGrilleAdverse(JPanel[][] grille, int ligne, int colonne) {
        JPanel adversaire = new JPanel(new GridLayout(ligne + 1, colonne + 1));
        this.creerLigne(adversaire, colonne);

        for (int i = 0; i < ligne; i++) {
            this.creerColonne(adversaire, i + 1);
            for (int j = 0; j < colonne; j++) {
                grille[i][j] = new JPanel();
                grille[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                adversaire.add(grille[i][j]).setPreferredSize(new Dimension(((ligne + colonne) * 3) / 2, ((ligne + colonne) * 3) / 2));
            }
        }
        return adversaire;
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

    public JPanel[][] getGrilleJoueur() {
        return grilleJoueur;
    }

    public void setGrilleJoueur(JPanel[][] grilleJoueur) {
        this.grilleJoueur = grilleJoueur;
    }

    public JPanel[][] getGrilleAdverse() {
        return grilleAdverse;
    }

    public void setGrilleAdverse(JPanel[][] grilleAdverse) {
        this.grilleAdverse = grilleAdverse;
    }

    @Override
    public void modeleMisAJour(ModelEcoutable source) {
        if (source == bataille) {
            repaint();
        }
    }

}
