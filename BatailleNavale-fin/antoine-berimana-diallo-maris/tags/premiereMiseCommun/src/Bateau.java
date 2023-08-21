package premieremisecommun;
import java.util.ArrayList;

//import premieremisecommun.PieceBateau.*;



public class Bateau {

	private int taille, ligne, colonne;
	private boolean coulee, horizontal;
	private ArrayList<PieceBateau> quiConstitueBateau;
	
	
	public Bateau(int taille, int ligne, int colonne, boolean horizontal) {
		this.taille=taille;
		this.ligne=ligne;
		this.colonne=colonne;
		this.setCoulee(false);
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
			if(piece.getEtatCourant()==0) {
				this.setCoulee(false);
				return;
			}
		}
		this.setCoulee(true);
	}
	public boolean isCoulee() {
		return coulee;
	}
	public void setCoulee(boolean coulee) {
		this.coulee = coulee;
	}
	public int getTaille() {
		return taille;
	}
	public void setTaille(int taille) {
		this.taille = taille;
	}
	public int getLigne() {
		return ligne;
	}
	public void setLigne(int ligne) {
		this.ligne = ligne;
	}
	public int getColonne() {
		return colonne;
	}
	public void setColonne(int colonne) {
		this.colonne = colonne;
	}
	public boolean isHorizontal() {
		return horizontal;
	}
	public void setHorizontal(boolean horizontal) {
		this.horizontal = horizontal;
	}
	public ArrayList<PieceBateau> getQuiConstitueBateau() {
		return quiConstitueBateau;
	}
	public void setQuiConstitueBateau(ArrayList<PieceBateau> quiConstitueBateau) {
		this.quiConstitueBateau = quiConstitueBateau;
	}
	/*public void changerEtatPiecesCoulee() {
		for(int i=0;i<this.taille;i++) {
			this.quiConstitueBateau.get(i).setEtatCourant(2);//coulee toutes les pices du bateau
		}
	}*/
}
