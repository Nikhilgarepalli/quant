package com.example.demo.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con;

    public static void createConnection(){
        try {
           // Class.forName("org.mysql.Driver");
            con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/quant",
                    "root", "password123");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection(){
        createConnection();
        return con;
    }

    public static void closeConnection(){
        if(con!=null){
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

}
