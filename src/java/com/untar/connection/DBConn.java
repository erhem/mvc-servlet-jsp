/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.untar.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

/**
 *
 * @author erhem
 */
public class DBConn {
    
    private Connection connection = null;
    
    public DBConn() throws ClassNotFoundException, SQLException {
        //Step 1
        Class.forName("org.postgresql.Driver");
        
        //Step 2
        String host = "localhost";
        String dbName = "MVCPractice";
        int port = 5432;
        String urlConnection = "jdbc:postgresql://" +  host + ":" 
                + port + "/" + dbName;
        
        //Step 3
        String username = "postgres";
        String password = "root";
        connection = DriverManager.getConnection(urlConnection, username, password);
        connection.setAutoCommit(false);
        System.out.println("Connection successful");
    }
    
    public Connection getConn() {
        return this.connection;
    }
    
    public void closeConn() {
        if(connection != null) {
            try {
                connection.close();
                System.out.println("Connection closed");
            } catch(SQLException ex) {
                java.util.logging.Logger.getLogger(DBConn.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
