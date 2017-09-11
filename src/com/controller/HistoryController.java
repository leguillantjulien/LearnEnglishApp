package com.controller;

import com.model.HistoryModel;
import com.view.DialogMsg;
import com.view.HistoryView;
import com.view.frame.MainWindow;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julienleguillant on 12/06/2017.
 * Cette classe est le controleur pour la fonctionnalité d'historique
 */
public class HistoryController implements ActionListener{

    private HistoryModel model;
    private HistoryView view;
    private SessionController session;

    /**
     * constructeur de la classe
     * @param sc La session en cours de l'utilisateur qui souhaite voir son historique
     * @param hm Le modèle de l'historique
     * @param hv La vue de l'historique
     */
    public HistoryController(SessionController sc, HistoryModel hm,HistoryView hv) {
        this.session = sc;
        this.model = hm;
        this.view = hv;
        view.getBtnSelect().addActionListener(this);
        view.getBack().addActionListener(this);
    }

    /**
     *
     * @return permet de retourner les données de l'historique courant
     */
    public HistoryModel getModel() {
        return model;
    }

    /**
     *
     * @return retourne la vue de l'historique
     */
    public HistoryView getView() {
        return view;
    }

    /**
     *  Ecouteur des actions possible par l'utilisateur
     * @param e la source de l'évenement (dans la vue)
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(view.getBack())){
            MainWindow.refresh(session.getView());
        }else if(e.getSource().equals(view.getBtnSelect())){

            if(view.getBtnSelect().getText().equals("See selected row")){
                if(view.getTab().getSelectedRow() >= 0 && (int) view.getTab().getValueAt(view.getTab().getSelectedRow(), 0) > 0) {
                    model.setSessionId((int) view.getTab().getValueAt(view.getTab().getSelectedRow(), 0));
                    model.setTableModelExercice();
                    view.setTab(model.getDefaultTableModel());
                    view.setBtnSelect("Return to session list");
                }else{
                    DialogMsg.createDialog("Impossible","Please choose a valid row", JOptionPane.WARNING_MESSAGE);
                }
            }else if (view.getBtnSelect().getText().equals("Return to session list")){
                model.setTableModelSession();
                view.setTab(model.getDefaultTableModel());
                view.setBtnSelect("See selected row");
            }
        }
    }
}
