package com.controller;

import com.model.HistoryModel;
import com.model.LeconModel;
import com.model.SessionModel;
import com.view.*;
import com.view.frame.MainWindow;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julienleguillant on 07/06/2017.
 * Classe de la session utilisateur
 */
public class SessionController implements ActionListener{

    private SessionModel modele;
    private SessionView view;

    /**
     * constructeur de la session
     * @param sm le modèle de la session
     * @param sv la vue de la session
     */
    public SessionController(SessionModel sm, SessionView sv) {
        this.modele = sm;
        this.view = sv;
        // ajoute un observer sur le label qui contient le message d'erreur lors du traitement des données
        this.modele.addObserver(view.getLabel());
        view.getbCancel().addActionListener(this);
        view.getbLaunch().addActionListener(this);
        view.getbChangeLanguage().addActionListener(this);
        //initialise en base de données seulement pour les utilisateurs enregistrés
        if(!this.modele.getUser().isAnonyme()) {
            modele.initSession();
            view.getbHistory().addActionListener(this);
            view.getbDashBoard().addActionListener(this);
        }
    }

    /**
     *
     * @return la vue de la session courante de l'utilisateur
     */
    public SessionView getView() {
        return view;
    }

    public SessionModel getModel() {
        return modele;
    }

    /**
     * Listener d'une session
     * Permet de revenir au menu principal, d'acceder à l'historique, de changer la language principale d'un utilisateur
     * @param e La source du bouton contenu dans la vue
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource().equals(view.getbLaunch())){
            LeconController lc = new LeconController(this,new LeconModel(modele),new LeconView());
            MainWindow.refresh(lc.getView());
        }else if (e.getSource().equals(view.getbCancel())){
            // retour au menu, fin de la session
            if(!modele.getUser().isAnonyme()) {
                modele.endSession();
            }
            MainWindow.refresh(MenuController.getInstance().getView());

        }else if(e.getSource().equals(view.getbHistory())){
            // acceder à l'historique de l'utilisateur
            HistoryModel hm = new HistoryModel(modele);
            HistoryController hc = new HistoryController(this,new HistoryModel(modele),new HistoryView(hm));
            MainWindow.refresh(hc.getView());

        }else if(e.getSource().equals(view.getbChangeLanguage())){
            // permet de selectionner une nouvelle langue
            String newLanguage = new DialogMsg().generateInputDialog();
            if(newLanguage != null) {
                modele.updateSessionLanguage(newLanguage);
                modele.setValeur("Current language : "+ newLanguage);
            }
        }else if (e.getSource().equals(view.getbDashBoard())){
            //affiche les informations de l'utilisateur
            DashBoardController dc = new DashBoardController(this,new DashBoardView());
            MainWindow.refresh(dc.getView());
        }
    }
}
