package modele.elements;

import java.util.ArrayList;

class MerTest {
    public static void main(String[] args) {
        boolean ok = true;
        ok = ok && testInitBateau() ;
        ok &= testTestPosition();
        ok &=testPlacerBateauGrille();
        ok &= testConstructionFlotte();
        ok &= testActualisationBateauCoulee();
        if (ok) {
            System.out.println("Tests réussis !");
        } else {
            System.out.println("Tests échoués !");
        }
    }

    public static boolean testInitBateau(){
        boolean ok =true;
        Mer mer = new Mer();
        Bateau res= mer.initBateau(2);
        if(res.isHorizontal()==true){
            if(res.getTaille()!=2|| !(res.getLigne()>=0 && res.getColonne()>=0) || !(res.getLigne()<=9 && res.getColonne()<=8) ) ok=false;
        } else {
            if(res.getTaille()!=2|| !(res.getLigne()>=0 && res.getColonne()>=0) || !(res.getLigne()<=8 && res.getColonne()<=9) ) ok=false;
        }
        res=mer.initBateau(5);
        if(res.isHorizontal()==true){
            if(res.getTaille()!=5|| !(res.getLigne()>=0 && res.getColonne()>=0) || !(res.getLigne()<=9 && res.getColonne()<=5) ) ok=false;
        } else {
            if(res.getTaille()!=5|| !(res.getLigne()>=0 && res.getColonne()>=0) || !(res.getLigne()<=5 && res.getColonne()<=9) ) ok=false;
        }
        if(ok) System.out.println("Test initBateau réussi  !");
        else System.out.println("Test initBateau échoué !");
        return ok;
    }

    public static boolean testTestPosition() {
        boolean ok = true;
        Mer mer = new Mer();
        PieceBateau[][] merAbusee = new PieceBateau[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                merAbusee[i][j] = new PieceBateau(i, j);
            }
        }
        mer.setGrille(merAbusee);
        boolean res = mer.testPosition(new Bateau(3, 7, 2, true));
        if (res) ok = false;
        mer.setGrille(new PieceBateau[10][10]);
        res=mer.testPosition(new Bateau(4, 5, 8, false));
        if(!res) ok = false;
        if (ok) System.out.println("Test testPosition réussi  !");
        else System.out.println("Test testPosition échoué !");
        return ok;
    }

    public static boolean testPlacerBateauGrille(){
        boolean ok=true;
        Mer mer = new Mer();
        Bateau bateau =new Bateau(2,5,5,true);
        Bateau res=mer.placerBateauGrille(bateau);
        if(!res.equals(bateau)) ok = false;
        if(!mer.getGrille()[5][5].equals(bateau.getQuiConstitueBateau().get(0)) && (!mer.getGrille()[5][6].equals(bateau.getQuiConstitueBateau().get(0)))){
            ok = false;
        }
        bateau =new Bateau(2,5,5,false);
        res=mer.placerBateauGrille(bateau);
        if(!res.equals(bateau)) ok = false;
        if(!mer.getGrille()[5][5].equals(bateau.getQuiConstitueBateau().get(0)) && (!mer.getGrille()[6][5].equals(bateau.getQuiConstitueBateau().get(0)))){
            ok = false;
        }
        if (ok) System.out.println("Test placerBateauGrille réussi  !");
        else System.out.println("Test placerBateauGrille échoué !");
        return ok;
    }
    public static boolean testConstructionFlotte(){
        boolean ok =true;
        Mer mer = new Mer();
        mer.setGrille(new PieceBateau[10][10]);
        mer.setFlotte(new ArrayList<Bateau>());
        ArrayList<Bateau> res = mer.consructionFlotte();
        int[] taillesBateaux ={5,4,3,3,2};
        for(int i=0;i<5;i++){
            if(res.get(i).getTaille()!=taillesBateaux[i]) ok = false;
        }
        if (ok) System.out.println("Test constructionFlotte réussi  !");
        else System.out.println("Test constructionFlotte échoué !");
        return ok;
    }

    public static boolean testActualisationBateauCoulee() {
        boolean ok = true;
        Mer mer = new Mer();
        for(Bateau bateau :mer.getFlotte()){
            for(PieceBateau piece : bateau.getQuiConstitueBateau()){
                piece.changerEtat();
            }
        }
        mer.actualisationBateauCoulee();
        for (Bateau bateau: mer.getFlotte()){
            if(bateau.isCoulee()==false) ok = false;
        }
        if (ok) System.out.println("Test actualisationBateauCoulee réussi  !");
        else System.out.println("Test actualisationBateauCoulee échoué !");

        return ok;
    }

}
