
package edu.svecw.myshop.loaders;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class LoadCategories
{
    public void loadData() {
        final String csvFile = "C:/Users/lohit/Desktop/categories.csv";
        final String delimiter = ",";
        final String insertSql = "INSERT INTO  catalog.category ( name, description) VALUES (?, ?)";
        final String dbUrl = "jdbc:postgresql://localhost:5432/myshop";
        final String dbUser = "postgres";
        final String dbPass = "postgres";
        try {
            final Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPass);
            BufferedReader br;
            String line;
            String[] data;
            String name;
            String description;
            PreparedStatement pstmt;
            for (br = new BufferedReader(new FileReader(csvFile)), line = br.readLine(), line = br.readLine(); line != null; line = br.readLine()) {
                data = line.split(delimiter);
                name = data[0];
                description = data[1];
                pstmt = conn.prepareStatement(insertSql);
                pstmt.setString(1, name);
                pstmt.setString(2, description);
                pstmt.executeUpdate();
                pstmt.close();
            }
            br.close();
            conn.close();
            System.out.println("Data imported successfully.");
        }
        catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
        catch (Exception e2) {
            System.err.println("Error: " + e2.getMessage());
        }
    }
}