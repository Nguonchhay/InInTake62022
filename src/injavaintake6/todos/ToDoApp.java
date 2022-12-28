package injavaintake6.todos;

import injavaintake6.todos.screens.DashboardScreen;
import javax.swing.*;

public class ToDoApp {
    public static void launch() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            System.out.println("Look and Feel not set");
        }
        DashboardScreen dashboardScreen = new DashboardScreen();
        dashboardScreen.display();
    }
}
