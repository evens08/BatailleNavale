package games.genericgames;
import games.players.*;
import games.genericgames.*;
import java.util.ArrayList;
import games.plays.*;
import java.util.Random;
import java.util.Scanner;


public class GamesExe{
        public static void main(String[] args){
                Random rand = new Random(123);
                Scanner scanner=new Scanner(System.in);
                //Player player1 = new Human("Moi", scanner);
                Player player1 = new RandomPlayer(rand);
                //Player player2 = new RandomPlayer(rand);
                Player player2=new NegamaxPlayer();
                //TicTacToe game = new TicTacToe(player1, player2);
		Nim game = new Nim(50,3,player1, player2);
		Orchestrator orchestrator = new Orchestrator(game);
		orchestrator.play();
		scanner.close();
        }
}
