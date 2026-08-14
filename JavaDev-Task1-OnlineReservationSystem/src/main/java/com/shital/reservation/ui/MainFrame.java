package com.shital.reservation.ui;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private final CardLayout cardLayout = new CardLayout();
    private final JPanel contentPanel = new JPanel(cardLayout);

    public MainFrame(String username) {
        setTitle("Online Reservation System - Dashboard");
        setSize(850, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel welcome = new JLabel("  Welcome, " + username);
        welcome.setFont(new Font("Arial", Font.BOLD, 16));

        JButton logoutButton = new JButton("Logout");
        topPanel.add(welcome, BorderLayout.WEST);
        topPanel.add(logoutButton, BorderLayout.EAST);

        JPanel menuPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        JButton reservationButton = new JButton("Book Reservation");
        JButton cancellationButton = new JButton("Cancel Reservation");

        menuPanel.add(reservationButton);
        menuPanel.add(cancellationButton);

        JPanel north = new JPanel(new BorderLayout(10, 10));
        north.add(topPanel, BorderLayout.NORTH);
        north.add(menuPanel, BorderLayout.SOUTH);
        north.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        ReservationPanel reservationPanel = new ReservationPanel();

        CancellationPanel cancellationPanel = new CancellationPanel();

        contentPanel.add(reservationPanel, "BOOK");
        contentPanel.add(cancellationPanel, "CANCEL");
        cardLayout.show(contentPanel, "BOOK");

        reservationButton.addActionListener(e -> {
            cardLayout.show(contentPanel, "BOOK");
        });
        cancellationButton.addActionListener(e -> cardLayout.show(contentPanel, "CANCEL"));

        logoutButton.addActionListener(e -> {
            int choice = JOptionPane.showConfirmDialog(
                    this,
                    "Do you want to logout?",
                    "Logout",
                    JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                dispose();
                new LoginFrame().setVisible(true);
            }
        });

        add(north, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }
}
