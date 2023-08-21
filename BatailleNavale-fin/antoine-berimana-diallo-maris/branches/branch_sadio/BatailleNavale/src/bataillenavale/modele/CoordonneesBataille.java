
package bataillenavale.modele;
public class CoordonneesBataille {
        
        private int ligne,colonne;
        
        public CoordonneesBataille(int ligne, int colonne) {
                this.ligne=ligne;
                this.colonne=colonne;
        }
        public int getLigne() {
                return ligne;
        }
        public int getColonne() {
                return colonne;
        }
        public String getCoord() {
                return "("+this.ligne+","+this.colonne+")";
        }
        public char intToChar(int colonneInt){
                colonneInt+=65;
                char colonneChar= (char) colonneInt;
                return colonneChar;
        }
        @Override
        public String toString() {
                return ""+(this.getLigne()+1)+this.intToChar(this.getColonne());
        }
}