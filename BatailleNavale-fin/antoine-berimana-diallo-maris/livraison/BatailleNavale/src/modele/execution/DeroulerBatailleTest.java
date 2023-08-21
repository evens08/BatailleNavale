package modele.execution;

import modele.elements.BatailleNavale;
import modele.elements.CoordonneesBataille;
import modele.joueur.JoueurHumain;

import java.util.Scanner;

class DeroulerBatailleTest {
    public static void main(String[] args) {
        boolean ok = true;
        ok = ok && testPlay();
        if (ok) {
            System.out.println("Tests réussis !");
        } else {
            System.out.println("Tests échoués !");
        }
    }
    public static boolean testPlay(){
        boolean ok =true;
        BatailleNavale batailleNavale =new BatailleNavale();
        String entree="";
        for(int i=1;i<11;i++){
            for(char j='A';j<'K';j++){
                entree+=i+"\n"+j+"\n";
            }
        }
        Scanner scanTest=new Scanner(entree);
        DeroulerBataille deroulerBataille=new DeroulerBataille(batailleNavale);
        deroulerBataille.getPartie().getJoueur().setScanner(scanTest);
        deroulerBataille.play();
        boolean res = deroulerBataille.getPartie().isOver();
        if(!res) ok = false;
        System.out.println(deroulerBataille.getPartie().getWinner());
        if(ok) System.out.println("Test deroulerBataille() réussi  !");
        else System.out.println("Test deroulerBataille() échoué !");
        return ok;

    }
}
