package com.controller;

import com.model.SessionModel;
import com.model.LoginModel;
import com.model.Object.User;
import com.view.SessionView;
import com.view.LoginView;
import com.view.frame.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julienleguillant on 05/06/2017.
 * Controlleur qui permet de gerer la connexion d'un utilisateur existant
 */
public class LoginController implements ActionListener {


    private LoginModel modele;
    private LoginView view;
    private int count;

    /**
     * Constructeur privé (Singleton)
     */
    public LoginController(LoginModel lm, LoginView lv) {
        this.modele = lm;
        this.view = lv;
        this.count = 0;
        this.modele.addObserver(lv.getL3());
        view.getBCancel().addActionListener(this);
        view.getBOk().addActionListener(this);
    }

    /**
     *
     * @return la vue du singleton Login
     */
    public LoginView getView() {
        return view;
    }

    /**
     * Permet à un utilisateur de s'identifier ou de revenir à l'accueil
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getSource().equals(view.getBOk()))) {
            if(count >= 3) MainWindow.refresh(MenuController.getInstance().getView());

            if( !(view.getPassword().equals("")) && !(view.getUsername().equals(""))) {
                if (modele.checkUser(view)) {
                    User user = modele.getUserInDB();
                    if(modele.checkIsAdmin(user)){
                        user.setisAdmin(true);
                    }
                    SessionModel sm = new SessionModel(user);
                    SessionView sv = new SessionView(sm);
                    new SessionController(sm, sv);
                    MainWindow.refresh(sv);
                } else {
                    count++;
                    modele.setValeur("Bad Username or Password | try : " + count + "/3");
                }
            }
        }else MainWindow.refresh(MenuController.getInstance().getView());
    }
}