package injavaintake6.todos.models;

import injavaintake6.todos.services.MySqlServiceSingleton;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Task {
    private int id;
    private String title;
    private int priority;
    private int status;

    public Task() {

    }

    public Task(int id, String title, int priority, int status) {
        setId(id);
        setTitle(title);
        setPriority(priority);
        setStatus(status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public static List<Task> list() {
        List<Task> tasks = new ArrayList<>();
        try {
            Connection connection = MySqlServiceSingleton.getInstance();
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM tasks ORDER BY priority";
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                tasks.add(new Task(
                    result.getInt(1),
                    result.getString(2),
                    result.getInt(3),
                    result.getInt(4)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public static boolean remove(int id) {
        boolean isDeleted = false;
        try {
            Connection connection = MySqlServiceSingleton.getInstance();
            Statement statement = connection.createStatement();
            String sql = "DELETE FROM tasks WHERE id=" + id;
            int result = statement.executeUpdate(sql);
            isDeleted = true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isDeleted;
    }
}
