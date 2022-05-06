package com.example.autenticatask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;

public class DatabaseConnection {

    //Establish connection with database
    private static Connection getConnection() throws SQLException {

        final String DB = "jdbc:mysql://autdatabase.cjbekmfmnqfk.eu-north-1.rds.amazonaws.com:3306/hardwareRequests";
        final String USERNAME = "admin";
        final String PASSWORD = "1!priedes135";

        Connection conn = DriverManager.getConnection(DB, USERNAME, PASSWORD);

        return conn;
    }




    public void addRequest() {
        try {
            Connection conn = DatabaseConnection.getConnection();

            Statement stmt = conn.createStatement();
            String sqlQuery = "INSERT INTO requests (hardware, parameters, comment)" + "VALUES (?, ?, ?)";
            PreparedStatement prepStmt = conn.prepareStatement(sqlQuery);

            prepStmt.setString(1, "Monitors");
            prepStmt.setString(2, "17in");
            prepStmt.setString(3, "Darba vajadzībām");

            prepStmt.execute();

            stmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
