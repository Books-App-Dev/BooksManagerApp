package org.example;

import java.sql.*;

public class MySQLConnection {
    private static String url = "jdbc:mysql://localhost:3306/my_database";
    private static String user = "root";
    private static String password = "";

    public static Connection getConnection() throws SQLException {
        return  DriverManager.getConnection(url,user,password);
    }
}
