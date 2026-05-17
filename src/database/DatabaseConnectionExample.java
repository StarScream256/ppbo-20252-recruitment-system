/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author asus
 */
public class DatabaseConnectionExample {
    private static final String DB_USERNAME = ""; // ganti sesuai kredensial anda
    private static final String DB_PASSWORD = ""; // ganti sesuai kredensial anda
    private static final String DB_URL = "jdbc:mysql://localhost:3306/recruit_db";
    
    private static Connection connection;
    public static Connection getConnection() {
        if (connection == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                System.out.println("[SUCCESS]-[DB]-[CONNECTION] Connected to " + DB_URL + " sucessfully");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println("[ERROR]-[DB]-[CONNECTION] Connection failed to " + DB_URL);
                e.printStackTrace();
            }
        }
        return connection;
    }
}
