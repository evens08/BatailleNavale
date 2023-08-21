/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;


import controller.EcouteurModele;
import controller.ModelEcoutable;
import modele.elements.BatailleNavale;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ANTOINE
 */
public class VueBataille2 extends JPanel/* implements EcouteurModele */{

    private GrilleGraphique grilleJoueurGraphique;
    private GrilleGraphique grilleJoueurOrdinateur;
    private BatailleNavale bataille;

    public VueBataille2(BatailleNavale bataille) {
        this.bataille = bataille;
        //this.bataille.ajouterEcouteur(this);

        this.grilleJoueurOrdinateur = new GrilleGraphique(bataille,bataille.getMerOrdi(), true);
        this.grilleJoueurGraphique = new GrilleGraphique(bataille,bataille.getMerJoueur(), true);

        this.add(this.grilleJoueurOrdinateur);
        this.add(this.grilleJoueurGraphique);
        //this.bataille.ajouterEcouteur(this);


    }

    /*@Override
    public void modeleMisAJour(ModelEcoutable source) {
        if (source == bataille) {



            for (int x = 0; x < 10; x++) {
                for (int y = 0; y < 10; y++) {
                    if (this.grilleJoueurOrdinateur.getGrille()[x][y] != null && bataille.getMerOrdi().getGrille()[x][y] != null) {
                        this.grilleJoueurOrdinateur.setColor(x, y, bataille.getMerOrdi().getGrille()[x][y].getEtatCourant());
                    }
                }
            }



            this.removeAll();
            this.grilleJoueurOrdinateur = new GrilleGraphique(bataille,bataille.getMerOrdi(), true);
            this.grilleJoueurGraphique = new GrilleGraphique(bataille,bataille.getMerJoueur(), true);

            this.add(this.grilleJoueurOrdinateur);
            this.add(this.grilleJoueurGraphique);
        }
    }*/

}
