package games.genericgames;
import games.players.Player;
import java.util.ArrayList;
import java.util.Objects;

public class Nim extends AbstractGame implements Game{
	// Exercice 1
	private int n;

	private int k;

	private int nombreAllumettesRestantes;


	//Exercice 2
	public Nim(int n,int k,Player joueur1,Player joueur2){
		super(joueur1,joueur2);
		this.n=n;
		this.k=k;
		this.nombreAllumettesRestantes=n;
	}
	//Exercice 3
	public int getInitialNbMatches(){
		return this.n;
	}
	public int getCurrentNbMatches(){
		return this.nombreAllumettesRestantes;
	}
	public Player getCurrentPlayer(){
		return super.getCurrentPlayer();
	}
	// en plus
	public int getMaxRetirer(){
		return this.k;
	}
	//Exercice 4
	public String situationToString(){
		return "Il reste " + this.nombreAllumettesRestantes + " allumettes.";
	}
	//Exercice 5
	@Override
	public void doExecute(int nbChoisi){
		this.nombreAllumettesRestantes=this.nombreAllumettesRestantes-nbChoisi;
	}
	public void execute(int nbChoisi){
		super.execute(nbChoisi);
	}

	//Exercice 6
	public boolean isValid(int nbChoisi){
		if ((nbChoisi>0) && (nbChoisi<=this.k) && (nbChoisi<=this.nombreAllumettesRestantes)) {
			return true;
		} else	{
			return false;
		}
	}

	public boolean isOver(){
		if (this.nombreAllumettesRestantes==0){
			return true;
		} else {
			return false;
		}
	}
	public Player getWinner(){
		if (this.nombreAllumettesRestantes>0){
			return null;

		} else {
			return this.joueurCourant ;
		}
	}
	public ArrayList<Integer> validMoves(){

		ArrayList<Integer> possibilites = new ArrayList<Integer>();
		for(int l=1;l<=this.k;l++){
			if(this.isValid(l)==true){
				possibilites.add(l);
			}
		}
		return possibilites;
	}
	public String moveToString(int coup){

		return "Nombre d'allumettes pouvant être retirées : " + coup;
	}
	public Game copy(){
		Nim res = new Nim(this.n,this.k,this.joueur1,this.joueur2);
		res.nombreAllumettesRestantes=this.nombreAllumettesRestantes;
		res.joueurCourant=this.joueurCourant;
		return res;
	}


	@Override
	public boolean equals(Object other){
		if (other==null){
			return false;
		}
		if (!(other instanceof Nim)){
			return false;
		}
		Nim otherAsNim=(Nim)other;
		return (super.joueurCourant.equals(otherAsNim.joueurCourant) && this.nombreAllumettesRestantes==otherAsNim.nombreAllumettesRestantes && this.k==otherAsNim.k);
	}
	@Override
	public int hashCode(){
		return Objects.hash(super.joueurCourant,this.nombreAllumettesRestantes,this.k);
	}

}
