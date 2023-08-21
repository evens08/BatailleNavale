package modele.joueur;

import modele.elements.BatailleNavale;
import modele.elements.CoordonneesBataille;

class JoueurOrdiTest {
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
        JoueurOrdinateur joueurOrdinateur=new JoueurOrdinateur();
        BatailleNavale batailleNavale=new BatailleNavale();
        batailleNavale.jouerCoup(new CoordonneesBataille(0,0));
        CoordonneesBataille res=joueurOrdinateur.choisirCoup(batailleNavale);
        batailleNavale.jouerCoup(res);
        if(res==null) ok = false;
        System.out.println(batailleNavale.validMoves().size());
        if(batailleNavale.validMoves().size()!=99) ok =false;
        if(ok) System.out.println("Test choisirCoup() réussi  !");
        else System.out.println("Test choisirCoup() échoué !");
        return ok;
    }
}
