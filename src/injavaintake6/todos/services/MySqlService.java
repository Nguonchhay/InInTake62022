package injavaintake6.todos.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlService {

    private String dbHost;
    private int dbPort;
    private String dbName;
    private String user;
    private String password;

    private Connection connection;

    public MySqlService() {
        dbHost = "localhost";
        dbPort = 3306;
        dbName = "todo";
        user = "root";
        password = "";
        connection = null;
    }

    public void openConnection() {
        try {
            connection = DriverManager.getConnection(
                "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName,
                    user,
                    password
            );
            System.out.println("MySQL is connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Statement getStatement() {
        if (connection == null) {
            return null;
        }
        try {
            return connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
