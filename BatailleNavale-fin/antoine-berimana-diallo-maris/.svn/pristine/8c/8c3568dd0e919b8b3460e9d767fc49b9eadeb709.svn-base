/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bataillenavale;

import java.util.Random;

/**
 *
 * @author diallo2210
 */
public class BatailleNavale_Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        	Random rand=new Random();
		int test=0;
		test = rand.nextInt(11);
		int[] testTab=new int[11];
		for (int i=0;i<11;i++) {
			test = rand.nextInt(11);
			testTab[i]=test;
		}
		for (int i=0;i<11;i++) {
			System.out.println(testTab[i]);
		}
		Mer mer = new Mer();
		System.out.println(mer);
		mer.getFlotte().get(4).getQuiConstitueBateau().get(0).setEtatCourant(2);
		mer.getFlotte().get(4).getQuiConstitueBateau().get(1).setEtatCourant(2);
		System.out.println(mer);
                JoueurHumain gamer = new JoueurHumain();
                    gamer.chargerNomJoueur();
                JoueurOrdinateur ordi = new JoueurOrdinateur();
               System.out.println(ordi.nomDuJoueur);
    }
    
   
}
