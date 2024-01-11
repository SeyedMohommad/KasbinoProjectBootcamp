package com.example.kasbinoprojectbootcamp.common;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {

    private static final Properties configProps = new Properties();

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("MySQL JDBC Driver not found", e);
        }
    }

    public static void loadConfiguration(ServletContext context) {
        try (InputStream input = context.getResourceAsStream("/WEB-INF/config.properties")) {
            configProps.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Could not load configuration file", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = configProps.getProperty("database.url");
        String user = configProps.getProperty("database.user");
        String password = configProps.getProperty("database.password");

        // Directly use DriverManager to get the connection
        return DriverManager.getConnection(url, user, password);
    }
}
