package injavaintake6.todos.screens;

import injavaintake6.todos.screens.todos.ToDoListScreen;
import injavaintake6.todos.services.MySqlService;
import injavaintake6.todos.services.MySqlServiceSingleton;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DashboardScreen extends JFrame {

//    private MySqlService mySqlService;

    public DashboardScreen() {
        super("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

//        mySqlService = new MySqlService();
        initUI();
    }

//    public DashboardScreen(String title) {
//        super(title);
//    }

    public void display() {
        // Check if user already logged in
        boolean isAuth = false;
        String queryUserSQL = "SELECT id FROM users WHERE is_auth=1 LIMIT 1";
        try {
            Connection connection = MySqlServiceSingleton.getInstance();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryUserSQL);
            while (resultSet.next()) {
                isAuth = true;
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (isAuth) {
            setVisible(true);
        } else {
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.display();
        }
    }

    public void hidden() {
        setVisible(false);
    }

    private void initUI() {
        /**
         * 1. Define menu
         * 2. Define summary data of ToDo
         * 2.1. Total ToDo item
         * 2.2. Total ToDo item with nearly due date status (within a day)
         * 2.3. Total ToDo item with completed status
         */
        JPanel pMenu = new JPanel();
        pMenu.setBounds(50, 50, 100, 500);
        add(pMenu);
        BoxLayout menuLayout = new BoxLayout(pMenu, BoxLayout.Y_AXIS);
        pMenu.setLayout(menuLayout);

        JButton btnDashboard = new JButton("Dashboard");
        pMenu.add(btnDashboard);

        JButton btnToDo = new JButton("ToDo List");
        pMenu.add(btnToDo);
        btnToDo.addActionListener(e -> {
            hidden();
            ToDoListScreen toDoListScreen = new ToDoListScreen();
            toDoListScreen.display();
        });

        JButton btnUser = new JButton("User List");
        pMenu.add(btnUser);

        JButton btnLogout = new JButton("Logout");
        pMenu.add(btnLogout);
        btnLogout.addActionListener(e -> {
            logout();
        });
    }

    private void logout() {
        try {
            Connection connection = MySqlServiceSingleton.getInstance();
            Statement statement = connection.createStatement();
            String updateAuthUserSQL = "UPDATE users SET is_auth=0";
            int result = statement.executeUpdate(updateAuthUserSQL);

            hidden();
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.display();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    this,
                    "Something went wrong!",
                    "Failed Logout",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}
