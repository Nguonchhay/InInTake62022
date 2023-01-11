package injavaintake6.todos.screens;

import javax.swing.*;

public class BaseScreen extends JFrame {

    public BaseScreen() {}
    public BaseScreen(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    public void display() {
        setVisible(true);
    }

    public void hidden() {
        setVisible(false);
    }
}
