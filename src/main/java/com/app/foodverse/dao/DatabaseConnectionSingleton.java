package com.app.foodverse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnectionSingleton {
    static final String URL = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_20_DEVINT";
    static final String USER = "CSCI5308_20_DEVINT_USER";
    static final String PASS = "kMLPZ7jWPH";
    static final String CLASS_NAME = "com.mysql.cj.jdbc.Driver";

    private static DatabaseConnectionSingleton instance;

    private Connection connection;

    private DatabaseConnectionSingleton() throws SQLException {
        try {
            Class.forName(CLASS_NAME);
            this.connection = DriverManager.getConnection(URL, USER, PASS);
        }
        catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    public static DatabaseConnectionSingleton getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnectionSingleton();
        }
        else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnectionSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
