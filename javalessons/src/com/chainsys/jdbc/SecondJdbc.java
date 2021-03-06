package com.chainsys.jdbc;

import java.sql.*;

public class SecondJdbc {
    static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "system";
    static final String PASS = "oracle";
    static final String QUERY = "SELECT EMAIL FROM Employees";

    public static void main(String[] args) {
        // Open a connection
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(QUERY);) {
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name

                System.out.println("Last: " + rs.getString("EMAIL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}