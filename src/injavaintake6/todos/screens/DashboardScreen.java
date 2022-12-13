package injavaintake6.todos.screens;

import javax.swing.*;

public class DashboardScreen extends JFrame {

    public DashboardScreen() {
        super("Dashboard");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);
    }

//    public DashboardScreen(String title) {
//        super(title);
//    }

    public void display() {
        // Check if user already logged in
        boolean isAuth = false;
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
}
