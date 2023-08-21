package games.genericgames;
import games.players.Player;
import java.util.ArrayList;
public abstract class AbstractGame implements Game{

        protected Player joueur1;

        protected Player joueur2;

        protected Player joueurCourant;

        public AbstractGame(Player joueur1, Player joueur2){
                this.joueur1=joueur1;
                this.joueur2=joueur2;
                this.joueurCourant=joueur1;
        }

        protected abstract void doExecute(int coup);

        public void execute(int coup){
                doExecute(coup);
                if (this.joueurCourant==this.joueur1){
                        this.joueurCourant=this.joueur2;
                } else if (this.joueurCourant==this.joueur2){
                	this.joueurCourant=this.joueur1;
                }
        }

        public Player getCurrentPlayer(){
                return this.joueurCourant;
        }

        public abstract ArrayList<Integer> validMoves();

        public abstract boolean isOver();

        public abstract Player getWinner();

        public abstract String moveToString(int move);

        public abstract String situationToString();

        public abstract Game copy();

}
