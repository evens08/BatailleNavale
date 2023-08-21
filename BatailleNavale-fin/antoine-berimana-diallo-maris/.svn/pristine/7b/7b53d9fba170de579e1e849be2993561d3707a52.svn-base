package bataillenavale.modele;

public class BatailleNavale {
    private JoueurHumain joueur;
    private JoueurOrdinateur aleatoire;
    private Mer merJoueur;
    private Mer merOrdi;
    private Joueur joueurCourant;
    
    public BatailleNavale(JoueurHumain joueur) {
            this.merJoueur=new Mer();
            this.merOrdi=new Mer();
            this.joueur=joueur;
            this.aleatoire=new JoueurOrdinateur();
            this.joueurCourant=this.joueur;
    }
    public Joueur getJoueurCourant() {
            return joueurCourant;
    }
    public void setJoueurCourant(Joueur joueurCourant) {
            this.joueurCourant = joueurCourant;
    }
    public boolean isValid(CoordonneesBataille coup) {
            int ligne=coup.getLigne();
            int colonne=coup.getColonne();
            if (ligne<0 || ligne>9 || colonne<0||colonne>9) {
                    return false;
            }
            if (this.joueurCourant==this.joueur) {
                    if(merOrdi.getGrille()[ligne][colonne]==null) {
                            merOrdi.getGrille()[ligne][colonne]=new TirLoupee(ligne,colonne);
                    } else if(merOrdi.getGrille()[ligne][colonne].getEtatCourant()==1||merOrdi.getGrille()[ligne][colonne].getEtatCourant()==2) {
                            return false;
                    }
            } else {
                    if(merJoueur.getGrille()[ligne][colonne]==null) {
                            merJoueur.getGrille()[ligne][colonne] = new TirLoupee(ligne, colonne);
                    } else if(merJoueur.getGrille()[ligne][colonne].getEtatCourant()==1||merJoueur.getGrille()[ligne][colonne].getEtatCourant()==2){
                            return false;
                    }
            }
            return true;
    }
    public boolean isOverJoueur() {
            for(Bateau bateaux : merOrdi.getFlotte()) {
                    if(!bateaux.isCoulee()) {
                            return false;
                    }
            }
            return true;
    }
    public boolean isOverOrdi() {
            for(Bateau bateaux : merJoueur.getFlotte()) {
                    if(!bateaux.isCoulee()) {
                            return false;
                    }
            }
            return true;
    }
    public boolean isOver() {
            return this.isOverJoueur() || this.isOverOrdi();
    }
    
    public void jouerCoup(CoordonneesBataille coup) {
            int ligne=coup.getLigne();
            int colonne=coup.getColonne();
            if (this.joueurCourant==this.joueur) {
                    if(merOrdi.getGrille()[ligne][colonne].getEtatCourant()==0) {
                            merOrdi.getGrille()[ligne][colonne].changerEtat();
                            System.out.println("Touché");
                    } else if (merOrdi.getGrille()[ligne][colonne].getEtatCourant()==3) {
                            System.out.println("Loupé");
                    }
                    this.merOrdi.actualisationBateauCoulee();
            } else if (this.joueurCourant==this.aleatoire){
                    if(merJoueur.getGrille()[ligne][colonne].getEtatCourant()==0) {
                            merJoueur.getGrille()[ligne][colonne].changerEtat();
                            System.out.println("Touché");
                    } else if (merJoueur.getGrille()[ligne][colonne].getEtatCourant()==3) {
                            System.out.println("Loupé");
                    }
                    this.merJoueur.actualisationBateauCoulee();
            }
            if(this.joueurCourant==this.aleatoire){
                    this.joueurCourant=this.joueur;
            } else{
                    this.joueurCourant=this.aleatoire;
            }
    }
    public Joueur getWinner(){
            if(!isOver()){
                    return null;
            } else if (isOverJoueur()) {
                    return this.joueur;
            } else if (isOverOrdi()){
                    return this.aleatoire;
            } else {
                    return null;
            }
    }
    public Mer getMerJoueur() {
            return merJoueur;
    }
    public void setMerJoueur(Mer merJoueur) {
            this.merJoueur = merJoueur;
    }
    public Mer getMerOrdi() {
            return merOrdi;
    }
    public void setMerOrdi(Mer merOrdi) {
            this.merOrdi = merOrdi;
    }
}