package edu.svecw.myshop.loaders;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFile
{
    public static void main(final String[] args) {
        final Properties props = new Properties();
        try {
            final FileInputStream input = new FileInputStream("C:/MyTech/Properties/myshopdbprops.properties");
            props.load(input);
        }
        catch (IOException e) {
            System.out.println("Failed to load database properties: " + e.getMessage());
            return;
        }
        final String username = props.getProperty("database.username");
        final String password = props.getProperty("database.password");
        try {
            final Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost/myshop", username, password);
            System.out.println("Connected to database successfully!");
            conn.close();
        }
        catch (SQLException e2) {
            System.out.println("Failed to connect to database: " + e2.getMessage());
        }
    }
}