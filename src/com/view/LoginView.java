package com.view;

import com.model.Observer.JLabelObserver;

import javax.swing.*;
import java.awt.*;

/**
 * Created by julienleguillant on 27/05/2017.
 * Vue du JPanel de connexion
 * Extend de la classe View
 */
public class LoginView extends View{

    JButton bOk,bCancel;
    JLabel l0,l1;
    JLabelObserver l3;
    JTextField t0;
    JPasswordField t1;
    JPanel panel;

    /**
     * constructeur de la vue
     */
    public LoginView(){
        //ajout du panel qui contient les 2 boutons, et les labels/textfields
        panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        l0 = new JLabel("Username :");
        t0 = new JTextField(10);
        l1 = new JLabel("Password :");
        t1 = new JPasswordField(10);
        bOk = new JButton("OK");
        bCancel = new JButton("Cancel");
        l3 = new JLabelObserver("");
        panel.add(l0);
        panel.add(t0);
        panel.add(l1);
        panel.add(t1);
        panel.add(bOk);
        panel.add(bCancel);
        panel.add(l3);
        add(panel);
    }

    /**
     *
     * @return getters et setters de la vue
     */
    public String getUsername() {
        return t0.getText();
    }

    public String getPassword() {
        return String.valueOf(t1.getPassword());
    }

    public JButton getBOk() {
        return bOk;
    }

    public JButton getBCancel() {
        return bCancel;
    }

    public JLabelObserver getL3() {
        return l3;
    }

    public JTextField getT0() {
        return t0;
    }

}
