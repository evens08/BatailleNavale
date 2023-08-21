/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bataillenavale;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ANTOINE
 */
public class VueBataille extends JPanel {

    private static final int LARGEUR = 10;
    private static final int HAUTEUR = 10;
    private static final int TAILLECASE = LARGEUR * HAUTEUR;
    private JPanel[][] grilleJoueur;
    private JPanel[][] grilleAdverse;

    public VueBataille() {
//        setLayout(new GridLayout(1, 2));

        this.grilleJoueur = new JPanel[LARGEUR][HAUTEUR];
        this.grilleAdverse = new JPanel[LARGEUR][HAUTEUR];

        this.add(this.creerGrilleJoueur(grilleJoueur, LARGEUR, HAUTEUR));
        this.add(this.creerGrilleAdverse(grilleAdverse, LARGEUR, HAUTEUR));

    }

    private JPanel creerGrilleJoueur(JPanel[][] grille, int ligne, int colonne) {
        JPanel joueur = new JPanel(new GridLayout(ligne + 1, colonne + 1));
        this.creerLigne(joueur, colonne);

        for (int i = 0; i < ligne; i++) {
            this.creerColonne(joueur, i + 1);
            for (int j = 0; j < colonne; j++) {
                grille[i][j] = new JPanel();
                final int x = i;
                final int y = j;
                grille[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                grille[i][j].addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent event) {
//                        if (grille[x][y].getBounds().contains(event.getPoint())) {
                            System.out.println("Case cliquée : (" + x + "," + y + ")");
//                        }
                    }
                });
                joueur.add(grille[i][j]).setPreferredSize(new Dimension(((ligne + colonne) * 3) / 2, ((ligne + colonne) * 3) / 2));
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

}
