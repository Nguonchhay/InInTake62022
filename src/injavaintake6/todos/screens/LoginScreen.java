package injavaintake6.todos.screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginScreen extends JFrame {

    protected JTextField txtEmail;
    protected JPasswordField txtPassword;
    protected JButton btnLogin;

    public LoginScreen() {
        super("Login");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        initUI();
    }

    public void display() {
        setVisible(true);
    }

    public void hidden() {
        setVisible(false);
    }

    public void initUI() {
        JLabel lblTitle = new JLabel("ToDo App");
        lblTitle.setBounds(150, 20, 200, 50);
        lblTitle.setFont(new Font("Times New Roman", Font.BOLD, 24));
        add(lblTitle);


        JLabel lblEmail = new JLabel("Email *");
        lblEmail.setBounds(50, 80, 300, 30);
        add(lblEmail);
        txtEmail = new JTextField(100);
        txtEmail.setBounds(50, 110, 300, 30);
        add(txtEmail);


        JLabel lblPassword = new JLabel("Password *");
        lblPassword.setBounds(50, 150, 300, 30);
        add(lblPassword);
        txtPassword = new JPasswordField();
        txtPassword.setBounds(50, 180, 300, 30);
        add(txtPassword);


        JLabel lblForgotPassword = new JLabel("Forgot Password?");
        lblForgotPassword.setBounds(50, 220, 300, 30);
        add(lblForgotPassword);


        btnLogin = new JButton("Login");
        btnLogin.setBounds(130, 260, 100, 35);
        add(btnLogin);
        btnLogin.addActionListener(event -> {
            login();
        });


        JLabel lblSignUp = new JLabel("Create a new account?");
        lblSignUp.setBounds(120, 310, 200, 50);
        add(lblSignUp);
        lblSignUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                RegisterScreen registerScreen = new RegisterScreen();
                registerScreen.display();
                hidden();
            }
        });
    }

    private boolean isValidate(String email, String password) {
        boolean isValid = false;
        if (!email.equalsIgnoreCase("") && !password.equals("")) {
            isValid = true;
        }

        return isValid;
    }

    public void login() {
        String emailValue = txtEmail.getText().toLowerCase();
        String passwordValue = String.valueOf(txtPassword.getPassword());
        if (isValidate(emailValue, passwordValue)) {
            JOptionPane.showMessageDialog(
            this,
                    "Redirect user to Dashboard screen",
                    "Success login",
                    JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Please input all required fields!",
                    "Failed Login",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }
}