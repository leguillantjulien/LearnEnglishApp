package com.model.Object;
/**
@author : julien
Permet de creer un exercice qui sera ajouté dans les conteneurs pour chacune des langues
 */
public class Exercice {

    /**
     * attributs d'un exercice
     */
    private int exercice_id;
    private String exercice_language;
    private String label;
    private String content;
    private String exercice_type;

    /**
     *
     * @param p1 l'Id de l'exercice récupéré en base de donnée (int)
     * @param p2 La langue de l'exercice (String)
     * @param p3 Le titre de l'exercice (String)
     * @param p4 Le contenu de l'exercice (String)
     * @param p5 Le type d'exercice : Vocabulaire,Grammaire.. (String)
     */
    public Exercice(int p1,String p2,String p3,String p4, String p5){
        this.exercice_id = p1;
        this.exercice_language = p2;
        this.label = p3;
        this.content = p4;
        this.exercice_type = p5;
    }

    /**
     * @return Le label (String) de l'exercice
     */
    public String getLabel() {
        return label;
    }

    /**
     * @return Le contenu (String) de l'exercice
     */
    public String getContent(){
        return this.content;
    }


}
