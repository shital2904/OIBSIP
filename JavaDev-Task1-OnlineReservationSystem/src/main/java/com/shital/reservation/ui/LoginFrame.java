package com.shital.reservation.ui;

import com.shital.reservation.dao.UserDAO;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    private final JTextField usernameField = new JTextField();
    private final JPasswordField passwordField = new JPasswordField();

    public LoginFrame() {
        setTitle("Online Reservation System - Login");
        setSize(430, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 10, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel(
                "ONLINE RESERVATION SYSTEM",
                SwingConstants.CENTER
        );
        title.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        // Username
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(new JLabel("Username:"), gbc);

        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        // Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        // Login button
        JButton loginButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(loginButton, gbc);

        // Create Account button
        JButton registerButton = new JButton("Create Account");

        gbc.gridy = 4;
        panel.add(registerButton, gbc);

        add(panel);

        // Login button
        loginButton.addActionListener(e -> login());

        // Press Enter in password field
        passwordField.addActionListener(e -> login());

        // Create Account button
        registerButton.addActionListener(e -> register());
    }

    // =========================
    // LOGIN
    // =========================

    private void login() {

        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword());

        // Validation
        if (username.isEmpty() || password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Username and password are required.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Check database
        boolean valid = new UserDAO().authenticate(username, password);

        if (valid) {

            dispose();

            new MainFrame(username).setVisible(true);

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Access denied: invalid username or password.",
                    "Login Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // =========================
    // REGISTER / CREATE ACCOUNT
    // =========================

    private void register() {

        String username = JOptionPane.showInputDialog(
                this,
                "Enter username:",
                "Create Account",
                JOptionPane.PLAIN_MESSAGE
        );

        // User clicked Cancel
        if (username == null) {
            return;
        }

        username = username.trim();

        // Username validation
        if (username.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Username cannot be empty.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        String password = JOptionPane.showInputDialog(
                this,
                "Enter password:",
                "Create Account",
                JOptionPane.PLAIN_MESSAGE
        );

        // User clicked Cancel
        if (password == null) {
            return;
        }

        password = password.trim();

        // Password validation
        if (password.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Password cannot be empty.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        // Save user to database
        boolean registered = new UserDAO().registerUser(
                username,
                password
        );

        if (registered) {

            JOptionPane.showMessageDialog(
                    this,
                    "Account created successfully!\nYou can now login.",
                    "Registration Successful",
                    JOptionPane.INFORMATION_MESSAGE
            );

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    "Username already exists or registration failed.",
                    "Registration Failed",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}