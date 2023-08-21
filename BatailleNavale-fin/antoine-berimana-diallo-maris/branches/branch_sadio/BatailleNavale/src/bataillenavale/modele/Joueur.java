/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bataillenavale.modele;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author diallo2210
 * 
 */
public interface Joueur {
    
    
	 public CoordonneesBataille choisirCoup(BatailleNavale batailleNavale);
	    
    
    public String chargerNomJoueur();
     
    
    /**
     * Renvoie la mer du joueur
     * 
     * @return mer
     */
        
}