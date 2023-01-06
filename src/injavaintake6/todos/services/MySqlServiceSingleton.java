package injavaintake6.todos.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class MySqlServiceSingleton {

    private static String dbHost = "localhost";
    private static int dbPort = 3306;
    private static String dbName = "todo";
    private static String user ="root";
    private static String password = "";

    private static Connection connection = null;

    private MySqlServiceSingleton() {}

    public static Connection getInstance() throws SQLException {
        if (connection == null) {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName,
                    user,
                    password
            );
            System.out.println("MySQL is connected!");
        }
        return connection;
    }
}
