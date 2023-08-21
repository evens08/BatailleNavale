/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bataillenavale;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author diallo2210
 */
public interface Joueur {
   
    public void jouerCoup(BatailleNavale batailleNavale);
    
    protected abstract void chargerNomJoueur();
    

    
    
    /**
     * Renvoie la mer du joueur
     * 
     * @return mer
     */
    protected Mer getMer() {
		return this.mer;
    }

	/**
     * Renvoie le nom du joueur
     * 
     * @return String
     */
	protected String getNomDuJoueur() {
		return this.nomDuJoueur;
	}
	
	 /**
     * 
	 * Compte le nombre de coups tirés par le joueur
	 * 
	 * @return void
     */
	protected void getNbTotalDetir() {
		 nbTotalDetir++;
	}
	
	/**
	 * 
	 * Augmente le nombre de coups réussis tirés par le joueur
	 * 
	 * @return void
	 */
	protected void getNbTirReussi() {
		 nbTirReussi++;
	}
	
	/**
	 * 
	 * Augmente le nombre de navires coulés par le joueur	
	 *  
	 * @return void
	 */
	protected void getNbBateauxCoules() {
		 nbBateauxCoules++;
	}
    
  
    
    
    
}
