/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vue;

import modele.elements.BatailleNavale;

/**
 *
 * @author antoine222
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args) {

        BatailleNavale bataille = new BatailleNavale();
        
        new BatailleGUI(bataille);
//        new BatailleGUI2(bataille);
    }

}
