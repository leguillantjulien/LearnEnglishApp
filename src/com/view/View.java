package com.view;

import javax.swing.*;

/**
 * Created by julienleguillant on 05/06/2017.
 * classe abstraite qui défini toutes les vues en tant qu'enfant du JPanel
 */
abstract public class View extends JPanel{
    public View(){
        setVisible(true);
    }
}
