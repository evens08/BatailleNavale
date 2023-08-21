package games.genericgames;
import games.players.*;
import games.genericgames.*;
import java.util.ArrayList;
import games.plays.*;
import java.util.Random;
import java.util.Scanner;


public class GamesExe2{
        public static void main(String[] args){
                Scanner scanner=new Scanner(System.in);
                Random rand = new Random(123);
                
                /*Player player1 = new Human("Moi", scanner);
                Player player2=new NegamaxPlayerWithCache();
                
                Player player1 = new RandomPlayer(rand);
                Player player2 = new RandomPlayer(rand);
                Player player2=new NegamaxPlayerWithCache();
                TicTacToe game = new TicTacToe(player1, player2);
                Nim game = new Nim(50,3,player1, player2);
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();*/

                System.out.println("Bienvenue ! Ce programme vous permet de jouer à 2 jeux qui sont :");
                System.out.println("    - (1) Un jeu de Nim");
                System.out.println("    - (2) Un jeu du TicTacToe\n");
                System.out.println("Tapez le numéro correspondant au jeu que vous voulez jouez");
                
                String choixDeJeu = scanner.next();
                int choixDeJeuAsInt=Integer.parseInt(choixDeJeu);
                int n=0;
                int k=0;
                while(!((choixDeJeuAsInt==1)||(choixDeJeuAsInt==2))){
                        System.out.println("Mauvais choix");
                        System.out.println("(1) pour le Jeu de Nim et (2) pour le Jeu de TicTacToe.");
                        choixDeJeu = scanner.next();
                        choixDeJeuAsInt=Integer.parseInt(choixDeJeu);
                }
                System.out.println("\nRègles du jeu\n");
                if(choixDeJeuAsInt==1){     
                        System.out.println("Vous avez un tas d'allumettes à votre disposition et un nombre maximum d'allumettes pouvant être retirées. Celui qui retire la dernière allumette a perdu.\n");
                        System.out.println("Veuillez définir le nombre d'allumettes du tas et le nombre d'allumettes que vous voulez retire au maximum par tour.");
                        
                        System.out.println("Quantité du tas :");                       
                        String nbTasStr = scanner.next();
                        n=Integer.parseInt(nbTasStr);
                        
                        System.out.println("Quantité de retrait max :");
                        String nbMaxStr = scanner.next();
                        k=Integer.parseInt(nbMaxStr);

                        System.out.println("Quantité du tas :");
                        System.out.println("La partie se déroulera avec un tas initial de " + n + " et vous pourrez retirer aux maximum " + k + " allumettes."); 
                
                } else {
                        System.out.println("Vous avez une grille de 9 cases. Le but est de réussir à aligner 3 crois si vous êtes joueur 1 ou 3 crois ronds si vous êtes joueur 2");
                }
               
                String choixDeConfig;
                int choixDeConfigAsInt;
                
                do{
                System.out.println("\nVous pouvez jouer de différentes manières, les voici :\n");
                System.out.println("    - (1) J1:Joueur vs J2:Joueur");
                System.out.println("    - (2) J1:Joueur vs J2:IA");
                System.out.println("    - (3) J1:Joueur vs J2:Aléatoire");
                System.out.println("    - (4) J1:IA vs J2:IA");
                System.out.println("    - (5) J1:Aléatoire vs J2:Aléatoire");
                System.out.println("    - (6) J1:IA vs J2:Aléatoire");
                
                choixDeConfig = scanner.next();
                choixDeConfigAsInt=Integer.parseInt(choixDeConfig);
                
                if ((choixDeConfigAsInt<1)&&(choixDeConfigAsInt>6)){
                        System.out.println("Mauvais choix\n\n\n\n");
                }
                }while((choixDeConfigAsInt<1)&&(choixDeConfigAsInt>6));
                
                Player playerA=null;
                Player playerB=null;
                if(choixDeConfigAsInt<=3){
                        System.out.println("Veuillez entrez votre nom de joueur car vous avez choisi une configuration où vous jouez.");
                        String joueurA = scanner.next();
                        playerA = new Human(joueurA, scanner);
                }

                switch(choixDeConfigAsInt){
                        case 1:
                                System.out.println("Vous avez choisi de jouez à 2 !");
                                System.out.println("Veuillez entrez le nom de l'autre joueur.");
                                String joueurB = scanner.next();
                                playerB = new Human(joueurB, scanner);
                                break;
                        
                        case 2:
                                playerB=new NegamaxPlayerWithCache();
                                break;

                        case 3:
                                playerB = new RandomPlayer(rand);
                                break;

                        case 4:
                                playerA=new NegamaxPlayerWithCache();
                                playerB=new NegamaxPlayerWithCache();
                                break;
                        
                        case 5:
                                playerA = new RandomPlayer(rand);
                                playerB = new RandomPlayer(rand);
                                break;

                        case 6:
                                playerA = new NegamaxPlayerWithCache();
                                playerB = new RandomPlayer(rand);
                                break;
                }

                String choixQuiCommence;
                int choixQuiCommenceAsInt;
                do{
                System.out.println("\nChoisissez qui commence :\n");
                System.out.println("    - (1) J1");
                System.out.println("    - (2) J2");
                System.out.println("    - (3) Aléatoire");

                
                choixQuiCommence = scanner.next();
                choixQuiCommenceAsInt=Integer.parseInt(choixQuiCommence);
                
                if ((choixQuiCommenceAsInt<1)&&(choixQuiCommenceAsInt>3)){
                        System.out.println("Mauvais choix\n\n\n\n");
                }
                }while((choixQuiCommenceAsInt<1)&&(choixQuiCommenceAsInt>3));

                Game game = null;
                if (choixDeJeuAsInt==1){
                        switch(choixQuiCommenceAsInt){
                                case 1:
                                        game = new Nim(n,k,playerA, playerB);
                                        break;
                                case 2:
                                        game = new Nim(n,k,playerB, playerA);
                                        break;
                                case 3:
                                        int j1ouj2=1+rand.nextInt(1);
                                        if (j1ouj2==1){
                                                game = new Nim(n,k,playerA, playerB);
                                        } else {
                                                game = new Nim(n,k,playerB, playerA);
                                        }
                                        break;
                        }               
                } else if (choixDeJeuAsInt==2){
                        switch(choixQuiCommenceAsInt){
                                case 1:
                                        game = new TicTacToe(playerA, playerB);
                                        break;
                                case 2:
                                        game = new TicTacToe(playerB, playerA);
                                        break;
                                case 3:
                                        int j1ouj2=1+rand.nextInt(1);
                                        if (j1ouj2==1){
                                                game = new TicTacToe(playerA, playerB);
                                        } else {
                                                game = new TicTacToe(playerB, playerA);
                                        }
                                        break;
                        }
                }
                Orchestrator orchestrator = new Orchestrator(game);
                orchestrator.play();
                scanner.close();




        }
}
