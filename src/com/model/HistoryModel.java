package com.model;

import com.DAO.HistoryDAO;
import com.model.Object.User;

import javax.swing.table.DefaultTableModel;

/**
 * Created by julienleguillant on 10/06/2017.
 * Modèle de l'historique
 */
public class HistoryModel {
    private User user;
    private int sessionId,userId;
    private DefaultTableModel tab;

    /**
     * Le modèle de l'historique
     * @param session est initialisé par la session d'un utilisateur.
     */
    public HistoryModel(SessionModel session){
        this.user = session.getUser();
        this.sessionId = session.getSessionId();
        this.userId = session.getUser().getUserId();
        setTableModelSession();
        tab = getDefaultTableModel();
    }

    /**
     *
     * @return l'id de la session courante
     */
    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    /**
     *
     * @return le tableau qui contient la liste des éléments
     */
    public DefaultTableModel getDefaultTableModel() {
        return tab;
    }

    /**
     * Permet d'initialisé l'historique, selon s'il est un administrateur ou un user standard.
     */
    public void setTableModelSession(){
        if(user.isAdmin()) {
            tab = HistoryDAO.getInstance().findAllSessions();
        }else{
            tab = HistoryDAO.getInstance().findAllSessionsByUser(getUserId());

        }
    }

    /**
     * Permet d' "update" le contenu du tableau, en remplacant la liste des sessions par la liste des exercices associé à la session
     */
    public void setTableModelExercice(){
            tab = HistoryDAO.getInstance().findAllExercicesBySession(getSessionId());
    }

}
