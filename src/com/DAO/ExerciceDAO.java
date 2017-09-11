package com.DAO;

import com.model.Object.Exercice;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by julienleguillant on 09/06/2017.
 */
public class ExerciceDAO {

    /**
     * @return l'instance de l'object DAO d'exercice
     */
    private static ExerciceDAO instance = new ExerciceDAO();

    public static ExerciceDAO getInstance(){
        return instance;
    }

    /**
     * Premet de retrouver en base la liste des exercices disponible en fonction de la langue et du type d'exercice demandé
     * @param language
     * @param type
     * @return liste d'exercice
     */
    public ArrayList<Exercice> findExercicesByLanguageAndType(String language, String type){
        Connection connection = null;
        ArrayList<Exercice> exercicesTab = new ArrayList<>();
        String languageEx,exercice_name,exercice_content,exercice_type;
        int id;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DatabaseFactoryDAO.getInstance().getConnection();
            String sql = "SELECT * FROM exercice WHERE language='" + language + "' AND exercice_type='"+ type+"' ";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()) {
                id = rs.getInt(1);
                languageEx = rs.getString(2);
                exercice_name = rs.getString(3);
                exercice_content = rs.getString(4);
                exercice_type = rs.getString(5);
                exercicesTab.add(new Exercice(id,languageEx,exercice_name,exercice_content,exercice_type));
            }
            rs.close();
            s.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return exercicesTab;
    }
}
