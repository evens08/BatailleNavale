package games.genericgames;
import java.util.ArrayList;
import games.players.Player;

public interface Game{
	public Player getCurrentPlayer();
	public ArrayList<Integer> validMoves();
	public boolean isValid(int coup);
	public void execute(int coup);
	public boolean isOver();
	public Player getWinner();
	public String moveToString(int move);
	public String situationToString();
	public Game copy();
}