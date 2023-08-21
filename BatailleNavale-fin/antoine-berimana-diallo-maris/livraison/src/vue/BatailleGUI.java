/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vue;

import java.awt.Container;
import javax.swing.JFrame;
import modele.elements.BatailleNavale;


/**
 *
 * @author ANTOINE
 */
public class BatailleGUI extends JFrame {
    
    private BatailleNavale bataille;
    private Vue vue;

    public BatailleGUI(BatailleNavale bataille) {
        super("Bataille Navale".toUpperCase());
        this.bataille=bataille;
        this.vue = new Vue(this.bataille);
        this.getContentPane().add(this.vue);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
//        this.setResizable(false);
    }
}
