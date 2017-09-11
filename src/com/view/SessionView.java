package com.view;
import com.model.Observer.JLabelObserver;
import com.model.SessionModel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Created by julienleguillant on 07/06/2017.
 * Vue de la session
 */
public class SessionView extends View {
    JLabelObserver label;
    JButton bLaunch,bCancel,bHistory,bChangeLanguage,bDashBoard;

    /**
     * Constructeur de la vue de la session
     * @param model
     */
    public SessionView(SessionModel model){

        //configuration du layout
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        setBackground(Color.decode("#3498db"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //label definition
        JLabel userLabel = new JLabel();
        userLabel.setForeground(Color.white);
        userLabel.setHorizontalAlignment(SwingConstants.CENTER);
        if(!model.getUser().isAnonyme()){
            userLabel.setText("Welcome " + model.getUser().getPseudo());
        }else {
            userLabel.setText("Welcome Anonymous User");
        }
        add(userLabel,gbc);
        label = new JLabelObserver("Current language : " + model.getUser().getLangue());
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.white);
        add(label,gbc);

        //button definition
        bChangeLanguage = new JButton("Change Language");
        bChangeLanguage.setPreferredSize(new Dimension(250, 50));
        bLaunch = new JButton("Launch a Lesson");
        bLaunch.setPreferredSize(new Dimension(200, 50));
        bCancel = new JButton("Return to Home / Finish the session");
        bCancel.setPreferredSize(new Dimension(250, 50));
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(Color.decode("#3498db"));
        if(!model.getUser().isAnonyme()){
            bDashBoard = new JButton("Display user informations");
            bDashBoard.setPreferredSize(new Dimension(250, 50));
            bHistory = new JButton("Display sessions history");
            bHistory.setPreferredSize(new Dimension(250, 50));
            buttons.add(bHistory, gbc);
            buttons.add(bDashBoard, gbc);
        }
        buttons.add(bChangeLanguage,gbc);
        buttons.add(bLaunch, gbc);
        buttons.add(bCancel, gbc);
        gbc.weighty = 1;
        add(buttons, gbc);
    }

    /**
     *
     * @return getters de session
     */
    public JButton getbLaunch() {
        return bLaunch;
    }

    public JButton getbCancel() {
        return bCancel;
    }

    public JButton getbHistory() {
        return bHistory;
    }

    public JButton getbChangeLanguage() {
        return bChangeLanguage;
    }

    public JButton getbDashBoard() {
        return bDashBoard;
    }

    public JLabelObserver getLabel() {
        return label;
    }

}
