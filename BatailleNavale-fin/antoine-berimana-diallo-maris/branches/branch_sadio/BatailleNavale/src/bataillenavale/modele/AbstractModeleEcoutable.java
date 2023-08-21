package bataillenavale.modele;
import java.util.ArrayList;

import bataillenavale.controleur.*;


public abstract class AbstractModeleEcoutable implements ModeleEcoutable {
	
	private  ArrayList<EcouteurModele> ecouteurs = new ArrayList<>();

	/*
	public AbstractModeleEcoutable(List<EcouteurModele> ecouteurs) {
		
		this.ecouteurs = ecouteurs;
	}
	
    public AbstractModeleEcoutable() {
		this(new ArrayList<>());
	}*/
	
	@Override
	public void ajoutEcouteur(EcouteurModele e) {
		this.ecouteurs.add(e);
	}
	@Override
	public void retraitEcouteur(EcouteurModele e) {
		this.ecouteurs.remove(e);
	}
	
	
	public void fireChangement() {
		for(EcouteurModele e : ecouteurs) {
			e.modeleMisAjour(this);
		}
	}
	
}
