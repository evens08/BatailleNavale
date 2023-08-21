package modele.execution;
import modele.elements.BatailleNavale;
import modele.joueur.JoueurHumain;

import java.util.Scanner;

/**
 * Classe exécutable pour une partie console
 */
public class Main{
	/**
	 * Execute
	 * @param args ignored
	 */
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		BatailleNavale batailleNavale = new BatailleNavale(new JoueurHumain());
		DeroulerBataille deroulerBataille =new DeroulerBataille(batailleNavale);
		deroulerBataille.play();
		scanner.close();

	}
}