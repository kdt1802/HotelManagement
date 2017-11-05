/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.Server;

/**
 *
 * @author sev_user
 */
public class ConnectionManager {

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=HotelManagement";
    private static String USER = "khiem.hh";
    private static String PASSWORD = "123456";

    public ConnectionManager(Server server) {
        if (!(server.getServer().equals("") && server.getServerUser().equals("") && server.getServerPassword().equals(""))) {
            URL = "jdbc:sqlserver://" + server.getServer() + ";databaseName=HotelManagement";
            USER = server.getServerUser();
            PASSWORD = server.getServerPassword();
        }
    }

    public static Connection getConnection() {
        Connection connection;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            return null;
        }
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {

        }
    }
}
