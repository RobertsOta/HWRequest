package com.example.autenticatask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.*;

public class DatabaseConnection {
    final String DB = "jdbc:mysql://autdatabase.cjbekmfmnqfk.eu-north-1.rds.amazonaws.com/";
    //"jdbc:mysql://rcs-database.cgox3orafoc1.us-east-1.rds.amazonaws.com:3306/RcsHomework"
    final String USERNAME = "admin";
    final String PASSWORD = "1!priedes135";

    public void addRequest() {
        try {
            Connection conn = DriverManager.getConnection(DB, USERNAME, PASSWORD);

            Statement stmt = conn.createStatement();
            String sqlQuery = "INSERT INTO users (hardware, parameters, comments)" + "VALUES (?, ?, ?)";
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


//     try{
//        Connection conn = DriverManager.getConnection(DB, USERNAME, PASSWORD);
//
//        Statement stmt = conn.createStatement();
//        String sql = "INSERT INTO users (name, email, phone, city, address, password) " + "VALUES (?, ?, ?, ?, ?, ?)";
//
//        PreparedStatement preparedStatement = conn.prepareStatement(sql);
//
//        preparedStatement.setString(1, name);
//        preparedStatement.setString(2, email);
//        preparedStatement.setString(3, phone);
//        preparedStatement.setString(4, city);
//        preparedStatement.setString(5, address);
//        preparedStatement.setString(6, password);
//
//
////Pievienot ierakstu
//        int addedRows = preparedStatement.executeUpdate();
//        if (addedRows > 0) {
//            user = new User();
//            user.name = name;
//            user.email = email;
//            user.phone = phone;
//            user.city = city;
//            user.address = address;
//            user.password = password;
//        }
//
//        stmt.close();
//        conn.close();
//
//
//    } catch (SQLException e) {
//        e.printStackTrace();
//    }
//
//
//        return user;
//}

}
