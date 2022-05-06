package com.example.autenticatask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class AutenticaTaskApplication {

    public static void main(String[] args) {
//        SpringApplication.run(AutenticaTaskApplication.class, args);

        DatabaseConnection databaseConnection = new DatabaseConnection();
        databaseConnection.addRequest();
    }

}
