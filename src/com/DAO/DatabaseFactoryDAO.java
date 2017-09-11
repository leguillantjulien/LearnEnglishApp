package com.DAO;

import java.sql.*;

/**
 * Created by julienleguillant on 09/06/2017.
 * Permet de se connecter à la base de donnée et d'effectuer des requête
 */
public class DatabaseFactoryDAO {

    private DatabaseFactoryDAO(){}
    private static DatabaseFactoryDAO instance = new DatabaseFactoryDAO();

    /**
     * Singleton qui permet d'acceder à l'instance de l'unique DAO
     * @return
     */
    public static DatabaseFactoryDAO getInstance(){
        return instance;
    }

    /**
     * Methode permettant d'établir le lien avec la base de données
     * @return La connexion avec la base de données
     */
    public static Connection getConnection(){
        Connection connection = null;
        if (connection == null){
            try {
                connection = DriverManager.getConnection(
                        "jdbc:sqlite::resource:db/java.sqlite3");
            } catch (SQLException ex) {
                System.out.println ("SQLException: " + ex.getMessage());
                System.out.println ("SQLState: " + ex.getSQLState());
                System.out.println ("VendorError: " + ex.getErrorCode());
            }
        }
        return connection;
    }

    /**
     * Methode permettant d'effectuer des requêtes sur la base de données
     * @param requeteSQL la requête SQL à executer
     */
    public void insertDataInDB(String requeteSQL){
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = getConnection();
            Statement s = connection.createStatement();
            s.executeUpdate(requeteSQL);
            s.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    /**
     * Permet de vérifier si une requête
     * @param requeteSQL
     * @return true = existe en base, false = non trouvé
     */
    public boolean ExistInDB(String requeteSQL) {
        Connection connection = null;
        boolean response = false;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = getConnection();
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(requeteSQL);
            if (rs.next()) {
                response = true;
            } else {
                response = false;
            }
            rs.close();
            s.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return response;
    }
}
