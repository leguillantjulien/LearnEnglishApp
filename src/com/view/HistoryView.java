package com.view;

import com.model.HistoryModel;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by julienleguillant on 29/05/2017.
 */
public class HistoryView extends View{

    private HistoryModel HistoryModel;
    private JTable tab;
    private JScrollPane scrollPane;
    private DefaultTableModel model;
    private JButton back;
    private JButton btnSelect;
    private JPanel panel;

    public HistoryView(HistoryModel hm) {
        HistoryModel = hm;
        model = HistoryModel.getDefaultTableModel();
        createHistory();
    }

    private void createHistory(){
        setLayout(new BorderLayout());
        btnSelect = new JButton("See selected row");
        back = new JButton("Return to Session");
        ListSelectionModel selectionModel = new DefaultListSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tab = new JTable(model);
        tab.setDefaultEditor(Object.class, null);
        tab.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane = new JScrollPane(tab);
        panel = new JPanel();
        panel.add(back);
        panel.add(btnSelect);
        add(scrollPane,BorderLayout.NORTH);
        add(panel,BorderLayout.SOUTH);

    }

    public JTable getTab() {
        return tab;
    }

    public void setTab(DefaultTableModel content) {
        tab.setModel(content);
    }

    public JButton getBack() {
        return back;
    }

    public JButton getBtnSelect(){
        return btnSelect;
    }

    public void setBtnSelect(String value){
        btnSelect.setText(value);
    }

}

