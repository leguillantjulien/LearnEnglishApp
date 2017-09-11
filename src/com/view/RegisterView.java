package com.view;

import com.model.Object.Language;
import com.model.Observer.JLabelObserver;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julienleguillant on 29/05/2017.
 */
public class RegisterView extends View implements ActionListener{
    /**
     *
     */
    private JButton bOk,bCancel;
    private JTextField tUsername;
    private JPasswordField tpassfield;
    private JComboBox langue;
    private JSlider age;
    private JRadioButton male,female;
    private JRadioButton gender;
    private JPanel panel;
    private JLabelObserver label;

    /**
     * constructeur de la vue de l'inscription
     */
    public RegisterView() {

        panel = new JPanel();
        panel.setLayout(new GridLayout(8,2));

        // ajout de la rubrique usernmae
        panel.add(new JLabel("Username :"));
        tUsername = new JTextField(10);
        panel.add(tUsername);
        //ajout du champs password
        panel.add(new JLabel("Password :"));
        tpassfield = new JPasswordField(10);
        panel.add(tpassfield);

        //ajout du Jcombobox pour la langue
        panel.add(new JLabel("Choose a language :"));
        langue = new JComboBox();
        langue.addItem(Language.Français);
        langue.addItem(Language.English);
        langue.addItem(Language.Spanish);
        langue.addItem(Language.Italian);
        panel.add(langue);

        //ajout du bouton pour choisir le genre
        panel.add(new JLabel("Gender :"));
        JPanel panelBtn = new JPanel();
        male = new JRadioButton("male");
        female = new JRadioButton("female");
        male.addActionListener(this);
        female.addActionListener(this);
        panelBtn.add(male);
        panelBtn.add(female);
        panel.add(panelBtn);

        //ajout du slider pour l'age
        panel.add(new JLabel("Old :"));
        age = new JSlider();
        age.setMinimum(0);
        age.setMaximum(99);
        age.setValue(10);
        age.setMinorTickSpacing(5);
        age.setMajorTickSpacing(20);
        age.setPaintTicks(true);
        age.setPaintLabels(true);
        age.setLabelTable(age.createStandardLabels(10));
        panel.add(age);

        //ajout des 2 boutons d'action
        bOk = new JButton("OK");
        bCancel = new JButton("Cancel");
        panel.add(bOk);
        panel.add(bCancel);
        label = new JLabelObserver("");
        panel.add(label);
        //ajout panel dans le JPane, et visible
        add(panel);
    }

    /**
     *
     * @return Getters et setters
     */
    public JComboBox getLangue() {
        return langue;
    }

    public void setLangue(JComboBox langue) {
        this.langue = langue;
    }

    public JSlider getAge() {
        return age;
    }

    public JButton getbOk() {return bOk;}

    public JTextField getUsername() {
        return tUsername;
    }

    public JPasswordField getTpassfield() {
        return tpassfield;
    }

    public JRadioButton getMale() {
        return male;
    }

    public void setMaleState(boolean bool) {
        this.male.setSelected(bool);
    }

    public JRadioButton getFemale() {
        return female;
    }

    public void setFemaleState(boolean bool) {
        this.female.setSelected(bool);
    }

    public JButton getbCancel() {
        return bCancel;
    }

    public JLabelObserver getLabel() {
        return label;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(getMale())){
            setFemaleState(false);
        }else{
            setMaleState(false);
        }
    }
}
