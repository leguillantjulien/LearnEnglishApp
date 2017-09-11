package com.model;

import com.DAO.DatabaseFactoryDAO;
import com.model.Object.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by julienleguillant on 07/06/2017.
 * Modèle de données de la session
 */
public class SessionModel extends Model{
    private User user;
    private LeconModel l;
    private Date begin,end;
    private String time;

    /**
     * constructeur de la session
     * @param u prend un user en paramètre
     */
    public SessionModel(User u){
        this.user = u;
        this.begin = new Date();

    }

    /**
     *
     * @return l'utilisateur de la session en cours (User)
     */
    public User getUser() {
        return user;
    }

    /**
     *
     * @return le début de la session (Date)
     */
    public Date getDebut() {
        return begin;
    }


    /**
     * Permet d'insérer dans la base de données une nouvelle session, avec l'id de l'utilisateur et le début de la session (Date)
     */
    public void initSession(){
        String sql = "INSERT INTO Session (user_id,session_begin) VALUES ("+user.getUserId()+",'"+this.begin+"');";
        DatabaseFactoryDAO.getInstance().insertDataInDB(sql);
    }

    /**
     * permet de cloturer une session dans la base de données. une date de fin, et la durée de la session (fin-début) est updater dans la base de données, pour la session
     */
    public void endSession(){
        this.end = new Date();
        long timeDiff = Math.abs(this.end.getTime() - this.begin.getTime());
        this.time = String.format("%d hour(s) %d min(s) %d sec(s)", TimeUnit.MILLISECONDS.toHours(timeDiff),
                TimeUnit.MILLISECONDS.toMinutes(timeDiff) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(timeDiff)),
                TimeUnit.MILLISECONDS.toSeconds(timeDiff) - TimeUnit.MILLISECONDS.toMinutes((TimeUnit.MILLISECONDS.toMinutes(timeDiff))));
        String sql = "UPDATE Session SET session_end = '"+this.end+"', time = '"+this.time+"' WHERE session_begin='"+this.begin+"' AND user_id ='"+user.getUserId()+"'";
        DatabaseFactoryDAO.getInstance().insertDataInDB(sql);
    }

    /**
     *
     * @return l'id de la session en cours, via un appel en base de données
     */
    public int getSessionId(){
        Connection connection = null;
        int id = 0;
        try{
            Class.forName("org.sqlite.JDBC");
            connection = DatabaseFactoryDAO.getInstance().getConnection();
            String sql = "SELECT id FROM Session WHERE session_begin = '"+this.getDebut()+"' AND user_id ="+user.getUserId()+"";
            Statement s = connection.createStatement();
            ResultSet rs = s.executeQuery(sql);
            if(rs.next()) {
                 id = rs.getInt(1);
            }
            rs.close();
            s.close();
        }catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
        return id;
    }

    /**
     * Met à jour dans la base de donnée la langue choisie par l'utilisateur
     * @param langue (String)
     */
    public void updateSessionLanguage(String langue){
        this.getUser().setLangue(langue);
        String sql = "UPDATE user SET langue = '"+getUser().getLangue()+"' WHERE user_id = '"+getUser().getUserId()+"'";
        DatabaseFactoryDAO.getInstance().insertDataInDB(sql);
    }


}
