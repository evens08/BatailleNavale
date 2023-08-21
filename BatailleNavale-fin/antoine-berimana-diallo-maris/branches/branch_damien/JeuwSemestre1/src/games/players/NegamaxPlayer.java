package games.players;
import games.genericgames.*;
import games.plays.*;


public class NegamaxPlayer implements Player{
    
    public NegamaxPlayer(){}

    public int evaluate(Game jeu){
        if (jeu.isOver()){
            if (jeu.getCurrentPlayer()==jeu.getWinner()){
                return 1;
            } else if (jeu.getWinner()==null) {
                return 0;
            } else /*if ((!jeu.getWinner().equals(null))&&(!jeu.getWinner().equals(jeu.getCurrentPlayer())))*/{
                return -1;
            }
        } else {
            Integer res=null;
            for (int i=0; i<jeu.validMoves().size();i++){
                int c=jeu.validMoves().get(i);
                Game jeuMultiverse=jeu.copy();
                jeuMultiverse.execute(c);
                Integer v= -evaluate(jeuMultiverse);
                if ((res==null)||(v>res)){
                    res=v;
                }
            }
        return res;
        }
    }
    

    public int chooseMove(Game jeu){
        Integer meilleureValeur=null;
        Integer meilleurCoup =null;
        for (int i=0; i<jeu.validMoves().size();i++){
            int c=jeu.validMoves().get(i);
            Game jeuMultiverse=jeu.copy();
            jeuMultiverse.execute(c);
            Integer v= -evaluate(jeuMultiverse);
            if ((meilleureValeur==null)||(v>meilleureValeur)){
                meilleureValeur=v;
                meilleurCoup=c;
            }
        }
        return meilleurCoup;    
    }

    public String toString(){
        return "Negamax Brut";
    }



}


