package bataillenavale;
import java.util.ArrayList;

import bataillenavale.PieceBateau.Etat;


public class Bateau {

	public int taille, ligne, colonne;
	public boolean coulee, horizontal;
	public ArrayList<PieceBateau> quiConstitueBateau;
	
	public Bateau(int taille, int ligne, int colonne, boolean horizontal) {
		this.taille=taille;
		this.ligne=ligne;
		this.colonne=colonne;
		this.coulee=false;
		this.horizontal=horizontal;
		this.quiConstitueBateau=this.creationPieces(this.taille);
	}
	public ArrayList<PieceBateau> creationPieces(int taille) {
		ArrayList<PieceBateau> listePiece = new ArrayList<PieceBateau>();
		if(this.horizontal==true) {	
			for(int i=0;i<taille;i++) {
				listePiece.add(new PieceBateau(this.ligne,this.colonne+i));
			}
		} else {
			for(int i=0;i<taille;i++) {
				listePiece.add(new PieceBateau(this.ligne+i,this.colonne));
			}
		}
		return listePiece;
	}
	public void estCoulee() {
		for (PieceBateau piece : this.quiConstitueBateau) {
			if(piece.getEtatCourant()==Etat.INTACTE) {
				this.coulee=false;
				return;
			}
		}
		this.coulee=true;	
	}
}
