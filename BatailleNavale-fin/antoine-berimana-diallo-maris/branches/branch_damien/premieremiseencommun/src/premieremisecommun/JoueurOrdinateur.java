/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bataillenavale;

/**
 *
 * @author diallo2210
 */
public class JoueurOrdinateur extends Joueur{
	
	
	 public JoueurOrdinateur() {
		// TODO Auto-generated constructor stub
		chargerNomJoueur();
	}
	
	@Override
	protected void jouerCoup(Joueur enemy) {
		// TODO Auto-generated method stub
		System.out.println(nomDuJoueur + "est en train de jouer");
		
		PieceBateau celluleCible;
		boolean erreur = true;
		while(erreur) {
			celluleCible = new PieceBateau(-1,-1);
		}
	}

	@Override
	protected void chargerNomJoueur() {
		// TODO Auto-generated method stub
		nomDuJoueur = "Ordinateur";
		
	}

	@Override
	protected void placerBateaux() {
		// TODO Auto-generated method stub
		
	}
	
    
}
