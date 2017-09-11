package com.model.Object;

/**
 * Classe utilisateur qui suit le modèle présent en base de donnée
 */
public class User {
    /**
     * Données membres de la classe User
     */
    private int age,user_id;
    private String pseudo;
    private String genre;
    private String langue;
    private String password;
    private boolean isAnonyme,isAdmin;

    /**
     * constructeur par défault
     */
    public User(){}

    /**
     * constructeur pour un utilisateur anonyme
     * @param anon Le type d'utilisateur (boolean)
     * @param langue La langue choisie (String)
     */
    public User(boolean anon,String langue){
        this.isAnonyme = anon;
        this.langue = langue;
    }

    /**
     * Constructeur de la classe User
     * @param p1 : identifiant unique de l'utilisateur (int)
     * @param p2 : L'age de l'utilisateur (Int)
     * @param p3 : Le pseudo de l'Utilisateur (String)
     * @param p4 : Le genre de l'Utilisateur (M/F) (String)
     * @param p5 : La Langue de l'utilisateur (String)
     * @param p6 : Le statue de l'Utilisateur (Anonyme ou non ) (boolean)
     * @param p7 : Le statue de l'Utilisateur (Admin ou non ) (boolean)
     */
    public User(int p0,int p1,String p2,String p3, String p4,String p5,boolean p6,boolean p7){
        this.user_id = p0;
        this.age = p1;
        this.pseudo = p2;
        this.password = p3;
        this.genre = p4;
        this.langue = p5;
        this.isAnonyme = p6;
        this.isAdmin = p7;
    }

    /**
     *
     * @return Liste de getters et setters pour l'utilisateur
     */
    public int getUserId() {
        return user_id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getLangue() {
        return langue;
    }

    public void setLangue(String langue) {
        this.langue = langue;
    }

    public boolean isAnonyme() {
        return isAnonyme;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setisAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }


    public int getAge() {
        return age;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getGenre() {
        return genre;
    }

    public String getPassword() {
        return password;
    }
}
