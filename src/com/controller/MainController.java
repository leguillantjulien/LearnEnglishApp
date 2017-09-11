package com.controller;

import com.DAO.DatabaseFactoryDAO;
import com.view.frame.MainWindow;

import java.util.Date;

/**
 * Created by julienleguillant on 27/05/2017.
 */
public class MainController {

    public MainController() {}


    /**
     * Début du programme
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            // charge par défault le menu
            public void run() {
                MainWindow.getInstance().add(MenuController.getInstance().getView());
                MainWindow.getInstance().setVisible(true);
            }
        });
        //permet de définir la fin de la session si l'utilisateur quitte l'application via la croix rouge
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                String sql = "UPDATE Session SET session_end = '"+new Date()+"' WHERE session_end IS NULL";
                DatabaseFactoryDAO.getInstance().insertDataInDB(sql);
            }
        }, "Shutdown-thread"));
    }
}