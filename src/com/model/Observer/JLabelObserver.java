package com.model.Observer;

import com.model.Model;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;

/**
 * Classe qui implémente le modèle observer-observé
 */
public class JLabelObserver extends JLabel implements Observer {

	/**
	 * Création d'un JLabel
	 * @param l le texte à inserer
	 */
	public JLabelObserver(String l) {
		super(l);
	}

	/**
	 * Met à jour le text du Label
	 * @param arg0 Contient Le modèle de données
	 * @param arg1
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		Model m = (Model) arg0;
		setText(m.getValeur());
	}


}
