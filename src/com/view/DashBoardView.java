package com.view;

import javax.swing.*;
import java.awt.*;

/**
 * Created by julienleguillant on 15/06/2017.
 * Vue qui permet d'afficher les informations de l'utilisateur
 */
public class DashBoardView extends View{
    JPanel panel;
    JLabel label,username,password,old,language,gender,isAdmin;
    JButton returnSession;

    /**
     * fabrique la vue qui récapitule les informations de l'utilisateur, à base de GridLayout et labels chargés par le controlleur
     */
    public DashBoardView(){
        username = new JLabel();
        password = new JLabel();
        old = new JLabel();
        language = new JLabel();
        gender = new JLabel();
        isAdmin = new JLabel();
        panel = new JPanel();
        panel.setLayout(new GridLayout(7,2));
        panel.add(new JLabel("Username : "));
        panel.add(username);
        panel.add(new JLabel("Password : "));
        panel.add(password);
        panel.add(new JLabel("Old : "));
        panel.add(old);
        panel.add(new JLabel("Current language : "));
        panel.add(language);
        panel.add(new JLabel("Gender : "));
        panel.add(gender);
        panel.add(new JLabel("Is Administrateur : "));
        panel.add(isAdmin);
        returnSession = new JButton("Return to session");
        panel.add(returnSession);
        add(panel);
    }

    /**
     *
     * @return getters de la vue utilisés par le constructeur
     */
    public JLabel getLabel() {
        return label;
    }

    public JLabel getUsername() {
        return username;
    }

    public void setUsername(JLabel username) {
        this.username = username;
    }

    public JLabel getPassword() {
        return password;
    }

    public void setPassword(JLabel password) {
        this.password = password;
    }

    public JLabel getOld() {
        return old;
    }

    public JLabel getLanguage() {
        return language;
    }

    public void setLanguage(JLabel language) {
        this.language = language;
    }

    public JLabel getGender() {
        return gender;
    }

    public JLabel getIsAdmin() {
        return isAdmin;
    }

    public JButton getReturnSession() {
        return returnSession;
    }

}
