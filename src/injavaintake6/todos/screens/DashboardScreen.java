package injavaintake6.todos.screens;

import injavaintake6.todos.services.MySqlService;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DashboardScreen extends JFrame {

    private MySqlService mySqlService;

    public DashboardScreen() {
        super("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        mySqlService = new MySqlService();
        initUI();
    }

//    public DashboardScreen(String title) {
//        super(title);
//    }

    public void display() {
        System.out.println("DashboardScreen");
        // Check if user already logged in
        boolean isAuth = false;
        mySqlService.openConnection();
        String queryUserSQL = "SELECT id FROM users WHERE is_auth=1 LIMIT 1";
        Statement statement = mySqlService.getStatement();
        try {
            ResultSet resultSet = statement.executeQuery(queryUserSQL);
            while (resultSet.next()) {
                isAuth = true;
                break;
            }
            mySqlService.closeConnection();
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

        JButton btnUser = new JButton("User List");
        pMenu.add(btnUser);

        JButton btnLogout = new JButton("Logout");
        pMenu.add(btnLogout);
        btnLogout.addActionListener(e -> {
            logout();
        });
    }

    private void logout() {
        mySqlService.openConnection();
        Statement statement = mySqlService.getStatement();
        try {
            String updateAuthUserSQL = "UPDATE users SET is_auth=0";
            int result = statement.executeUpdate(updateAuthUserSQL);
            mySqlService.closeConnection();

            hidden();
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.display();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Something went wrong!",
                    "Failed Logout",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}
