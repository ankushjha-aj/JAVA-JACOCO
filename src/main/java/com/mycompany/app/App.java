package com.mycompany.app;

import javax.swing.*;
import java.awt.*;

/**
 * Hello world!
 */
public class App {

    private static final String MESSAGE = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginFrame());
    }

    public String getMessage() {
        return MESSAGE;
    }
}

class Authenticator {
    private static final String USERNAME = "Ankush"; // change as needed
    private static final String PASSWORD = "Ankush@123"; // change as needed

    public boolean authenticate(String username, String password) {
        return USERNAME.equals(username) && PASSWORD.equals(password);
    }
}

class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;
    private Authenticator authenticator = new Authenticator();
    private static final String USERNAME = "Ankush"; // change as needed

    public LoginFrame() {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        showLoginPanel();
        setVisible(true);
    }

    private void showLoginPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        usernameField.setName("usernameField");
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        passwordField.setName("passwordField");
        panel.add(passwordField);

        panel.add(new JLabel());
        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.addActionListener(e -> togglePasswordVisibility());
        panel.add(showPasswordCheckBox);

        JButton loginButton = new JButton("Login");
        loginButton.setName("loginButton");
        loginButton.addActionListener(e -> login());
        panel.add(new JLabel()); // empty cell
        panel.add(loginButton);

        getContentPane().removeAll();
        add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void showWelcomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        JLabel welcomeLabel = new JLabel("Welcome, " + USERNAME + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 16));
        panel.add(welcomeLabel, BorderLayout.CENTER);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> showLoginPanel());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(logoutButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        getContentPane().removeAll();
        add(panel, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    private void togglePasswordVisibility() {
        if (showPasswordCheckBox.isSelected()) {
            passwordField.setEchoChar((char) 0);
        } else {
            passwordField.setEchoChar('•');
        }
    }

    private void login() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        if (authenticator.authenticate(username, password)) {
            JOptionPane.showMessageDialog(this, "You are successfully logged into the system!", "Success", JOptionPane.INFORMATION_MESSAGE);
            showWelcomePanel();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
