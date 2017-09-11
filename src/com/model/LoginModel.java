package com.model;

import com.DAO.DatabaseFactoryDAO;
import com.DAO.UserDAO;
import com.model.Object.User;
import com.view.LoginView;

/**
 * Created by julienleguillant on 05/06/2017.
 */
public class LoginModel extends Model{
    /**
     * attributs de login
     */
    private String username,pwd;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public String getPwd() {
        return pwd;
    }

    /**
     * Methode qui permet de vérifier que l'utilisateur existe via une requête SQL au SGBD
     * @param view Données renseignés par un utilisateur
     * @return  true = existe / false = n'existe pas
     */
    public boolean checkUser(LoginView view){
        setPwd(view.getPassword());
        setUsername(view.getUsername());
        String sql = "SELECT * FROM user WHERE username='" + getUsername() + "'" + " AND password='" + getPwd() + "'";
        return DatabaseFactoryDAO.getInstance().ExistInDB(sql);
    }

    /**
     * Methode qui permet de récuperer un utilisateur en base de données, à partir de son username
     * @return L'utilisateur trouvé en base de de données (la méthode checkUser() doit être appelé avant).
     */
    public User getUserInDB(){
        User user = new User();
        if(getUsername() != null) {
            try {
                 user = UserDAO.getInstance().findUserInDB(getUsername());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return user;
    }

    /**
     * permet de vérifier si l'utilisateur est un utilisateur ou un administrateur
     * @param user l'user à vérifier
     * @return true = existe
     */
    public boolean checkIsAdmin(User user) {
        if (user.getPseudo().equals("admin")) {
            return true;
        }else return false;
    }
}
