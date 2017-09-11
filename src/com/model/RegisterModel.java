package com.model;

import com.DAO.DatabaseFactoryDAO;
import com.DAO.UserDAO;
import com.model.Object.User;
import com.view.RegisterView;

/**
 * Created by julienleguillant on 07/06/2017.
 * Modèle de données de l'inscription, extend de la classe abstraite Model
 *
 */
public class RegisterModel extends Model{
    private String username,password,language,genre;
    private int old;
    private boolean isAnonyme;

    /**
     * getter et setters des attributs de l'inscription
     * @return getters/setters
     */
    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Permet de vérifier que les informations qu'a renseigné l'utilisateur sont bon
     * @param view les informations contenu dans la vue
     * @return true = l'utlisateur est valide , false = l'utilisateur ne respecte pas les conditions de l'inscription
     */
    public boolean validUser(RegisterView view){
        if(getViewInformations(view) && checkInformations()){
            return true;
        }else{return false;}
    }

    /**
     * Permet d'ajouter l'utilisateur en base de données
     * @return l'utilisateur crée
     */
    public User addUser(){
        User user = new User();
            try {
                String sql = "INSERT INTO user (username,password,age,langue,genre,isAdmin)" +
                        "VALUES ('" + getUsername() + "','" + getPassword() + "','" + getOld() + "','" + getLanguage() + "','" + getGenre() + "',"+0+");";
                DatabaseFactoryDAO.getInstance().insertDataInDB(sql);
                user = UserDAO.getInstance().findUserInDB(getUsername());
            }catch (Exception e){
                System.out.println("error in database");
            }
        return user;
    }

    /**
     * Permet d'obtenir les informations renseigné par l'utilisateur, à partir des données de la vue
     * @param view la vue de l'inscription
     * @return true = correct Vue information
     */
    public boolean getViewInformations(RegisterView view){
        boolean valid = false;
        setLanguage(view.getLangue().getSelectedItem().toString());
        if(!this.isAnonyme) {
            setPassword(String.valueOf(view.getTpassfield().getPassword()));
        }
        setUsername(view.getUsername().getText());
        setOld(view.getAge().getValue());
        if (view.getMale().isSelected() && view.getFemale().isSelected()) {
            setValeur("You can't select 2 gender !");
        } else if (!view.getMale().isSelected() && !view.getFemale().isSelected()) {
            setValeur("You must choose a gender");
        } else {
            if (view.getMale().isSelected()) {
                setGenre("M");
            } else if (view.getFemale().isSelected()) {
                setGenre("F");
            }
            valid = true;
        }
        return valid;
    }

    /**
     * Permet de vériier qu'un utilisateur avec le même username n'existe pas en base de données
     * @return true = the user is OK
     */
    public boolean checkInformations(){
        boolean response = false;
        String sql = "SELECT * FROM user WHERE username='" + getUsername() + "'";
        if(getUsername().length() >= 4 && getUsername().length() < 20 && !DatabaseFactoryDAO.getInstance().ExistInDB(sql)){
            if(getPassword().length() >= 4 && getPassword().length() < 20 && !getUsername().equals("null")){
                if(getOld() > 13 && getOld() < 99){
                    response = true;
                }else setValeur("Old must be > 13 and < 99");
            }else setValeur("Bad Password");
        }else setValeur("Bad Username");
        return response;
    }

}