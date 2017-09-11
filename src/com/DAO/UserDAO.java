package com.DAO;
import com.model.Object.User;

import java.sql.*;

/**
 * Created by julienleguillant on 08/06/2017.
 * Gestion de l'accès à la base de données pour les Users
 */
public class UserDAO {
    private UserDAO(){}
    private static UserDAO instance = new UserDAO();

    /**
     *
     * @return le singleton de la classe
     */
    public static UserDAO getInstance(){
        return instance;
    }

    /**
     *
     * @param name
     * @return return un utilisateur en fonction de son nom. Un user est return uniquement s'il existe en base de données
     */
    public User findUserInDB(String name){
        Connection connection = null;
        User user = new User();
        int user_id,age,isAdmin;
        String password,username,langue,gender;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DatabaseFactoryDAO.getInstance().getConnection();
            String sql = "SELECT * FROM user WHERE username='" + name + "'";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if (rs.next()) {
                user_id = rs.getInt(1);
                username = rs.getString(2);
                password = rs.getString(3);
                age = rs.getInt(4);
                langue = rs.getString(5);
                gender = rs.getString(6);
                isAdmin = rs.getInt(7);
                if(isAdmin == 0){
                    user = new User(user_id,age,username,password,gender,langue,false,false);
                }else{
                    user = new User(user_id,age,username,password,gender,langue,false,true);
                }
            }
            rs.close();
            s.close();
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return user;
    }

}
