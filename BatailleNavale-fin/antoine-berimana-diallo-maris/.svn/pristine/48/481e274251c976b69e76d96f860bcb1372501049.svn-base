package modele.elements;

class PieceBateauTest {
    public static void main(String[] args) {
        boolean ok=true;
        ok &= testEtatBateau();
        ok &=testChangerEtat();
        if(ok) System.out.println("Tests réussis !");
        else System.out.println("Tests échoués !");
    }

    public static boolean testEtatBateau() {

        boolean ok = true;
        PieceBateau piece = new PieceBateau(0,0);
        int resultat=piece.getEtatCourant();
        if(!(resultat>=0 && resultat<=3 )) ok =false;
        if(resultat!=0) ok=false;

        piece = new PieceBateau(22,10,3);
        resultat= piece.getEtatCourant();
        if(resultat!=3) ok=false;

        if(ok) System.out.println("Test etatBateau réussi  !");
        else System.out.println("Test etatBateau échoué !");
        return ok;
    }

    public static boolean testChangerEtat(){
        boolean ok=true;

        PieceBateau piece=new PieceBateau(1,2);
        piece.changerEtat();
        int resultat=piece.getEtatCourant();
        if(resultat!=1) {ok = false;}

        piece=new PieceBateau(2,4,2);
        piece.changerEtat();
        resultat=piece.getEtatCourant();
        if(resultat!=2) {ok = false;}

        if(ok) System.out.println("Test changerEtat réussi  !");
        else System.out.println("Test changerEtat échoué !");
        return ok;
    }


}
