package com.controller;

import com.model.LeconModel;
import com.view.DialogMsg;
import com.view.LeconView;
import com.view.frame.MainWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julienleguillant on 09/06/2017.
 * Controlleur pour affectuer des lecons
 */
public class LeconController implements ActionListener{
    private LeconModel model;
    private LeconView view;
    private SessionController session;

    /**
     * Constructeur de la classe Lecon
     * @param sc La session en cours de l'utilisateur
     * @param lm Le modèle de Lecon
     * @param lv La vue de Lecon
     */
    public LeconController(SessionController sc,LeconModel lm, LeconView lv){
        this.session = sc;
        this.model = lm;
        this.view = lv;
        //add observer to refresh data and error msg
        this.model.addObserver(view.getListExos());
        this.view.getbOK().addActionListener(this);
        this.view.getbCancel().addActionListener(this);
        this.view.getLecon().addActionListener(this);
    }

    /**
     *
     * @return les données de Lecon
     */
    public LeconModel getModel() {
        return model;
    }

    /**
     *
     * @return La vue de Lecon
     */
    public LeconView getView() {
        return view;
    }

    /**
     * Permet de revenir à la session courante ou de faire un exercice
     * @param e source du bouton (Vue)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String sql = "";
        //if btn clicked and value selected in combobox
        if(e.getSource().equals(view.getLecon())){
            model.updateJList(view);
        }

        //DO an exercice
        else if(e.getSource().equals(view.getbOK())){
            if(view.getList().getSelectedIndex() != -1) {
                model.makeExercice(view);
            } else {
                DialogMsg.createDialog("Impossible","Select a valid row", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource().equals(view.getbCancel())){
            MainWindow.refresh(session.getView());
        }
    }
}
