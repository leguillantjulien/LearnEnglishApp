package com.view.frame;

import com.DAO.DatabaseFactoryDAO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Created by julienleguillant on 27/05/2017.
 * La bare de menu du JFrame
 */
public class JMenu extends JMenuBar implements ActionListener{
    /**
     * Constructeur de la barre, avec 2 rubriques (file,options) et une option (Quitter)
     * Ajout de listener pour détecter l'action de fermeture de l'application par l'utilisateur
     */
    JMenuItem quitter;
    public JMenu(){
        javax.swing.JMenu file = new javax.swing.JMenu("File") ;
        javax.swing.JMenu options = new javax.swing.JMenu("Options") ;
        quitter = new JMenuItem("Quitter") ;
        options.add(quitter);
        file.add(new JMenuItem("Incomming..") );
        this.add(file);
        this.add(options);
        quitter.addActionListener(this);
    }
    /**
     * Permet d'ajouter une date de fin de la session si l'utilisateur quitte l'application sans avoir fini une session (améliore la fiabilité/sécurité de l'application)
     * @param e la source du click sur l'option Quitter (pour l'instant)
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String sql = "UPDATE Session SET session_end = '"+new Date()+"' WHERE session_end IS NULL";
        DatabaseFactoryDAO.getInstance().insertDataInDB(sql);
        System.exit(0);
    }
}
