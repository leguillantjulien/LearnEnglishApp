package com.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by julienleguillant on 27/05/2017.
 * Vue du Menu Principale
 */
public class MenuView extends View{

    JButton b0,b1,b2,b3;
    JLabel l0;

    /**
     * constructeur de la vue du menu
     */
    public MenuView(){

        // définition de la structeur de la vue
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#3498db"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        l0 = new JLabel("Welcome on this app to learn foreign languages",SwingConstants.CENTER);
        l0.setForeground(Color.white);
        add(l0, gbc);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ajout des 4 boutons
        JPanel buttons = new JPanel(new GridBagLayout());
        b0 = new JButton("Create an account");
        b0.setPreferredSize(new Dimension(250, 50));
        b1 = new JButton("Loggin a session");
        b1.setPreferredSize(new Dimension(250, 50));
        b2 = new JButton("Use this app without an account");
        b2.setPreferredSize(new Dimension(250, 50));
        b3 = new JButton("Close the application");
        b3.setPreferredSize(new Dimension(250, 50));

        // définition d'un int pour chaque bouton
        b0.setActionCommand("0");
        b1.setActionCommand("1");
        b2.setActionCommand("2");
        b3.setActionCommand("3");

        // ajouts boutons dans le containeur de bouton
        buttons.setBackground(Color.decode("#3498db"));
        buttons.add(b0, gbc);
        buttons.add(b1, gbc);
        buttons.add(b2, gbc);
        buttons.add(b3, gbc);

        gbc.weighty = 1;
        add(buttons, gbc);

    }

    /**
     *
     * @return getters pour récupérer la source de l'évenement
     */
    public JButton getB0() {
        return b0;
    }

    public JButton getB1() {
        return b1;
    }

    public JButton getB2() {
        return b2;
    }

    public JButton getB3() {
        return b3;
    }
}
