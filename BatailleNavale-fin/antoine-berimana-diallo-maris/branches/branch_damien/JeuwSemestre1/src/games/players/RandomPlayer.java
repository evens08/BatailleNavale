package games.players;
import games.genericgames.Game;
import java.util.Random;
import java.util.ArrayList;

public class RandomPlayer implements Player{
	public Random rand;
	public RandomPlayer(Random rand){
		this.rand= new Random();
	}
	public int chooseMove(Game jeu){
		int tailleRandom = jeu.validMoves().size();
		int aleatoire = this.rand.nextInt(tailleRandom);
		return jeu.validMoves().get(aleatoire);
	}
	public String toString(){
		return "Joueur aléatoire n° " + this.hashCode();
	}
}