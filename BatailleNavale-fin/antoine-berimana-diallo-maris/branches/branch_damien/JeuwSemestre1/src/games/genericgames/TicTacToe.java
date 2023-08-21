package games.genericgames;
import java.util.ArrayList;
import games.players.Player;
import java.util.Objects;
import java.util.Arrays;

/**
 * Une classe représentant une partie de TicTacToe
 * @author Damien Maris et Evens Antoine
 */

public class TicTacToe extends AbstractGame implements Game{


    /** Tableau à deux dimensions stockant les coups joués */
	private Player[][] tableau;
	private Player point;


	/** Construis une nouvelle partie de TicTacToe en initialisant un tableau qui fait office de grille de TicTacToe.
     *  Etablie aussi que le premier joueur indiqué est le joueur courant.
     * @param joueur1  Nom du premier joueur
     * @param joueur2  Nom du second joueur
     */
	public TicTacToe(Player joueur1,Player joueur2){

		super(joueur1,joueur2);

		/* Etablissement du tableau qui va comprendre les coups, ce tableau n'est jamais affiché en tant que tel.
        La méthode situationToString s'en occupera plus tard. */

		this.tableau= new Player [4][4];


	}

    /**
     * Renvoie le joueur courant.
     * @return Le joueur courant
     */
	public Player getCurrentPlayer(){

		return super.getCurrentPlayer();
	}

    /**
     * Renvoie la ligne du coup indiqué.
     *
     * @param coup Case du TicTacToe
     * @return Ligne du coup indiqué
     */
	public int quelleLigne(int coup){

		return (coup/3)+1;
	}

     /**
     * Renvoie la colonne du coup indiqué.
     *
     * @param coup Case du TicTacToe
     * @return Colonne du coup indiqué
     */
	public int quelleColonne(int coup){

		return (coup%3)+1;
	}



	@Override
	public void doExecute (int coup){

		this.tableau[this.quelleLigne(coup)][this.quelleColonne(coup)]=this.getCurrentPlayer();
	}

	public void execute (int coup){
		super.execute(coup);
	}

    /**
     * Renvoie la valeur du tableau qui correspond au coup choisi.
     *
     * @param coup Case du TicTacToe
     * @return Valeur du tableau correspondant au coup
     */
	public Player valeur(int coup){

		return this.tableau[this.quelleLigne(coup)][this.quelleColonne(coup)];
	}


    /**
     * Décide si un coup est valide.
     *
     * @param coup Case du TicTacToe
     * @return true si le coup est valide, false si le coup ne l'est pas
     */
	public boolean isValid(int coup){
		//Les coups sont valides si l'entier tapé est entre 0 et 8 et que la valeur du tableau est un "." à l'emplacement lié au coup
		if ((coup>=0) && (coup <=8) && (this.valeur(coup)==null)){
			return true;
		} else {
			return false;
		}
	}

    /**
     * Renvoie le coup correspondant à sa ligne et sa colonne.
     *
     * @param ligne Une ligne de la grille du TicTacToe
     * @param colonne Une colonne de la grille du TicTacToe
     * @return Le coup correspondant à la ligne et la colonne entrée
     */
	public int quelCoup(int ligne, int colonne){

		ligne-=1;
		colonne-=1;

		return ligne*3+colonne;
	}


    /**
     * Renvoie une liste de tous les coups jouables valides.
     *
     * @return Liste sous forme de ArrayList<Integer> des coup valides
     */
	public ArrayList<Integer> validMoves(){

		ArrayList<Integer> possibilites = new ArrayList<Integer>();

		//parcours du tableau
		for(int l=1;l<4;l++){

			for(int c=1;c<4;c++){

				if (this.isValid(this.quelCoup(l,c))==true){
					possibilites.add(quelCoup(l,c));
				}
			}
		}

		return possibilites;
	}


    /**
     * Décide si 3 cases alignées du tableau ont la même valeur de nom de joueur
     *
     * @param joueur Nom d'un des deux joueurs
     * @param row Une ligne du TicTacToe
     * @param column Une colonne du TicTacToe
     * @param deltaRow Un chiffre qui peut prendre 3 valeurs à savoir : -1,0 ou 1 permettant le décalage du parcours du tableau sur les lignes dans la méthode
     * @param deltaColumn n chiffre qui peut prendre 3 valeurs à savoir : -1,0 ou 1 permettant le décalage du parcours du tableau sur les colonnes dans la méthode
     * @return true si les 3 cases vérifiées ont le même nom de joueur, false sinon
     */
	public boolean wins(Player joueur, int row, int column, int deltaRow, int deltaColumn){
		if ((this.tableau[row+1][column+1]==null)
		|| (this.tableau[row+1+deltaRow][column+1+deltaColumn]==null)
		|| (this.tableau[row+1+2*deltaRow][column+1+2*deltaColumn]==null)){

			return false;
		}
		//condition pour avoir un alignement
		if ((this.tableau[row+1][column+1].equals(joueur))
		&& (this.tableau[row+1+deltaRow][column+1+deltaColumn].equals(joueur))
		&& (this.tableau[row+1+2*deltaRow][column+1+2*deltaColumn].equals(joueur))){

			return true;
		}

		return false;
	}

