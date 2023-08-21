package modele.joueur;

import modele.elements.BatailleNavale;
import modele.elements.CoordonneesBataille;

import java.util.Scanner;

class JoueurHumainTest {
    public static void main(String[] args) {
        boolean ok = true;
        ok = ok && testChoisirCoup();
        if (ok) {
            System.out.println("Tests réussis !");
        } else {
            System.out.println("Tests échoués !");
        }
    }
    public static boolean testChoisirCoup(){
        boolean ok =true;
        String entree="2\nC\n";
        entree+="3\nL\n3\nD\n";
        entree+="20\n99\n8\nA\n";
        Scanner scanTest=new Scanner(entree);
        JoueurHumain joueurHumain=new JoueurHumain(scanTest);
        BatailleNavale batailleNavale = new BatailleNavale();
        CoordonneesBataille res = joueurHumain.choisirCoup(batailleNavale);
        if(!res.equals(new CoordonneesBataille(1,2))) ok =false;

        res=joueurHumain.choisirCoup(batailleNavale);
        if(!res.equals(new CoordonneesBataille(2,3))) ok =false;

        res=joueurHumain.choisirCoup(batailleNavale);
        if(!res.equals(new CoordonneesBataille(7,0))) ok =false;


        if(ok) System.out.println("Test choisirCoup() réussi  !");
        else System.out.println("Test choisirCoup() échoué !");
        return ok;

    }
}
