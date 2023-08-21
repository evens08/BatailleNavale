/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;


import modele.elements.BatailleNavale;
import modele.joueur.JoueurHumain;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ANTOINE
 */
public class Accueil extends JFrame implements ActionListener {

    private BatailleNavale bataille;
    private ChargerNomGraphique formulaire;
    private static boolean login = false;

    public Accueil() {
        this(new ChargerNomGraphique());
    }

    public Accueil(ChargerNomGraphique formulaire) {
        this.formulaire = formulaire;
        this.bataille = new BatailleNavale(new JoueurHumain("Joueur"));
        this.add(this.formulaire);

        this.formulaire.getBtnSubmit().addActionListener(this);
        this.formulaire.getBtnReset().addActionListener(this);

        this.pack();
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == this.formulaire.getBtnReset()) {
//            reset
        } else if (event.getSource() == this.formulaire.getBtnSubmit()) {

            String nomJoueur = this.formulaire.getTxtJoueur().getText();
            System.out.println("1" + nomJoueur);
            if (!nomJoueur.equals("joueur")) {
                System.out.println("2" + nomJoueur);
                if (!login) {
                    new BatailleGUI(this.bataille);
                    login = true;
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Erreur", "Jour 1", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Erreur", "Jour 1", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