    /**
     * Renvoie soit le joueur ayant gagné dans la situation actuelle soit null
     *
     * @return Le nom du joueur gagnant si 3 cases alignées ont la même valeur ou null dans les autres cas
     */
	public Player getWinner(){

		//tableau pour mettre les deux joueurs et facilité getwinner pour vérifier les 2
		Player[] j1_et_j2= new Player[2];
		j1_et_j2[0]=super.joueur1;
		j1_et_j2[1]=super.joueur2;

		// boucle permettant de faire les prochains tests sur le premier joueur puis sur le second.
		for(int j=0; j<2;j++){

			// on s'occupe des victoires pour chaque colonne
			for (int c=0;c<3;c++){
				if ( wins(j1_et_j2[j],0,c,1,0)==true){
					return j1_et_j2[j];
				}
			}

			//on s'occupe des victoires pour chaque ligne
			for (int l=0;l<3;l++){
				if (wins(j1_et_j2[j],l,0,0,1)==true){
					return j1_et_j2[j];
				}
			}

			// on s'occupe des victoires par diagonale
			if (wins(j1_et_j2[j],0,0,1,1)==true){ //victoire par diagonale naturelle
				return j1_et_j2[j];
			}

			if (wins(j1_et_j2[j],0,2,1,-1)==true){ //victoire par anti diagonale
				return j1_et_j2[j];
			}
		}
		// si aucun des tests précédents n'a fonctionner pour chaque joueur
		return null;
	}


	/**
     * Décide si la partie est terminée.
     *
     * @return true si on a un joueur victorieux ou s'il n'y a plus de coups jouables, faux sinon
     */
    public boolean isOver(){

		//si l'un des joueurs à 3 cases alignées
		if ((this.getWinner()==super.joueur1) || (this.getWinner()==super.joueur2) ){
			return true;
		}

		//s'il n'y a plus de coups jouables
		if (this.validMoves().size()==0){
			return true;
		}

		return false;
	}


	/**
     * Renvoie les coordonnées correspondant au coup indiqué
     *
     * @param coup Case de TicTacToe
     * @return Les coordonnées du coup
     */
    public String moveToString(int coup){

		return "("+this.quelleLigne(coup)+","+this.quelleColonne(coup)+")";
	}


	/**
     * Créer une chaine de caractères représentant le tableau du TicTacToe, les valeurs du tableau correspondant aux coup des
     * deux joueurs sont ensuite remplacées par les symboles "X" et "O" respectivement en considérant que le joueur 1 joue
     * les "X" et le joueur 2, les "O"
     *
     * @return Chaine de caractères sur plusieurs lignes représentant la grille de TicTacToe
     */
	public String situationToString(){

		// Intialise la chaîne de caractères
		String plateau="";

		// Mets en forme une chaine de caractères pour ressembler à un tableau en deux dimensions qui représente l'état actuel
		// du tableau pour l'utilisateur. Les valeurs du tableau sont à chaque fois ajoutées à la chaîne de caractères avec leur
		// symboles respectifs ({"X","O"}).
		plateau +=" 123";
		plateau+=System.lineSeparator();
		for (int l=1;l<4;l++){
			plateau+=l;
			for (int c=1;c<4;c++){

				if(this.tableau[l][c]==super.joueur1){
					//plateau.substring(0, plateau.length()-1);
					plateau+="X";

				}

				if(this.tableau[l][c]==super.joueur2){
					//plateau.substring(0, plateau.length()-1);
					plateau+="O";
				}

				if((!super.joueur1.equals(this.tableau[l][c]))&&(!super.joueur2.equals(this.tableau[l][c]))){
					plateau+=".";
					//plateau.substring(0, plateau.length()-1);
				}
			}

			plateau+=System.lineSeparator();
		}
		//On efface les noms des joueurs pour avoir que les "X" et "O" à la place des noms de joueurs.
		plateau=plateau.replaceAll(super.joueur2.toString(),"");
		plateau=plateau.replaceAll(super.joueur1.toString(),"");

		return plateau;
		}
	public Game copy(){
		TicTacToe res = new TicTacToe(super.joueur1,super.joueur2);
		res.tableau = new Player[4][4];
		for (int l=0;l<4;l++){
			for (int c=0;c<4;c++){
				res.tableau[l][c]=this.tableau[l][c];
			}
		}
		res.joueurCourant=super.joueurCourant;
		return res;
	}



	@Override
	public boolean equals(Object other){
		if (other==null){
			return false;
		}
		if (!(other instanceof TicTacToe)){
			return false;
		}
		TicTacToe otherAsTicTacToe=(TicTacToe)other;
		return (super.joueurCourant.equals(otherAsTicTacToe.joueurCourant) && Arrays.deepEquals(this.tableau, otherAsTicTacToe.tableau));
	}
	@Override
	public int hashCode(){
		return Objects.hash(super.joueurCourant,Arrays.deepHashCode(this.tableau));
	}


}
