package injavaintake6.todos.screens;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RegisterScreen extends JFrame {

    protected JTextField txtEmail, txtFullName;
    protected JPasswordField txtPassword, txtConfirmPassword;
    protected String profile;
    protected JLabel lblImage;

    public RegisterScreen() {
        super("Register");
        setSize(400, 600);
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
        JLabel lblTitle = new JLabel("Register");
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

        JLabel lblConfirmPassword = new JLabel("Confirm Password *");
        lblConfirmPassword.setBounds(50, 220, 300, 30);
        add(lblConfirmPassword);
        txtConfirmPassword = new JPasswordField();
        txtConfirmPassword.setBounds(50, 260, 300, 30);
        add(txtConfirmPassword);


        JLabel lblProfile = new JLabel("Profile");
        lblProfile.setBounds(50, 300, 300, 30);
        add(lblProfile);

        lblImage = new JLabel();
        lblImage.setBounds(50, 340, 100, 100);
        add(lblImage);
        JButton browserProfile = new JButton("Choose file");
        browserProfile.setBounds(100, 300, 100, 30);
        browserProfile.addActionListener(e -> {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileFilter(new FileNameExtensionFilter("Image file", "jpg", "png", "jpeg"));
            if (jFileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                String imagePath = jFileChooser.getSelectedFile().getAbsolutePath();
                Image selectedImage = new ImageIcon(imagePath).getImage();
                selectedImage = selectedImage.getScaledInstance(100, 100, 0);
                lblImage.setIcon(new ImageIcon(selectedImage));
            }
        });
        add(browserProfile);


        JButton btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(130, 460, 100, 35);
        add(btnSignUp);
        btnSignUp.addActionListener(event -> {
            register();
        });


        JLabel lblSignUp = new JLabel("Already has an account?");
        lblSignUp.setBounds(120, 490, 200, 50);
        add(lblSignUp);
        lblSignUp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                LoginScreen loginScreen = new LoginScreen();
                loginScreen.display();
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

    public void register() {
        String emailValue = txtEmail.getText().toLowerCase();
        String passwordValue = String.valueOf(txtPassword.getPassword());
        if (isValidate(emailValue, passwordValue)) {
            JOptionPane.showMessageDialog(
            this,
                    "Redirect user to Dashboard screen",
                    "Success login",
                    JOptionPane.INFORMATION_MESSAGE
            );
            /**
             * 1. Store data to table
             * 1.1. Encrypt password before storing
             * 2. If success then copy selected image to project folder "uploads"
             * 3. Do auto login user
             * 4. Redirect to Dashboard
             */
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
