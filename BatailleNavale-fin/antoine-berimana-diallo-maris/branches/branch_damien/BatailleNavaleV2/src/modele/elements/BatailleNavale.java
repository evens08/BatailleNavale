package modele.elements;

import controller.AbstractModeleEcoutable;
import modele.joueur.Joueur;
import modele.joueur.JoueurHumain;
import modele.joueur.JoueurOrdinateur;

import java.util.ArrayList;

/**
 * Classe pour établir les règles d'une Bataille Navale.
 * @author Maris,Sadio,Antoine,Berimana
 */
public class BatailleNavale extends AbstractModeleEcoutable {
	private  JoueurHumain joueur;
	private  JoueurOrdinateur aleatoire;
	private  Mer merJoueur;
	private  Mer merOrdi;
	private Joueur joueurCourant;

	/**
	 * Construit une nouvelle partie de Bataille navale et initialise le joueur, l'ordinateur et leur mer associé ainsi que définie le joueur comme le premier joueur
	 * @param joueur
	 */
	public BatailleNavale(JoueurHumain joueur) {
		this.merJoueur=new Mer();
		this.merOrdi=new Mer();
		this.joueur=joueur;
		this.aleatoire=new JoueurOrdinateur();
		this.joueurCourant=this.joueur;
	}

	/**
	 * Construit une partie de Bataille Navale avec le nom Joueur par défaut.
	 */
	public BatailleNavale() {
		this(new JoueurHumain("Joueur.se"));
	}

	/**
	 * Renvoie le joueur courant
	 * @return Le joueur courant
	 */
	public Joueur getJoueurCourant() {
		return joueurCourant;
	}


	/**
	 * Décide si le coup est valide. De plus, si le coup est ciblé sur une case vide la case s'instanciera en tant que nouvelle PieceBateau avec l'état LOUPEE.
	 * @param coup Coordonnees d'un coup choisi
	 * @return true si le coup est valide, faux sinon
	 */
	public boolean isValid(CoordonneesBataille coup) {
		boolean result = false;
		int ligne = coup.getLigne();

		int colonne = coup.getColonne();

		if (ligne >= 0 && ligne <= 9 && colonne >= 0 && colonne <= 9) {
			if (this.getMerOuJoueurCourantJoue().getGrille()[ligne][colonne] == null) {
				result = true;
			} else if (this.getMerOuJoueurCourantJoue().getGrille()[ligne][colonne].getEtatCourant() == PieceBateau.INTACTE) {
				result = true;
			}
		}
		return result;
	}

	/**
	 * Instancie une PieceBateau avec l'état LOUPEE
	 * @param coos Coordonnees d'un coup
	 * @return La pièce insatnciée avec les coordonnéees de coos.
	 */
	public PieceBateau creerPieceLoupee(CoordonneesBataille coos){
		return new PieceBateau(coos.getLigne(),coos.getColonne(),PieceBateau.LOUPEE);
	}

	/**
	 * Décide si la flotte du joueur a été coulée.
	 * @return true si toute la flotte du joueur a été coulée, faux sinon
	 */
	private boolean isOverJoueur() {
		for(Bateau bateaux : merOrdi.getFlotte()) {
			if(!bateaux.isCoulee()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Décide si la flotte de l'ordinateur a été coulée.
	 * @return true si toute la flotte de l'ordinateur a été coulée, faux sinon
	 */
	private boolean isOverOrdi() {
		for(Bateau bateaux : merJoueur.getFlotte()) {
			if(!bateaux.isCoulee()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Décide si au moins une des flottes a été coulée
	 * @return true si au moins une des flottes a été coulée, faux sinon
	 */
	public boolean isOver() {
		return this.isOverJoueur() || this.isOverOrdi();
	}

	/**
	 * Joue un coup
	 * @param coup Coordonnées d'un coup choisi
	 */
	public void jouerCoup(CoordonneesBataille coup) {
		int ligne=coup.getLigne();
		int colonne=coup.getColonne();
		if (this.getMerOuJoueurCourantJoue().getGrille()[ligne][colonne]==null) {
			this.getMerOuJoueurCourantJoue().getGrille()[ligne][colonne] = this.creerPieceLoupee(coup);
		}
		this.getMerOuJoueurCourantJoue().getGrille()[ligne][colonne].changerEtat();
		System.out.println(this.getMerOuJoueurCourantJoue().getGrille()[ligne][colonne].etatPieceBateau());

		this.getMerOuJoueurCourantJoue().actualisationBateauCoulee();
		if(this.joueurCourant==this.aleatoire){
			this.joueurCourant=this.joueur;
		} else{
			this.joueurCourant=this.aleatoire;
		}
		fireChangement();

	}

	/**
	 * Renvoie le nom du joueur gagnant, s'il y en a un
	 * @return Le joueur gagnant si la partie est terminée sinon null
	 */
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

	/**
	 * Getter de la mer du joueur
	 * @return La mer de l'utilisateur
	 */

	public Mer getMerJoueur() {
		return merJoueur;
	}

	/**
	 * Renvoie la mer du joueur courant
	 * @return La mer du joueur courant
	 */
	public Mer getMerJoueurCourant(){
		if (joueurCourant==this.joueur){
			return merJoueur;
		} else {
			return merOrdi;
		}
	}
	public Mer getMerOuJoueurCourantJoue(){
		if (joueurCourant==this.joueur){
			return merOrdi;
		} else {
			return merJoueur;
		}
	}

	/**
	 * Getter de la mer de l'ordianateur
	 * @return Le mer de l'ordinateur
	 */


	public Mer getMerOrdi() {
		return merOrdi;
	}


	/**
	 * Renvoie la liste des coups valides
	 * @return Liste de Coordonnees de coups valides
	 */

	public ArrayList<CoordonneesBataille> validMoves(){
		ArrayList<CoordonneesBataille> coupsJouables=new ArrayList<CoordonneesBataille>();
		CoordonneesBataille possibilite;
		for(int i=0;i<this.getMerOuJoueurCourantJoue().getGrille().length;i++ ){
			for(int j=0;j<this.getMerOuJoueurCourantJoue().getGrille().length;j++){
				possibilite= new CoordonneesBataille(i,j);
				if(this.isValid(possibilite)){
					coupsJouables.add(possibilite);
				}
			}
		}
		return coupsJouables;
	}





	/**
	 * Renvoie l'utilisateur
	 * @return Le joueur utilisateur
	 */

	public JoueurHumain getJoueur() {
		return joueur;
	}

	/**
	 * Renvoie le joueur aléatoire
	 * @return Le joueur aléatoire
	 */

	public JoueurOrdinateur getAleatoire() {
		return aleatoire;
	}
}
