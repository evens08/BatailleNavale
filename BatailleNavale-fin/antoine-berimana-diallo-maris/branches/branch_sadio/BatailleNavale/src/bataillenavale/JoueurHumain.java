/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bataillenavale;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;



/**
 *
 * @author diallo2210
 */
public class JoueurHumain extends Joueur  {
    
	public JoueurHumain() {
		chargerNomJoueur();
	}

	@Override
	protected void chargerNomJoueur() {
		// TODO Auto-generated method stub
		String nom = "";
		boolean erreur = true;
		do { 
			
			System.out.println("Comment souhaitez-vous que l'on vous appelle?");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			try {
				
				nom = reader.readLine();
			} catch (java.io.IOException  e) {
				// TODO: handle exception
				System.out.println("une erreur est surevenue : " + e);
			}
			
			if(Pattern.matches("[A-Za-z-éèï]+", nom) && nom.length() >= 3 && (nom.length() <= 12)) {
				erreur = false;
			}
			
		
		} while (erreur);
		this.nomDuJoueur = nom;
	}
	
	
	@Override
	protected void jouerCoup(Joueur enemy) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void placerBateaux() {
		// TODO Auto-generated method stub
		
	}
}