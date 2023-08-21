package games.players;
import java.util.Scanner;
import games.genericgames.Game;
import java.util.ArrayList;

public class Human implements Player{
	private String nom ;
	private Scanner scanner;
	public Human(String nom, Scanner scanner){
		this.nom=nom;
		this.scanner= scanner;
	}
	public int chooseMove(Game jeu){
		
		String coupStr;
		int coupInt;
		System.out.println("\nVoici la liste de coups valides :\n");
		System.out.println(jeu.validMoves()+"\n");
		do {
		System.out.println("Choisissez parmi ces coups ci-dessus\n");
		coupStr = this.scanner.next();
		coupInt=Integer.parseInt(coupStr);
		System.out.println("Vous avez choisi de jouez le coup "+coupInt+".\n\n");
		if (jeu.validMoves().contains(coupInt)==false){
			System.out.println("Le coup choisi est faux ! Rechoisissez un coup correct.\n");
		}
		} while (jeu.validMoves().contains(coupInt)==false);
		System.out.println("Le coup est valide !\n");
		return coupInt;
	}
	public String toString(){
		return this.nom;
	}
}
