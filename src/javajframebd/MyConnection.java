/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javajframebd;

import static java.lang.Class.forName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author zaafr
 */
public class MyConnection {
    
    Statement stm=null;
    private Connection connection;
    private String serverURI="com.mysql.jdbc.Driver";
    
    public MyConnection() throws SQLException{
        try {
            connection=connexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    Connection connexion() throws SQLException, ClassNotFoundException{
        Class.forName(serverURI);
        String password = System.getProperty("database.password");
        connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/tp4_swing", "root", password);
        return connection;
    }
    
     void createTable(String tableName) throws SQLException {

    
    String sqlCreate = "CREATE TABLE IF NOT EXISTS "+tableName+" ("
            + "id INT UNSIGNED NOT NULL AUTO_INCREMENT,"
            + "nom VARCHAR(50) NULL DEFAULT NULL,"
            + "adresse VARCHAR(50) NULL DEFAULT NULL,"
            + "sexe ENUM ('femme','homme'), "
            + "PRIMARY KEY (id),"
            + "UNIQUE INDEX id (id)"
            + ")"
            + "COLLATE='latin1_swedish_ci';";


    Statement stm = connection.createStatement();
    stm.execute(sqlCreate);
}

    
       void addUser( User personne) throws SQLException {
           String table=personne.getClassName();
           createTable(table);

        stm=connection.createStatement();
        String req="";
        req="insert into "+table+"(nom,adresse)values('"+personne.nom+"','"+personne.adress+"')";
        System.out.println(req);
        stm.executeUpdate(req);
    }
    
    void updateUser( User personne, String table) throws SQLException {
        stm=connection.createStatement();
        String req="";
        req="update "+table+" set nom= "+personne.nom+",adress="+personne.adress+"where id="+personne.id;
        stm.executeUpdate(req);
    }
       
         void deleteUser( User personne, String table) throws SQLException {
        stm=connection.createStatement();
        String req="";
        req="delete from "+table+"where id="+personne.id;
        stm.executeUpdate(req);
    }
}