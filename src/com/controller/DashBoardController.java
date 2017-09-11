package com.controller;

import com.model.Object.User;
import com.view.DashBoardView;
import com.view.frame.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julienleguillant on 15/06/2017.
 */
public class DashBoardController implements ActionListener{

    /**
     * affiche les information de l'utilisateur courant en session
     */
    DashBoardView view;
    SessionController session;
    User user;

    /**
     * controller du dashboard
     * @param sc la session courante
     * @param dv la vue
     */
    public DashBoardController( SessionController sc,DashBoardView dv){
        this.view = dv;
        this.session = sc;
        this.user = sc.getModel().getUser();
        view.getReturnSession().addActionListener(this);
        updateView();
    }

    /**
     *Permet de mettre les informations de l'utilisateur dans les champs de la vue
     */
    public void updateView(){
        view.getGender().setText(user.getGenre());
        view.getLanguage().setText(user.getLangue());
        view.getOld().setText((""+user.getAge()));
        view.getUsername().setText(user.getPseudo());
        view.getPassword().setText(user.getPassword());
        view.getIsAdmin().setText((user.isAdmin()) ? "True" :"False");
    }

    /**
     *
     * @return la vue
     */
    public DashBoardView getView(){return this.view;}

    /**
     * permet de revenir au menu
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        MainWindow.refresh(session.getView());
    }
}
