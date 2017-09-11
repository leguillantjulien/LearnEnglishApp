package com.view.frame;

import com.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by julienleguillant on 06/06/2017.
 * La fenetre qui gére la vue "courante" (JPanel) à mettre dans le jFrame (ici)
 */

public class MainWindow extends JFrame{
    /**
     * Instance du pattern singleton utilisé pour cette classe (fiabilité)
     */
    private static MainWindow instance = new MainWindow();

    /**
     * Permet de définir la fenetre commune au projet
     * définition de l'action de fermeture de l'application avec la croix rouge
     * définir 700x600 confortable pour les données affichés
     */
    private MainWindow() {
        setTitle("App v1.01");
        setSize(700,600);
        setResizable(false);
        setJMenuBar(new JMenu());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Cette méthode permet de retourner l'instance courante (Sde l'object Window commun à toutes les classes
     * @return Le contenu de l'object JFrame
     */
    public static Container getInstance(){
        return instance.getContentPane();
    }

    /**
     * Permet de rafraichir le JPanel (vue courante) lors de la progression de l'utilisateur dans l'application
     * @param view la prochaine vue à ajouter
     */
    public static void refresh(View view){
        instance.getContentPane().removeAll();
        instance.getContentPane().add(view);
        instance.repaint();
        instance.revalidate();
        instance.setVisible(true);
    }

}
