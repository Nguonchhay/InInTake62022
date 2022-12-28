package injavaintake6.todos.screens;

import javax.swing.*;

public class DashboardScreen extends JFrame {

    public DashboardScreen() {
        super("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
        initUI();
    }

//    public DashboardScreen(String title) {
//        super(title);
//    }

    public void display() {
        // Check if user already logged in
        boolean isAuth = false;
        /**
         * 1. Search for user whether there is a logged in user
         * 1.1. check user field "is_auth" equal to "true" or 1
         */
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
    }
}
