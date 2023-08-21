/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bataillenavale;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author ANTOINE
 */
public class BatailleGUI extends JFrame {

    private VueBataille vueBataille;

    public BatailleGUI() {
        super("Bataille Navale".toUpperCase());
        this.vueBataille = new VueBataille();
        this.getContentPane().add(this.vueBataille);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    
}
