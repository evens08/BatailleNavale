package modele.elements;

import java.util.Objects;

/**
 * Classe représentant les coordonnées d'un coup
 */
public class CoordonneesBataille {

	private int ligne,colonne;

	/**
	 * Créer une coordonnée
	 * @param ligne
	 * @param colonne
	 */
	public CoordonneesBataille(int ligne, int colonne) {
		this.ligne=ligne;
		this.colonne=colonne;
	}

	/**
	 * Renvoie la ligne de la coordonnée.
	 * @return La ligne de la coordonnée
	 */
	public int getLigne() {
		return ligne;
	}

	/**
	 * Renvoie la colonne de la coordonnée
	 * @return la colonne de la coordonnée
	 */
	public int getColonne() {
		return colonne;
	}


	/**
	 * Transforme l'entier colonne en sa lettre correspondante
	 * @return Un caractère correspondant à un nombre
	 */
	public char intToCharColonne(){
		int colonneInt=this.getColonne();
		colonneInt+=65;
		char colonneChar= (char) colonneInt;
		return colonneChar;
	}


	@Override
	public String toString() {
		return ""+(this.getLigne()+1)+""+this.intToCharColonne();
	}


	@Override
	public boolean equals(Object other){
		if (other==null){
			return false;
		}
		if (!(other instanceof CoordonneesBataille)){
			return false;
		}
		CoordonneesBataille otherAsCoBat=(CoordonneesBataille) other;
		return this.ligne==otherAsCoBat.getLigne() && this.colonne== otherAsCoBat.getColonne();
	}

	@Override
	public int hashCode(){
		return Objects.hash(this.ligne,this.colonne);
	}
}
