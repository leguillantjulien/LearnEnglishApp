package com.model;

import java.util.Observable;

/**
 * Created by julienleguillant on 06/06/2017.
 * Classe abstraite qui est commune à tous les composants de la couche Model
 * Elle implémente le modèle observeur-observé
 */
abstract public class Model extends Observable {
    String valeur;

    /**
     * la valeur de l'objet Observer
     * @return la valeur du champs écouté
     */
    public String getValeur() {
        return valeur;
    }

    /**
     * Permet d'updater une nouvelle valeur (String) pour les JLabel,JTableModel des différentes vues
     * @param valeur le nouveau (String) à remplacer
     */
    public void setValeur(String valeur) {
        this.valeur = valeur;
        this.setChanged();
        this.notifyObservers();
    }
}
