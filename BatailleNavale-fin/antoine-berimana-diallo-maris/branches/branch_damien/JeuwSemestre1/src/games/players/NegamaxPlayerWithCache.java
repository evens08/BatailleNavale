package games.players;
import games.genericgames.*;
import games.plays.*;
import java.util.HashMap;



public class NegamaxPlayerWithCache extends NegamaxPlayer {
    
    public NegamaxPlayerWithCache(){}
    
    public HashMap<Game,Integer> SauvegardeSituation = new HashMap<Game,Integer>();
    
    @Override
    public int evaluate(Game jeu){
        if(this.SauvegardeSituation.containsKey(jeu)){
            return this.SauvegardeSituation.get(jeu);
        } else {
            this.SauvegardeSituation.put(jeu,super.evaluate(jeu));
            return super.evaluate(jeu);
        }
    }

    public String toString(){
        return "Negamax Doux";
    }
}