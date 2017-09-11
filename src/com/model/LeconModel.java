package com.model;

import com.DAO.DatabaseFactoryDAO;
import com.DAO.ExerciceDAO;
import com.model.Object.Exercice;
import com.view.DialogMsg;
import com.view.LeconView;
import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by julienleguillant on 09/06/2017.
 * Modèle de la classe lecon
 */
public class LeconModel extends Model {
    private SessionModel currentSession;



    /**
     *
     * @param sessionModel Permet d'initialiser le modèle de la leçon à partir des données de la session
     */
    public LeconModel(SessionModel sessionModel){
        this.currentSession = sessionModel;
    }

    /**
     *
     * @return la session courante
     */
    public SessionModel getSession() {
        return currentSession;
    }

    /**
     * Methode qui permet de selectionner un exercice de la sesson
     * @param view view la vue qui contient les données renseignées par l'utilisateur
     */
    public void updateJList(LeconView view){

        if(view.getLecon().getSelectedIndex() != 0) {
            view.getListExos().removeAllElements();
            String currentType = view.getLecon().getSelectedItem().toString();
            String language = currentSession.getUser().getLangue();
            ArrayList<Exercice> listExercice = ExerciceDAO.getInstance().findExercicesByLanguageAndType(language, currentType);
            for (int i = 0; i < listExercice.size(); i++) {
                setValeur(listExercice.get(i).getLabel());
            }
        }else{
            DialogMsg.createDialog("Impossible","Select a valid type of exercice",JOptionPane.ERROR_MESSAGE);
            view.getListExos().removeAllElements();
        }
    }

    /**
     * Methode permettant de "simuler" un exercice, puis d'ajouter la réalisation de l'exercice dans la base de données
     * @param view la vue qui contient les données renseignées par l'utilisateur
     */
    public void makeExercice(LeconView view){
        String sql = "";
        String exerciceName = view.getList().getSelectedValue().toString();
        int session_id = this.getSession().getSessionId();
        if(session_id != 0 && !getSession().getUser().isAnonyme()) {
            sql = "SELECT * FROM exoSession WHERE id_session='" + session_id + "' AND exercice_name='" + exerciceName + "'";
            if (DatabaseFactoryDAO.getInstance().ExistInDB(sql)) {
                sql = "UPDATE exoSession SET nb_do= nb_do+1 WHERE id_session='" + session_id + "' AND exercice_name='" + exerciceName + "'";
                DatabaseFactoryDAO.getInstance().insertDataInDB(sql);
            } else {
                sql = "INSERT INTO exoSession VALUES ('" + session_id + "','" + exerciceName + "','1');";
                DatabaseFactoryDAO.getInstance().insertDataInDB(sql);
            }
        }
        DialogMsg.createDialog("Congratulation !","This exercice is done", JOptionPane.INFORMATION_MESSAGE);

    }

}
