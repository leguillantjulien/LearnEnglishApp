package com.view;

import com.model.Object.Language;

import javax.swing.*;

/**
 * Created by julienleguillant on 27/05/2017.
 */
public class DialogMsg extends JDialog {

    /**
     * Le singleton unique pour les boites de dialogue
     */
    private static DialogMsg instance = new DialogMsg();

    public DialogMsg getInstance(){return instance;}
    /**
     * Permet de créer facilement une boite de dialogue, suivant les paramètres
     * @param title Le nom de la boite de dialog (String)
     * @param txt Le contenu de la boite de dialog (String)
     * @param msg Le type de message (WARNING,DANGER..) du message (int)
     */
    public static void createDialog(String title,String txt,int msg){
        JOptionPane optionPane = new JOptionPane(txt, msg);
        JDialog dialog = optionPane.createDialog(title);
        dialog.setAlwaysOnTop(true);
        dialog.setVisible(true);
    }

    /**
     * Permet de générer une boite de dialogue pour choisir une langue, lorsque l'utilisateur souhaite acceder à l'application en mode anonyme
     * @return la langue choisie
     */
    public static String generateInputDialog(){
        String[] choices = {Language.Français.name(), Language.English.name(), Language.Spanish.name(), Language.Italian.name()};
        return (String) JOptionPane.showInputDialog(new JFrame(), "Choose your language",
                "Choice of language", JOptionPane.QUESTION_MESSAGE, null, // Use default icon
                choices, // Array of choices
                choices[1]); // Initial choice
    }
}
