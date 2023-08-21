package modele.elements;

import java.util.ArrayList;

class BateauTest {
    public static void main(String[] args) {
        boolean ok = true;
        ok = ok && testCreationPieces();
        ok &= testChangerEtatPieceCoulee();
        ok &= testDoitCouler();
        if (ok) {
            System.out.println("Tests réussis !");
        } else {
            System.out.println("Tests échoués !");
        }
    }

    public static boolean testCreationPieces() {
        boolean ok = true;
        Bateau bateau=new Bateau(2,1,5,true);
        ArrayList<PieceBateau> res =bateau.creationPieces();
        if(res.size()!=2) ok= false;
        for (int i=0;i<2;i++) {
            if(res.get(i).getLigne()!=1 || res.get(i).getColonne()!=5+i) ok =false;
        }
        bateau=new Bateau(5,4,6,false);
        res=bateau.creationPieces();
        if(res.size()!=5) ok= false;
        for (int i=0;i<5;i++) {
            if(res.get(i).getLigne()!=4+i || res.get(i).getColonne()!=6) ok =false;
        }
        if(ok) System.out.println("Test creationPieces réussi  !");
        else System.out.println("Test creationPieces échoué !");
        return ok;
    }
    public static boolean testChangerEtatPieceCoulee() {
        boolean ok = true;
        Bateau bateau=new Bateau(2,2,2,false);
        bateau.changerEtatPiecesCoulee();
        ArrayList<PieceBateau> res=bateau.getQuiConstitueBateau();
        for (PieceBateau piece :res){
            if(piece.getEtatCourant()!=2) ok = false;
        }
        bateau = new Bateau(5,10, 3,true);
        bateau.changerEtatPiecesCoulee();
        res=bateau.getQuiConstitueBateau();
        for (PieceBateau piece :res){
            if(piece.getEtatCourant()!=2) ok = false;
        }
        if(ok) System.out.println("Test changerEtatPieces réussi  !");
        else System.out.println("Test changerEtatPieces échoué !");
        return ok;
    }

    public static boolean testDoitCouler() {
        boolean ok = true;
        Bateau bateau=new Bateau(2,2,2,false);
        boolean res = bateau.doitCouler();
        if(res==true) ok = false;
        for(PieceBateau piece: bateau.getQuiConstitueBateau()){
            piece.changerEtat();
        }
        res=bateau.doitCouler();
        if(res==false) ok = false;
        if(ok) System.out.println("Test doitCouler réussi  !");
        else System.out.println("Test doitCouler échoué !");
        return ok;
    }


}
