package bataillenavale.modele;
import java.util.ArrayList;
import java.util.Random;
public class Mer {
        
        private PieceBateau[][] grille;
        private ArrayList<Bateau> flotte;
        private Random rand;
        
        public Mer() {
                this.grille = new PieceBateau[10][10]; 
                this.rand = new Random();
                // Créer 5 bateaux : 2 bateaux de 3p , 1 de 5p, 1 de 4p et un de 2p
                this.setFlotte(this.consructionFlotte());        
                
        }
        public Bateau initBateau(int taille) {
                boolean horizontal = rand.nextBoolean();
                Bateau bateau;
                if (horizontal==true) {
                        bateau = new Bateau(taille,rand.nextInt(10),rand.nextInt(10-taille+1),horizontal);
                } else {
                        bateau = new Bateau(taille,rand.nextInt(10-taille+1),rand.nextInt(10),horizontal);//Aléatoire de la position de départ du bateau et de sa direction
                }
                return bateau;
        }
        public boolean testPosition(Bateau bateau) {
                boolean booleen=false;
                if(bateau.isHorizontal()!=false) {
                        for (int c=0;c<bateau.getTaille();c++) {
                                if(grille[bateau.getLigne()][bateau.getColonne()+c]!=null) {
                                        return booleen;
                                }
                        }
                } else {
                        for (int l=0;l<bateau.getTaille();l++) {
                                if(grille[bateau.getLigne()+l][bateau.getColonne()]!=null) {
                                        return booleen;
                                }
                        }
                }
                return !booleen;
        }
        
        public void placerBateauGrille(Bateau bateau) {
                if (this.testPosition(bateau)) {
                        if(bateau.isHorizontal()!=false) {
                                for (int c=0;c<bateau.getTaille();c++) {
                                        grille[bateau.getLigne()][bateau.getColonne()+c]=bateau.getQuiConstitueBateau().get(c);
                                }
                        } else {
                                for (int l=0;l<bateau.getTaille();l++) {
                                        grille[bateau.getLigne()+l][bateau.getColonne()]=bateau.getQuiConstitueBateau().get(l);
                                }
                        }
                } else {
                        bateau = initBateau(bateau.getTaille());
                        this.placerBateauGrille(bateau);
                }
        }
        public ArrayList<Bateau> consructionFlotte() {
                Bateau bateau_cinq=this.initBateau(5);
                this.placerBateauGrille(bateau_cinq);
                Bateau bateau_quatre =this.initBateau(4);
                this.placerBateauGrille(bateau_quatre);
                Bateau bateau_trois_1 =this.initBateau(3);
                this.placerBateauGrille(bateau_trois_1);
                Bateau bateau_trois_2 =this.initBateau(3);
                this.placerBateauGrille(bateau_trois_2);
                Bateau bateau_deux =this.initBateau(2);
                this.placerBateauGrille(bateau_deux);
                ArrayList<Bateau> flotte = new ArrayList<Bateau>();
                flotte.add(bateau_cinq);
                flotte.add(bateau_quatre);
                flotte.add(bateau_trois_1);
                flotte.add(bateau_trois_2);
                flotte.add(bateau_deux);
                return flotte;
        }
        public ArrayList<Bateau> getFlotte() {
                return flotte;
        }
        public void setFlotte(ArrayList<Bateau> flotte) {
                this.flotte = flotte;
        }
        @Override
        public String toString() {
                String representation = "   ABCDEFGHIJ\n  ____________\n";
                for(int l=0;l<10;l++) {
                        if(l<9){
                                representation+=(l+1)+" |";
                        } else{
                                representation+=""+(l+1)+"|";
                        }
                        for(int c=0;c<10;c++) {
                                if (grille[l][c] == null) {
                                        representation += " ";
                                } else if (grille[l][c].getEtatCourant() == 0) {//intacte
                                        representation += "o";
                                } else if (grille[l][c].getEtatCourant() == 1) {//touchee
                                        representation += "x";
                                } else if (grille[l][c].getEtatCourant() == 2) {
                                        representation+="!";
                                } else {
                                        representation+="#";
                                }
                        }
                        representation+="|\n";
                }
                return representation+"  ‾‾‾‾‾‾‾‾‾‾‾‾\n   ABCDEFGHIJ";
        }
        public PieceBateau[][] getGrille() {
                return grille;
        }
        public String toStringHide(){
                String representation=this.toString();
                String representationCachee=representation.replaceAll("o"," ");
                return representationCachee;
        }
        public void actualisationBateauCoulee(){
                for(Bateau bateau : this.flotte){
                        if(bateau.doitCouler()){
                                bateau.changerEtatPiecesCoulee();
                        }
                }
        }
        
}