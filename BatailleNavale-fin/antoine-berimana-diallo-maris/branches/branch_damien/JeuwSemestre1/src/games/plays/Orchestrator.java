package games.plays;
import games.players.Player;
import games.genericgames.*;

public class Orchestrator{
	private Game jeu;
	public Orchestrator(Game jeu){
		this.jeu = jeu;
	}
	public void play(){
		System.out.println("Le joueur "+this.jeu.getCurrentPlayer()+" commence \n");
		int coup;
		while (this.jeu.isOver()==false){
			System.out.println("A toi de jouer "+this.jeu.getCurrentPlayer()+".\n");
			System.out.println("\n"+this.jeu.situationToString()+"\n");
			for(int i=0;i<jeu.validMoves().size();i++){
                                System.out.println(jeu.validMoves().get(i)+" = " + jeu.moveToString(jeu.validMoves().get(i)));
                        }
			coup = this.jeu.getCurrentPlayer().chooseMove(this.jeu);
			System.out.println("\nLe coup " + coup + " a été joué par "+ this.jeu.getCurrentPlayer()+" !");
			this.jeu.execute(coup);
		}
		System.out.println(this.jeu.situationToString()+"\n");
		if (this.jeu.getWinner()==null){
			System.out.println("La partie est nulle");	
		} else {
			System.out.println("Le joueur gagnant est : "+this.jeu.getWinner()+" ! Bravo <3 !");
		}
	}
}
