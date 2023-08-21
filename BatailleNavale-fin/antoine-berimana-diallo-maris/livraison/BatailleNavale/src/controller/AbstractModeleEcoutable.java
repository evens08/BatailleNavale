/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antoine222
 */
public abstract class AbstractModeleEcoutable implements ModelEcoutable {

    private List<EcouteurModele> ecouteurs;

    public AbstractModeleEcoutable(List<EcouteurModele> ecouteurs) {
        this.ecouteurs = ecouteurs;
    }

    public AbstractModeleEcoutable() {
        this(new ArrayList());
    }

    @Override
    public void ajouterEcouteur(EcouteurModele e) {
        this.ecouteurs.add(e);
        e.modeleMisAJour(this);
    }

    @Override
    public void retraitEcouteur(EcouteurModele e) {
        this.ecouteurs.remove(e);
    }

    protected void fireChangement() {
        for (EcouteurModele e : ecouteurs) {
            e.modeleMisAJour(this);
        }
    }

}
