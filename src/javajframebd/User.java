/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javajframebd;

/**
 *
 * @author zaafr
 */
public class User {
    protected int id;
    protected String nom;
    protected String adress;
    protected gender sexe;
    

    public User(int id, String nom, String adress, gender sexe) {
        this(nom, adress);
        this.id = id;
        this.sexe=sexe;
       
    }
    public User(String nom, String adress) {
        this.nom = nom;
        this.adress = adress;
    }
      public User() {
        
    }
      public enum gender{
          homme,
          femme
      }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", nom=" + nom + ", adress=" + adress + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    
     String getClassName(){
        return this.getClass().getSimpleName();
    }
}
