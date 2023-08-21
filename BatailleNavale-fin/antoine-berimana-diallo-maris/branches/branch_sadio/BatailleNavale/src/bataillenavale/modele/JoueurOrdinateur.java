/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bataillenavale.modele;
import java.util.Random;
/**
 *
 * @author diallo2210
 */

import java.util.Random;
/**
 *
 * @author diallo2210
 */
public class JoueurOrdinateur implements Joueur{
        private String nomDuJoueur;
         public JoueurOrdinateur() {
                this.nomDuJoueur="Ordinateur";
        }
        
        @Override
        public CoordonneesBataille choisirCoup(BatailleNavale partie) {
                // TODO Auto-generated method stub
                Random rand = new Random();
                CoordonneesBataille coup;
                do{
                        coup = new CoordonneesBataille(rand.nextInt(10),rand.nextInt(10));
                }while(!partie.isValid(coup));
                System.out.println(coup);
                return coup;
        }
        @Override
        public String toString() {
                return this.nomDuJoueur;
        }

		@Override
		public String chargerNomJoueur() {
			// TODO Auto-generated method stub
			return "Vous allez jouer contre l'ordinateur";
		}
}