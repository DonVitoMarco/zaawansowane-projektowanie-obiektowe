package pl.marek.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQL {

    private static Connection CONNECTION = null;
    private final static String URL = "jdbc:mysql://localhost:3306/zpo";
    private final static String USER = "root";
    private final static String PASSWORD = "admin";

    public static Connection getConnection() {
        if (CONNECTION == null) {
            loadConnection();
        }
        return CONNECTION;
    }

    public static void closeConnection() {
        if (CONNECTION == null) {
            errorHandler("No connection found", null);
        } else {
            try {
                CONNECTION.close();
                CONNECTION = null;
            } catch (SQLException e) {
                errorHandler("Failed to close the connection", e);
            }
        }
    }

    private static void loadConnection() {
        try {
            CONNECTION = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            errorHandler("Failed to connect to the database " + URL, e);
        }
    }

    private static void errorHandler(String message, Exception e) {
        System.out.println(message);
        if (e != null) System.out.println(e.getMessage());
    }
}
