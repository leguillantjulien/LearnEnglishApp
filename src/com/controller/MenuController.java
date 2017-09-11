package com.controller;
import com.model.*;
import com.model.Object.User;
import com.view.*;
import com.view.frame.MainWindow;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * Created by julienleguillant on 27/05/2017.
 * Controlleur du menu
 */
public class MenuController implements ActionListener{

    private MenuController(){}
    private MenuView mv;
    private static MenuView view = new MenuView();
    private static MenuController instance = new MenuController(view);

    /**
     * Constructeur du menu
     * @param v La vue du menu
     * Ajoute des listener qui permettent de déterminer l'action de l'utilisateur
     */
    private MenuController(MenuView v) {
        this.mv = v;
        v.getB0().addActionListener(this);
        v.getB1().addActionListener(this);
        v.getB2().addActionListener(this);
        v.getB3().addActionListener(this);
    }


    /**
     *
     * @return l'instance du singleton menu
     */
    public static MenuController getInstance(){
        return instance;
    }

    /**
     *
     * @return la vue du menu
     */
    public MenuView getView() {
        return this.mv;
    }

    /**
     * Listener qui gère les actions utilisateur
     * @param e La source du bouton, converti (int)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        int action = Integer.parseInt(e.getActionCommand());
        switch (action){
            case 0:
                RegisterController rc = new RegisterController(new RegisterModel(),new RegisterView());
                MainWindow.refresh(rc.getView());
                break;
            case 1:
                LoginController lc = new LoginController(new LoginModel(),new LoginView());
                MainWindow.refresh(lc.getView());
                break;
            case 2:
                String language = new DialogMsg().generateInputDialog();
                if(language != null) {
                    User user = new User(true, language);
                    SessionModel sm = new SessionModel(user);
                    SessionController sc = new SessionController(sm, new SessionView(sm));
                    MainWindow.refresh(sc.getView());
                }
                break;
            case 3:
                System.exit(0);
                break;
        }
    }
}