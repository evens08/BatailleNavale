package modele.elements;

class CoordonneesBatailleTest {
    public static void main(String[] args) {
        boolean ok=true;
        ok=ok && testIntToChar();
        ok =ok && testToString();
        if(ok){
            System.out.println("Tests réussis !");
        }else{
            System.out.println("Tests échoués !");
        }
    }

    public static boolean testIntToChar() {
        boolean ok = true;
        CoordonneesBataille coordonneesBataille=new CoordonneesBataille(0,0);
        char resultat= coordonneesBataille.intToCharColonne();
        if(resultat!='A') ok = false;
        coordonneesBataille = new CoordonneesBataille(9,9);
        resultat=coordonneesBataille.intToCharColonne();
        if(resultat!='J') ok = false;
        if(ok) System.out.println("Test intToChar réussi  !");
        else System.out.println("Test inToChar échoué !");
        return ok;



    }
    public static boolean testToString(){
        boolean ok = true;
        CoordonneesBataille coordonneesBataille=new CoordonneesBataille(0,0);
        String resultat=coordonneesBataille.toString();
        //System.out.println(resultat);
        if(!resultat.equals("1A")) ok = false;
        coordonneesBataille=new CoordonneesBataille(9,9);
        resultat=coordonneesBataille.toString();
        System.out.println(resultat);
        if(!resultat.equals("10J")) ok = false;
        if(ok) System.out.println("Test toString réussi  !");
        else System.out.println("Test toString échoué !");
        return ok;


    }

}
