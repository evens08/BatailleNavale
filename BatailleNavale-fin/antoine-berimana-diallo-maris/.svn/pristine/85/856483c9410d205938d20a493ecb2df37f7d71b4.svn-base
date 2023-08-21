
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bataillenavale.modele;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author diallo2210
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Pattern;
/**
 *
 * @author diallo2210
 */
public class JoueurHumain implements Joueur  {
    private String nomDuJoueur;
        public JoueurHumain() {
                chargerNomJoueur();
        }
        public String chargerNomJoueur() {
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
                return this.nomDuJoueur = nom;
        }
        
        
        @Override
        public CoordonneesBataille choisirCoup(BatailleNavale partie) {
                Scanner scanner=new Scanner(System.in);
                String coupLigneStr,coupColonneStr;
                CoordonneesBataille coup;
                do{
                        do {
                                System.out.println("Entrer une Ligne (1 à 10)");
                                coupLigneStr = scanner.next();
                        } while(!this.queChiffre(coupLigneStr));
                        int coupLigneInt =Integer.parseInt(coupLigneStr)-1;
                        
                        System.out.println("Entrer une Colonne (A à J)");
                        coupColonneStr=scanner.next().toUpperCase();
                        char coupColonneChar=coupColonneStr.charAt(0);
                        int valeurColonne=coupColonneChar -65;
                        coup = new CoordonneesBataille(coupLigneInt,valeurColonne);
                        if (!partie.isValid(coup)){
                                System.out.println("Coup invalide recommencez!");
                        }
                }while(partie.isValid(coup)==false);
                System.out.println(coup);
                return coup;
        }
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
        public String getNomDuJoueur() {
                return nomDuJoueur;
        }
        @Override
        public String toString() {
                return this.getNomDuJoueur();
        }
}
