package modele.elements;

import modele.joueur.Joueur;

import java.util.ArrayList;

class BatailleNavaleTest {
    public static void main(String[] args) {
        boolean ok = true;
        ok = ok && testIsValid();
        ok &=testIsOver();
        ok&=testJouerCoup();
        ok &= testGetWinner();
        ok &= testValidMoves();
        if (ok) {
            System.out.println("Tests réussis !");
        } else {
            System.out.println("Tests échoués !");
        }
    }
    public static boolean testIsValid(){
        boolean ok =true;
        BatailleNavale batailleNavale = new BatailleNavale();
        boolean res=batailleNavale.isValid(new CoordonneesBataille(30,20));
        if (res) ok = false;

        batailleNavale.getMerJoueurCourant().setGrille(new PieceBateau[10][10]);
        res=batailleNavale.isValid(new CoordonneesBataille(1,4));
        if (res==false) ok = false;

        PieceBateau[][] merAbusee = new PieceBateau[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                merAbusee[i][j] = new PieceBateau(i, j);
            }
        }
        batailleNavale.getMerJoueurCourant().setGrille(merAbusee);
        res =batailleNavale.isValid(new CoordonneesBataille(3,6));
        if(!res) ok = false;

        batailleNavale.getMerJoueurCourant().setGrille(merAbusee);
        batailleNavale.getMerJoueurCourant().getGrille()[2][1]=new PieceBateau(2,1,1);
        res =batailleNavale.isValid(new CoordonneesBataille(2,1));
        if(res) ok = false;

        batailleNavale.getMerJoueurCourant().getGrille()[2][1]=new PieceBateau(2,1,3);
        res =batailleNavale.isValid(new CoordonneesBataille(2,1));
        if(res) ok =false;


        if (ok) System.out.println("Test isValid() réussi  !");
        else System.out.println("Test isValid() échoué !");
        return ok;

    }
    public static boolean testIsOver(){
        boolean ok =true;
        BatailleNavale batailleNavale=new BatailleNavale();
        boolean res = batailleNavale.isOver();
        if(res) ok =false;

        for(Bateau bateau:batailleNavale.getMerJoueur().getFlotte()){
            bateau.changerEtatPiecesCoulee();
        }
        res = batailleNavale.isOver();
        if(!res) ok =false;

        batailleNavale=new BatailleNavale();
        res= batailleNavale.isOver();
        if(res) ok =false;

        for(Bateau bateau:batailleNavale.getMerOrdi().getFlotte()){
            bateau.changerEtatPiecesCoulee();
        }
        res = batailleNavale.isOver();
        if(!res) ok =false;

        if (ok) System.out.println("Test isOver() réussi  !");
        else System.out.println("Test isOver() échoué !");
        return ok;

    }
    public static boolean testJouerCoup(){
        boolean ok =true;
        BatailleNavale batailleNavale = new BatailleNavale();
        CoordonneesBataille coup=new CoordonneesBataille(1,4);
        batailleNavale.getMerJoueur().getGrille()[1][4]=new PieceBateau(1,4);
        batailleNavale.isValid(coup);
        batailleNavale.jouerCoup(coup);
        PieceBateau res =batailleNavale.getMerJoueur().getGrille()[1][4];
        if(res.getEtatCourant()!=PieceBateau.TOUCHEE) ok =false;
        if(batailleNavale.getJoueurCourant()!=batailleNavale.getAleatoire()) ok =false;
        if (ok) System.out.println("Test jouerCoup() réussi  !");
        else System.out.println("Test jouerCoup() échoué !");
        return ok;

    }
    public static boolean testGetWinner(){
        boolean ok =true;
        BatailleNavale batailleNavale=new BatailleNavale();
        Joueur res = batailleNavale.getWinner();
        if(res!=null) ok = false;
        for(Bateau bateau:batailleNavale.getMerJoueur().getFlotte()){
            bateau.changerEtatPiecesCoulee();
        }
        res = batailleNavale.getWinner();
        if(res!= batailleNavale.getJoueur()) ok =false;
        batailleNavale=new BatailleNavale();
        for(Bateau bateau:batailleNavale.getMerOrdi().getFlotte()){
            bateau.changerEtatPiecesCoulee();
        }
        res=batailleNavale.getWinner();
        if(res!= batailleNavale.getAleatoire()) ok =false;

        if (ok) System.out.println("Test getWinner() réussi  !");
        else System.out.println("Test getWinner() échoué !");
        return ok;

    }
    public static boolean testValidMoves(){
        boolean ok =true;
        BatailleNavale batailleNavale=new BatailleNavale();
        ArrayList<CoordonneesBataille> res = batailleNavale.validMoves();
        if(res.size()!=100) ok = false;
        batailleNavale.isValid(new CoordonneesBataille(4,5));
        batailleNavale.jouerCoup(new CoordonneesBataille(4,5));
        res=batailleNavale.validMoves();
        if(res.size()!=100) ok =false;
        batailleNavale.isValid(new CoordonneesBataille(4,5));
        batailleNavale.jouerCoup(new CoordonneesBataille(4,5));
        res=batailleNavale.validMoves();
        if(res.size()!=99) ok =false;
        batailleNavale.isValid(new CoordonneesBataille(3,5));
        batailleNavale.jouerCoup(new CoordonneesBataille(3,5));
        res=batailleNavale.validMoves();
        if(res.size()!=99) ok =false;
        if (ok) System.out.println("Test validMoves() réussi  !");
        else System.out.println("Test validMoves() échoué !");
        return ok;

    }


}
