package com.controller;

import com.model.SessionModel;
import com.model.RegisterModel;
import com.view.SessionView;
import com.view.RegisterView;
import com.view.frame.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julienleguillant on 07/06/2017.
 * Controller de la fonctionnalité pour s'enregistrer
 * Elle utilise le modèle Singleton (1 seul instance)
 */
public class RegisterController implements ActionListener {

    private RegisterController(){}
    private RegisterModel model;
    private RegisterView view;

    /**
     * constructeur de l'inscription
     * @param m Le modèle de l'inscription
     * @param v La vue de l'inscription
     */
    public RegisterController(RegisterModel m, RegisterView v){
        model = m;
        view = v;
        model.addObserver(view.getLabel());
        view.getbOk().addActionListener(this);
        view.getbCancel().addActionListener(this);
    }

    /**
     *
     * @return le modèle de l'inscription (user crée)
     */
    public RegisterModel getModel() {
        return model;
    }

    /**
     *
     * @return La vue de l'inscription
     */
    public RegisterView getView() {
        return view;
    }

    /**
     * Ecouteur des différents boutons présent sur la vue
     * @param e le bouton cliqué
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(view.getbCancel())){
            MainWindow.refresh(MenuController.getInstance().getView());
        }else{
            if(model.validUser(view)){
                SessionModel sm = new SessionModel(model.addUser());
                SessionView sv = new SessionView(sm);
                new SessionController(sm, sv);
                MainWindow.refresh(sv);

            }
        }

    }
}
