/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.database.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import util.SettingsLoader;

/**
 *
 * @author Nikola
 */
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private final Connection connection;

    private DatabaseConnection() throws SQLException {
        String url = SettingsLoader.getInstance().getProperty("url");
        String user = SettingsLoader.getInstance().getProperty("user");
        String password = SettingsLoader.getInstance().getProperty("password");      
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if(instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
    
    public void startTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }

    public void commitTransaction() throws SQLException {
        connection.commit();
    }

    public void rollbackTransaction() throws SQLException {
        connection.rollback();
    }
}
