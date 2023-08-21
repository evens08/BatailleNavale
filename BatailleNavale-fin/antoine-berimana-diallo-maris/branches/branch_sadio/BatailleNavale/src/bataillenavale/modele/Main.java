package bataillenavale.modele;
import java.util.Random;

import java.util.Scanner;
public class Main{
        public static void main(String[] args) {
                Scanner scanner=new Scanner(System.in);
                Random rand=new Random();
                /*int test=0;
                test = rand.nextInt(11);
                int[] testTab=new int[11];
                for (int i=0;i<11;i++) {
                        test = rand.nextInt(11);
                        testTab[i]=test;
                }
                for (int i=0;i<11;i++) {
                        System.out.println(testTab[i]);
                }
                Mer mer = new Mer();
                System.out.println(mer);
                mer.getFlotte().get(4).getQuiConstitueBateau().get(0).setEtatCourant(2);
                mer.getFlotte().get(4).getQuiConstitueBateau().get(1).setEtatCourant(2);
                System.out.println(mer);
                CoordonneesBataille testCo= new CoordonneesBataille('D'-65,2);
                System.out.println(testCo);
                System.out.println(testCo.getCoord());*/
                //System.out.println("***************************************************************************************************************\n");
                Menu menu = new Menu();
                menu.montrerMenu();
                BatailleNavale batailleNavale = new BatailleNavale(new JoueurHumain());
                DeroulerBataille1 deroulerBataille=new DeroulerBataille1(batailleNavale);
                deroulerBataille.play();
                scanner.close();
        }
}