/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parkir.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DBkoneksi {
    private static Connection connection;

    public static Connection getConnection() {
        if(connection==null){
            try {
                String url = "jdbc:mysql://localhost:3306/sistem_parkir";
                String usr = "root";
                String pwd = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                connection=DriverManager.getConnection(url, usr, pwd);
            } catch (SQLException ex) {
                Logger.getLogger(DBkoneksi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connection;
    }
    
}

