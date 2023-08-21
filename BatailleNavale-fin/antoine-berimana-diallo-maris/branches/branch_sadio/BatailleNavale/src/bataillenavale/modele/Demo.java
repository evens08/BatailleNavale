/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bataillenavale.modele;

import java.util.Random;
import java.util.Scanner;


/**
 *
 * @author diallo2210
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    	boolean finish = false;
    	do {
    		System.out.println("╔══════════════════════════════════════════════════════════════════════════════╗");
            System.out.println("║                      Bienvenue sur la bataille navale.                       ║");
            System.out.println("║        Ici vous n'avez la possibilité de jouer qu'avec l'ordinateur.         ║");
            System.out.println("║       Vous avez votre grille avec vos navires à la première position         ║");
            System.out.println("╚══════════════════════════════════════════════════════════════════════════════╝");
    		Mer mer = new Mer();
    		//System.out.println(mer);
    		mer.getFlotte().get(4).getQuiConstitueBateau().get(0).setEtatCourant(2);
    		System.out.println("");
    		JoueurHumain gamer = new JoueurHumain();
    		BatailleNavale bataille = new BatailleNavale(gamer);
    		
            DeroulerBataille1 jouer = new DeroulerBataille1(bataille);
            jouer.play();
            
    		mer.getFlotte().get(4).getQuiConstitueBateau().get(1).setEtatCourant(2);
    		System.out.println(mer);
    		if (bataille.isOver()==true) { finish = true;}
    		
    		boolean sortir = false;
        	do {
        		System.out.println("Souhaitez-vous reprendre la partie ????");
        		Scanner cl = new Scanner(System.in);
        		String rep = cl.nextLine();
        		if (rep=="n") { sortir = true;}else if (rep=="y") {sortir = false;} else System.out.println("Faites un y/n");
        		cl.close();
        	}while(sortir==true);
        	
        	
    		
    	}while(finish=true);
    	
    	
                
                   
               
               
    }
    
   
}
