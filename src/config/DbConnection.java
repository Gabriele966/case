package config;

import java.sql.*;

public class DbConnection {
    public static Connection openConnection() throws SQLException,ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Esercizio 3",
                "postgres",
                "1234");
    }
}
