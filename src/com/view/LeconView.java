package com.view;

import com.model.Object.Lecon;
import com.model.Observer.DefaultListModelObserver;

import javax.swing.*;
import java.awt.*;

/**
 * Created by julienleguillant on 09/06/2017.
 * La vue de la lecon
 */
public class LeconView extends View {
    JPanel panel;
    JComboBox lecon;
    JList list;
    DefaultListModelObserver listExos;
    JButton bOK,bCancel;

    /**
     * Création du constructeur de la vue lecon
     */
    public LeconView(){
        // définition d'un gridLayout pour les informations affichés
        setLayout(new GridLayout(4,2));
        panel = new JPanel();

        // définition d'un JCombobox qui contient la liste des types d'exercices possible
        lecon = new JComboBox();
        lecon.addItem("Choose a type of exercice");
        lecon.addItem(Lecon.Vocabulaire);
        lecon.addItem(Lecon.Grammaire);
        lecon.addItem(Lecon.Conjugaison);
        lecon.addItem(Lecon.Orthographe);

        // les exercices chargés via le modele
        listExos = new DefaultListModelObserver();
        list = new JList(listExos);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSize(300,300);

        // 2 boutons pour faire un exercice et revenir à la session
        bOK = new JButton("OK");
        bCancel = new JButton("Cancel");
        add(new JLabel("Type of exercice : "));
        add(lecon);
        add(new JLabel("List of exercice : "));
        add(list);
        JPanel panel3 = new JPanel();
        panel3.add(bOK);
        panel3.add(bCancel);
        add(panel3);
    }

    /**
     * getter et setters pour récupérer la source de l'action (utilisé par le controller et le modele)
     * @return informations de la vue
     */
    public JComboBox getLecon() {
        return lecon;
    }

    public JList getList() {
        return list;
    }

    public DefaultListModelObserver getListExos() {
        return listExos;
    }

    public JButton getbOK() {
        return bOK;
    }

    public JButton getbCancel() {
        return bCancel;
    }

}
