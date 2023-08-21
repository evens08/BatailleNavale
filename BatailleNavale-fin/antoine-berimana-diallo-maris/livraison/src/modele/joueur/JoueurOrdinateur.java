/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele.joueur;

import modele.elements.BatailleNavale;
import modele.elements.CoordonneesBataille;

import java.util.Random;

/**
 * Classe représentant un joueur aléatoire/ordinateur
 * @author diallo2210
 */
public class JoueurOrdinateur implements Joueur {

	private String nomDuJoueur;
	 public JoueurOrdinateur() {
		this.nomDuJoueur="Ordinateur";
	}

	/**
	 * Choisi un coup au hasard
	 * @param partie Une instance de BatailleNavale
	 * @return Un coup au hasard
	 */
	@Override
	public CoordonneesBataille choisirCoup(BatailleNavale partie) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		CoordonneesBataille coup=partie.validMoves().get(rand.nextInt(partie.validMoves().size()));
		System.out.println(coup);
		return coup;
	}


	@Override
	public String toString() {
		return this.nomDuJoueur;
	}

	/**
	 *	Renvoie le nom du joueur Ordinateur
	 * @return Le nom du joueur ordinateur
	 */
	public String getNomDuJoueur() {
		return nomDuJoueur;
	}
}
