package com.DAO;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/*

/*

* @startuml

* car --|> wheel

* @enduml

*/
/**
 * Created by julienleguillant on 13/06/2017.
 * Gestion des accès des historique d'un user
 */
public class HistoryDAO {

    private HistoryDAO(){}
    private static HistoryDAO instance = new HistoryDAO();
    public static HistoryDAO getInstance(){
        return instance;
    }

    /**
     *
     * @param userId l'utilisateur
     * @return La liste de sessions( gestion de la persistance) d'un user
     */
    public DefaultTableModel findAllSessionsByUser(int userId){
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id","Session's begin","Session's End","Time"}, 0);
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DatabaseFactoryDAO.getInstance().getConnection();
            Statement s = connection.createStatement();
            String sql = "SELECT * FROM Session WHERE user_id = "+userId+"";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt(1), rs.getString(3),rs.getString(4),rs.getString(5)});
            }
            rs.close();
            s.close();
        }catch (Exception e1){
            System.out.println(e1.getMessage());
        }
        return model;
    }


    /**
     *
     * @param sessionId l'id de la session
     * @return La liste d'exercice associé à une session
     */
    public DefaultTableModel findAllExercicesBySession(int sessionId){
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id session", "Exercice name", "Nb of try"}, 0);
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DatabaseFactoryDAO.getInstance().getConnection();
            Statement s = connection.createStatement();
            String sql = "SELECT * FROM exoSession WHERE id_session = "+sessionId+"";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt(1), rs.getString(2), rs.getInt(3)});
            }
            rs.close();
            s.close();
        }catch (Exception e1){
            System.out.println(e1.getMessage());
        }
        return model;
    }

    /**
     *
     * @return return la liste de toutes les sessions (gestion de l'administrateur)
     */
    public DefaultTableModel findAllSessions(){
        Connection connection = null;
        DefaultTableModel model = new DefaultTableModel(new String[]{"Id","Session's begin","Session's End","Time"}, 0);
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DatabaseFactoryDAO.getInstance().getConnection();
            Statement s = connection.createStatement();
            String sql = "SELECT * FROM Session";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                model.addRow(new Object[]{rs.getInt(1), rs.getString(3),rs.getString(4),rs.getString(5)});
            }
            rs.close();
            s.close();
        }catch (Exception e1){
            System.out.println(e1.getMessage());
        }
        return model;
    }
}
