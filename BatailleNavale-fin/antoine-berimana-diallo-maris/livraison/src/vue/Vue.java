/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;

import controller.EcouteurModele;
import controller.ModelEcoutable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import modele.elements.BatailleNavale;

/**
 *
 * @author ANTOINE
 */
public class Vue extends JPanel implements EcouteurModele {

    private BatailleNavale bataille;
    private Grille merJoueur;
    private Grille merOrdi;

    private JPanel panelMerJoueur;
    private JPanel panelMerOrdi;
    private JPanel lesDeuxMers;

    @SuppressWarnings("LeakingThisInConstructor")
    public Vue(BatailleNavale bataille) {
        this.bataille = bataille;
        this.bataille.ajouterEcouteur(this);
        this.lesDeuxMers = new JPanel(new GridLayout(1, 2));
        this.setLayout(new GridLayout(1,2));
        this.merJoueur = new Grille(bataille, bataille.getMerOrdi(), true);
        this.merOrdi = new Grille(bataille, bataille.getMerJoueur(), false);

        JPanel colonnes = new JPanel(new GridLayout(1, 10));
        colonnes.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(Character.toString((char) ('A' + i)));
            label.setHorizontalAlignment(JLabel.CENTER);
            colonnes.add(label);
        }

        // Lignes
        JPanel lignes = new JPanel(new GridLayout(10, 1));
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(Integer.toString(i + 1));
            label.setHorizontalAlignment(JLabel.CENTER);
            lignes.add(label);
        }

        // Ajout a la vue
        this.panelMerJoueur = new JPanel(new BorderLayout());
        this.panelMerJoueur.add(colonnes, BorderLayout.NORTH);
        this.panelMerJoueur.add(lignes, BorderLayout.WEST);
        this.panelMerJoueur.add(this.merJoueur, BorderLayout.CENTER);
        panelMerJoueur.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

//*************************************************************************************************************
        // Colonnes 2
        JPanel colonnes2 = new JPanel(new GridLayout(1, 10));
        colonnes2.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(Character.toString((char) ('A' + i)));
            label.setHorizontalAlignment(JLabel.CENTER);
            colonnes2.add(label);
        }

        // Lignes 2
        JPanel lignes2 = new JPanel(new GridLayout(10, 1));
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(Integer.toString(i + 1));
            label.setHorizontalAlignment(JLabel.CENTER);
            lignes2.add(label);
        }

        // Ajout a la vue 2
        this.panelMerOrdi = new JPanel(new BorderLayout());
        this.panelMerOrdi.add(colonnes2, BorderLayout.NORTH);
        this.panelMerOrdi.add(lignes2, BorderLayout.WEST);
        this.panelMerOrdi.add(this.merOrdi, BorderLayout.CENTER);
        panelMerOrdi.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));

        this.contourAvecNom(this.panelMerJoueur, "joueur - vous jouez ici");
        this.contourAvecNom(this.panelMerOrdi, "ordinateur");
        
        this.lesDeuxMers.add(this.panelMerJoueur);
        this.lesDeuxMers.add(this.panelMerOrdi);
        this.add(this.lesDeuxMers);
    }

    private JPanel contourAvecNom(JPanel panel, String nom) {
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
                nom.toUpperCase(),
                TitledBorder.LEFT,
                TitledBorder.TOP,
                new Font("Arial", Font.BOLD, 15),
                Color.BLUE));

        return panel;
    }

    public void paintComponent(Graphics g) {
        this.merJoueur.repaint();
        this.merOrdi.repaint();
    }

    @Override
    public void modeleMisAJour(ModelEcoutable source) {
        if (source == bataille) {
            repaint();
        }
    }

}
