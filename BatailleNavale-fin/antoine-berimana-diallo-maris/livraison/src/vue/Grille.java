package vue;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import modele.elements.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Graphics;
import javax.swing.border.LineBorder;

public class Grille extends JPanel {
    private Mer mer;
    private final BatailleNavale bataille;
    private boolean ecoute;
    private int tailleCase;
    private static final int TAILLE_CASE = 40;
    private static final int NB_CASES = 10;
    private static final int LARGEUR_GRILLE = TAILLE_CASE * NB_CASES;
    private static final int HAUTEUR_GRILLE = TAILLE_CASE * NB_CASES;

    public Grille() {
        this(new BatailleNavale(), new Mer(), true);
    }

    public Grille(BatailleNavale bataille, Mer mer, boolean ecoute) {
        this.mer = mer;
        this.bataille = bataille;
        this.ecoute = ecoute;
        this.tailleCase = TAILLE_CASE;
        this.setPreferredSize(new Dimension((LARGEUR_GRILLE * 3) / 2, (HAUTEUR_GRILLE * 3) / 2));
        this.setBorder(new LineBorder(Color.BLACK, 3));

        if (ecoute) {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent event) {
                    Point point = event.getPoint();

                    int ligne = point.x / tailleCase;
                    int colonne = point.y / tailleCase;
                    if (ligne >= 10 || colonne >= 10) {
                        System.out.println("Hors portée");
                    } else {
                        CoordonneesBataille coup = new CoordonneesBataille(ligne, colonne);
                        if (bataille.isValid(coup)) {
                            bataille.jouerCoup(coup);
                            if (bataille.isOver()) {
                                JOptionPane.showMessageDialog(new JPanel(), "Le ou la " + bataille.getWinner() + " a gagné");
                                System.exit(0);
                            }
                            bataille.jouerCoup(bataille.getJoueurCourant().choisirCoup(bataille));
                            if (bataille.isOver()) {
                                JOptionPane.showMessageDialog(new JPanel(), bataille.getWinner() + " a gagné");
                                System.exit(0);
                            } else {
                                System.out.println("Case invalide");
                            }
                        }
                        System.out.println("Case cliquee (" + ligne + ", " + colonne + ")");
                    }

                }
            });
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        this.tailleCase = Math.min(width, height) / 10;
        int dimensionMin = this.tailleCase * 10;
        
        g2d.setColor(Color.CYAN);
        g2d.fillRect(0, 0, dimensionMin, dimensionMin);

        // Colonnes
        for (int x = 0; x <= dimensionMin; x += this.tailleCase) {
            g.setColor(Color.gray);
            g.drawLine(x, 0, x, dimensionMin);
        }

        // Lignes
        for (int y = 0; y <= dimensionMin; y += this.tailleCase) {
            g.setColor(Color.gray);
            g.drawLine(0, y, dimensionMin, y);
        }
        g.setClip(0, 0, dimensionMin, dimensionMin);

        g.setColor(Color.BLACK);
        if (!ecoute) {
            for (Bateau bateau : mer.getFlotte()) {
                this.bateauDessin(g2d, bateau);
            }
        } else {
            for (Bateau bateau : mer.getFlotte()) {
                if (bateau.isCoulee()) {
                    this.bateauDessin(g2d, bateau);
                }
            }
        }

        int centreCase = this.tailleCase / 4;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int nextLigne = i * tailleCase;
                int nextColonne = j * tailleCase;
                if (mer.getGrille()[i][j] != null) {
                    switch (mer.getGrille()[i][j].getEtatCourant()) {
                        case PieceBateau.INTACTE:
                            break;
                        case PieceBateau.TOUCHEE:
                            g2d.setColor(Color.ORANGE);
                            g2d.fillOval(centreCase + nextLigne, centreCase + nextColonne, centreCase * 2, centreCase * 2);
                            break;
                        case PieceBateau.COULEE:
                            g2d.setColor(Color.RED);
                            g.fillOval(centreCase + nextLigne, centreCase + nextColonne, centreCase * 2, centreCase * 2);
                            break;
                        case PieceBateau.LOUPEE:
                            g2d.setColor(Color.GREEN);
                            g2d.fillOval(centreCase + nextLigne, centreCase + nextColonne, centreCase * 2, centreCase * 2);
                            break;
                        default:
                            break;
                    }
                }
            }
        }

    }

    private void bateauDessin(Graphics2D g2d, Bateau bateau) {
        int xBat = bateau.getLigne();
        int yBat = bateau.getColonne();
        int tailleBat = bateau.getTaille();
        boolean horizontal = bateau.isHorizontal();
        g2d.setStroke(new BasicStroke(4.0f));
        if (horizontal) {
            g2d.drawRoundRect(xBat * this.tailleCase, yBat * this.tailleCase, this.tailleCase, this.tailleCase * tailleBat, 40, 40);
        } else {
            g2d.drawRoundRect(xBat * this.tailleCase, yBat * this.tailleCase, this.tailleCase * tailleBat, this.tailleCase, 40, 40);
        }
    }

}
