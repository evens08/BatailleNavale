package bataillenavale.modele;


public class TirLoupee extends PieceBateau{
        public TirLoupee(int ligne, int colonne) {
                super(ligne, colonne);
                super.etatCourant=3;
        }
        @Override
        public void changerEtat(){}
}