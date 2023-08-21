package vue;

import controller.EcouteurModele;
import controller.ModelEcoutable;
import modele.elements.BatailleNavale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GrillePanel extends JPanel implements EcouteurModele {
    private static final int LARGEUR = 10;
    private static final int HAUTEUR = 10;
    private static final int TAILLECASE = LARGEUR * HAUTEUR;
    private JPanel[][] grille;
    private BatailleNavale batailleNavale;
    public GrillePanel(BatailleNavale batailleNavale){
        this.grille=new JPanel[LARGEUR][HAUTEUR];
        this.add(this.creerGrille(grille, LARGEUR, HAUTEUR));
        this.batailleNavale=batailleNavale;
    }
    private JPanel creerGrille(JPanel[][] grille, int ligne, int colonne) {
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
    public int jouer(){
        return 6;
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

    @Override
    public void modeleMisAJour(ModelEcoutable source) {
        if(source == batailleNavale){
            repaint();
        }
    }
    public void paintChildren(Graphics g){
        super.paintChildren(g);
        int hauteur = getHeight() / 3;
        int dim = Math.min(getWidth(), hauteur);

        /*int x = (getWidth() - dim) / 2;
        int y = 0;*/
        g.drawRect(0,100,100,100);
    }

}
