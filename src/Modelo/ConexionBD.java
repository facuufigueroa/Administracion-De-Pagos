/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Facundo
 */
public class ConexionBD {
    
    
    public static final String URL = "jdbc:mysql://localhost:3306/mataderobragado";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "mataderobragado";
    Connection con = null;
    static Connection conn = null;
    
    public static Connection getConn(){
        return conn;
    }
    
    public Connection getConnection(){
        
        try{
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =(Connection) DriverManager.getConnection(this.URL,this.USERNAME,this.PASSWORD);
            
        }catch(Exception e){
            System.out.println(e);
            
        }
        return con;
    }

}
