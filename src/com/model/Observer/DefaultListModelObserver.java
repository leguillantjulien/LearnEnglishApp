package com.model.Observer;

import com.model.Model;

import javax.swing.*;
import java.util.Observer;

/**
 * Created by julienleguillant on 09/06/2017.
 * permet de placer un observer sur le contenu de la liste d'exercice.
 */
public class DefaultListModelObserver extends DefaultListModel implements Observer {

    /**
     * Permet de mettre à jour le contenu du tableau via le modèle observer-observé
     * @param o Le modèle de données qui contient les nouvelles lignes à ajouter
     * @param arg //
     */
    @Override
    public void update(java.util.Observable o, Object arg) {
        Model m = (Model) o;
        addElement(m.getValeur());

    }
}
