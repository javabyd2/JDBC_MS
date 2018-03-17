package com.sda.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectorNew {
    private static Connection connection = null;
    private final static String ADDRESS = "jdbc:mysql://127.0.0.1";
    private final static String DATABASE = "rental_db";
    private final static String USER = "root";
    private final static String PASSWORD = "canoe261";
    private final static String PORT = "3306";
    private final static String DRIVER = "com.mysql.cj.jdbc.Driver";
    private final static String PARMAS = "useSSL=false&serverTimezone=UTC";


    private static void loadDriver() {      // podlaczamy driva
        try {
            Class.forName(DRIVER);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void loadConnection() {    // metoda load connection
        try {
            connection = DriverManager.getConnection(getFormatedURL(), USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getFormatedURL() {       //  tworzymy stringa do adresu i przypisujemy go powyzej  do connection
        return ADDRESS + ":" + PORT + "/" + DATABASE + "?" + PARMAS;
    }


    public static Connection getConnection() {   // tworzymy sigletona zeby tylko zrobic 1 instancje klasy
        if (connection == null) {
            loadDriver();
            loadConnection();
        }
        return connection;
    }

    public static void closeConnection() {                   // zamykamy sigletona
        if (connection == null) {
            System.out.println("nothing to close");
        } else {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
