/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modele.joueur;

import modele.elements.BatailleNavale;
import modele.elements.CoordonneesBataille;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;



/**
 * Classe représentant un joueur utilisateur
 * @author diallo2210
 */
public class JoueurHumain implements Joueur {
    private String nomDuJoueur;
	private Scanner scanner;

	/**
	 * Créer un joueur et actionne la demande de saisie de son nom à l'utilisateur
	 */
	public JoueurHumain() {
		this.scanner=new Scanner(System.in);
		chargerNomJoueur();
	}

	/**
	 * Créer un joueur qui a pour nom "Joueur". Cette classe est utile qu'aux tests.
	 * @param scanner une instance de Scanner
	 */
	public JoueurHumain(Scanner scanner){
		this.nomDuJoueur="Joueur";
		this.scanner=scanner;
	}


	/**
	 * Instancie un joueur sans passer par le Scanner
	 * @param nom Le nom du joueur
	 */
	public JoueurHumain(String nom){
		this.nomDuJoueur=nom;
		this.scanner=new Scanner(System.in);
	}

	/**
	 * Modifie le scanner (pour le test toujours)
	 * @param scanner une instance de Scanner
	 */
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}

	/**
	 * Demande à l'utilisateur de saisir un nom de joueur
	 */
	public void chargerNomJoueur() {
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
			
			if(Pattern.matches("[A-Za-z-éèï]+", nom) && nom.length() >= 1 && (nom.length() <= 20)) {
				erreur = false;
			}
			
		
		} while (erreur);
		this.nomDuJoueur = nom;
	}

	/**
	 * Renvoie un coup choisi par l'utilisateur en lui demandant de saisir au fur et à mesure ligne et colonne. Tant qu'il n'a pas bien saisie, cela redemande la saisie.
	 * @param partie une instance de BatailleNavale
	 * @return Le coup correspondant à la saisie de l'utilisateur
	 */
	@Override
	public CoordonneesBataille choisirCoup(BatailleNavale partie) {
		String coupLigneStr,coupColonneStr;
		CoordonneesBataille coup;
		int i=0;
		do{
			if(i!=0){
				System.out.println("Coup incorrect, recommencez!" );
			}
			do {
				System.out.println("Entrer une Ligne");
				coupLigneStr = scanner.nextLine();
			} while(!this.queChiffre(coupLigneStr));
			int coupLigneInt =Integer.parseInt(coupLigneStr)-1;
			System.out.println("Entrer une Colonne");
			coupColonneStr=scanner.nextLine().toUpperCase();
			char coupColonneChar=coupColonneStr.charAt(0);
			int valeurColonne=coupColonneChar -65;
			coup = new CoordonneesBataille(coupLigneInt,valeurColonne);
			i++;

		}while(!partie.isValid(coup));
		System.out.println(coup);

		return coup;
	}


	/**
	 * Détermine si un champ est fait que de chiffres
	 * @param champ Texte à étudier
	 * @return true si le texte en entrée n'est composé que de chiffres
	 */
	private boolean queChiffre(String champ){
		for(int i = 0; i < champ.length(); i++){
			if(champ.charAt(i) != '0' && champ.charAt(i) != '1' && champ.charAt(i) != '2' &&
					champ.charAt(i) != '3' && champ.charAt(i) != '4' && champ.charAt(i) != '5' &&
					champ.charAt(i) != '6' && champ.charAt(i) != '7' && champ.charAt(i) != '8' && champ.charAt(i) != '9'){
				System.out.println("Saisir un nombre entre 1 et 10");
				return false;
			}

		}
		return true;
	}

	/**
	 * Renvoie le nom du joueur
	 * @return Le nom du joueur
	 */
	public String getNomDuJoueur() {
		return nomDuJoueur;
	}


	@Override
	public String toString() {
		return this.getNomDuJoueur();
	}
}