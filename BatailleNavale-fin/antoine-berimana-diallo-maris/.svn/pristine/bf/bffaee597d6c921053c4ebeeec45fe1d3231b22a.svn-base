/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;


import modele.joueur.JoueurOrdinateur;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author ANTOINE
 */
public class ChargerNomGraphique extends JPanel {

    private String joueurString;
    private String joueurAdverseString;
    private String submitString;
    private String resetString;

    private JLabel labelJoueur;
    private JLabel labelAdverse;

    private JTextField txtJoueur;
    private JTextField txtAdverse;

    private static final int WIDTH_JTEXTFIELD = 310;
    private static final int HEIGHT_JTEXTFIELD = 30;

    private JButton btnSubmit;
    private JButton btnReset;
    
    private JoueurOrdinateur joueurOrdi;

    public ChargerNomGraphique() {
        this("Joueur 1 : ", "Joueur 2 :", "Lancer une partie", "Reinitialier");
    }

    public ChargerNomGraphique(String joueurString, String joueurAdverseString, String submitString, String resetString) {
        this.joueurString = joueurString;
        this.joueurAdverseString = joueurAdverseString;
        this.submitString = submitString;
        this.resetString = resetString;
        
        this.joueurOrdi = new JoueurOrdinateur();

        this.labelJoueur = new JLabel(this.joueurString);
        this.labelAdverse = new JLabel(this.joueurAdverseString);

        this.txtJoueur = new JTextField();
        this.txtJoueur.setPreferredSize(new Dimension(WIDTH_JTEXTFIELD, HEIGHT_JTEXTFIELD));
        this.txtAdverse = new JTextField();
        this.txtAdverse.setPreferredSize(new Dimension(WIDTH_JTEXTFIELD, HEIGHT_JTEXTFIELD));
        this.txtAdverse.setText(joueurOrdi.getNomDuJoueur());
        this.txtAdverse.setEditable(false);

        this.btnSubmit = new JButton(this.submitString);
        this.btnReset = new JButton(this.resetString);
        
        this.setLayout(new GridLayout(3, 1));

        JPanel pan1 = new JPanel();
        pan1.add(new JLabel(this.joueurString));
        pan1.add(this.txtJoueur);
        this.add(pan1);

        JPanel pan2 = new JPanel();
        pan2.add(new JLabel(this.joueurAdverseString));
        pan2.add(this.txtAdverse);
        this.add(pan2);

        JPanel pan3 = new JPanel();
        pan3.add(btnSubmit);
        pan3.add(btnReset);
        this.add(pan3);

        this.setVisible(true);
    }

    public JTextField getTxtJoueur() {
        return txtJoueur;
    }

    public void setTxtJoueur(JTextField txtJoueur) {
        this.txtJoueur = txtJoueur;
    }

    public JTextField getTxtAdverse() {
        return txtAdverse;
    }

    public void setTxtAdverse(JTextField txtAdverse) {
        this.txtAdverse = txtAdverse;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(JButton btnSubmit) {
        this.btnSubmit = btnSubmit;
    }

    public JButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(JButton btnReset) {
        this.btnReset = btnReset;
    }

}
