package premieremisecommun;

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
		if (ligne<1 || ligne>10 || colonne<1||colonne>10) {
			return false;
		}
		if (this.joueurCourant==this.joueur) {
			if(merOrdi.getGrille()[ligne][colonne].getEtatCourant()>=1) {
				return false;
			}
			if(merOrdi.getGrille()[ligne][colonne]==null) {
				merOrdi.getGrille()[ligne][colonne]=new TirLoupee(ligne,colonne);
			}
		} else {
			if(merJoueur.getGrille()[ligne][colonne].getEtatCourant()>=1) {
				return false;
			}
			if(merOrdi.getGrille()[ligne][colonne]==null) {
				merOrdi.getGrille()[ligne][colonne]=new TirLoupee(ligne,colonne);
			}
		}
		return true;
	}
	public boolean isOverJoueur() {
		for(Bateau bateaux : merJoueur.getFlotte()) {
			if(bateaux.isCoulee()==false) {
				return false;
			}
		}
		return true;
	}
	public boolean isOverOrdi() {
		for(Bateau bateaux : merOrdi.getFlotte()) {
			if(bateaux.isCoulee()==false) {
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
			}
		} else {
			if(merJoueur.getGrille()[ligne][colonne].getEtatCourant()==0) {
				merJoueur.getGrille()[ligne][colonne].changerEtat();
			}
		}
	}
	
	
}
