//package com.example.test1.connection;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//
//public class DatabaseConnection {
//
//    // URL-ul bazei de date, utilizatorul și parola
//    private static final String URL = "jdbc:postgresql://localhost:5432/test";
//    private static final String USER = "userroot";
//    private static final String PASSWORD = "pass";
//
//    // Conexiune unică
//    private static Connection connection = null;
//
//    // Metodă pentru obținerea conexiunii
//    public static Connection getConnection() {
//        if (connection == null) {
//            try {
//                // Încărcarea driverului JDBC
//                Class.forName("org.postgresql.Driver");
//                // Obținerea conexiunii
//                connection = DriverManager.getConnection(URL, USER, PASSWORD);
//                System.out.println("Conectat cu succes la baza de date.");
//            } catch (ClassNotFoundException e) {
//                System.err.println("Driver JDBC nu a fost găsit.");
//                e.printStackTrace();
//            } catch (SQLException e) {
//                System.err.println("Eroare la conectarea la baza de date.");
//                System.err.println("Mesaj eroare: " + e.getMessage());
//                e.printStackTrace();
//            }
//        }
//        return connection;
//    }
//
//    // Metodă pentru închiderea conexiunii
//    public static void closeConnection() {
//        if (connection != null) {
//            try {
//                connection.close();
//                connection = null;
//                System.out.println("Conexiunea la baza de date a fost închisă.");
//            } catch (SQLException e) {
//                System.err.println("Eroare la închiderea conexiunii la baza de date.");
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) {
//        // Testarea conexiunii
//        Connection conn = DatabaseConnection.getConnection();
//        DatabaseConnection.closeConnection();
//    }
//}
//
