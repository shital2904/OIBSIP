package com.shital.reservation.ui;

import com.shital.reservation.dao.ReservationDAO;
import com.shital.reservation.dao.TrainDAO;
import com.shital.reservation.model.Reservation;
import com.shital.reservation.service.PNRGenerator;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class ReservationPanel extends JPanel {

    private final JTextField passengerNameField = new JTextField();
    private final JTextField trainNumberField = new JTextField();
    private final JTextField trainNameField = new JTextField();
    private final JComboBox<String> classTypeBox =
            new JComboBox<>(new String[]{"Sleeper", "AC 3 Tier", "AC 2 Tier", "AC First Class"});
    private final JTextField journeyDateField = new JTextField();
    private final JTextField sourceField = new JTextField();
    private final JTextField destinationField = new JTextField();

    private final TrainDAO trainDAO = new TrainDAO();
    private final ReservationDAO reservationDAO = new ReservationDAO();

    public ReservationPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Train Reservation", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel form = new JPanel(new GridLayout(7, 2, 10, 10));

        form.add(new JLabel("Passenger Name:"));
        form.add(passengerNameField);

        form.add(new JLabel("Train Number:"));
        form.add(trainNumberField);

        form.add(new JLabel("Train Name:"));
        trainNameField.setEditable(false);
        trainNameField.setBackground(new Color(235, 235, 235));
        form.add(trainNameField);

        form.add(new JLabel("Class Type:"));
        form.add(classTypeBox);

        form.add(new JLabel("Journey Date (yyyy-MM-dd):"));
        form.add(journeyDateField);

        form.add(new JLabel("Source Station:"));
        form.add(sourceField);

        form.add(new JLabel("Destination Station:"));
        form.add(destinationField);

        add(form, BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        JButton checkTrainButton = new JButton("Check Train");
        JButton bookButton = new JButton("Book Ticket");
        JButton clearButton = new JButton("Clear");

        bottom.add(checkTrainButton);
        bottom.add(bookButton);
        bottom.add(clearButton);
        add(bottom, BorderLayout.SOUTH);

        trainNumberField.addActionListener(e -> loadTrainName());
        checkTrainButton.addActionListener(e -> loadTrainName());
        bookButton.addActionListener(e -> bookTicket());
        clearButton.addActionListener(e -> clearForm());
    }

    private boolean loadTrainName() {
        String trainText = trainNumberField.getText().trim();

        if (trainText.isEmpty()) {
            trainNameField.setText("");
            return false;
        }

        try {
            int trainNumber = Integer.parseInt(trainText);
            String trainName = trainDAO.findTrainName(trainNumber);

            if (trainName == null) {
                trainNameField.setText("");
                JOptionPane.showMessageDialog(
                        this,
                        "Train number not found in the database.",
                        "Train Not Found",
                        JOptionPane.WARNING_MESSAGE
                );
                return false;
            }

            trainNameField.setText(trainName);
            return true;

        } catch (NumberFormatException e) {
            trainNameField.setText("");
            JOptionPane.showMessageDialog(
                    this,
                    "Train number must be numeric.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
    }

    private void bookTicket() {
        String passengerName = passengerNameField.getText().trim();
        String trainText = trainNumberField.getText().trim();
        String trainName = trainNameField.getText().trim();
        String classType = (String) classTypeBox.getSelectedItem();
        String dateText = journeyDateField.getText().trim();
        String source = sourceField.getText().trim();
        String destination = destinationField.getText().trim();

        if (passengerName.isEmpty() || trainText.isEmpty() || trainName.isEmpty()
                || dateText.isEmpty() || source.isEmpty() || destination.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all required fields.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (source.equalsIgnoreCase(destination)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Source and destination cannot be the same.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int trainNumber;
        try {
            trainNumber = Integer.parseInt(trainText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Train number must be numeric.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        LocalDate journeyDate;
        try {
            journeyDate = LocalDate.parse(dateText);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Enter date in yyyy-MM-dd format. Example: 2026-09-15",
                    "Invalid Date",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        if (journeyDate.isBefore(LocalDate.now())) {
            JOptionPane.showMessageDialog(
                    this,
                    "Journey date cannot be in the past.",
                    "Invalid Date",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        String pnr = PNRGenerator.generate();

        Reservation reservation = new Reservation(
                pnr,
                passengerName,
                trainNumber,
                trainName,
                classType,
                journeyDate,
                source,
                destination
        );

        boolean saved = reservationDAO.insertReservation(reservation);

        if (saved) {
            String message = """
                    Reservation Successful!

                    PNR: %s
                    Passenger: %s
                    Train: %d - %s
                    Class: %s
                    Journey Date: %s
                    From: %s
                    To: %s
                    """.formatted(
                    pnr, passengerName, trainNumber, trainName, classType,
                    journeyDate, source, destination
            );

            JOptionPane.showMessageDialog(
                    this,
                    message,
                    "Booking Confirmation",
                    JOptionPane.INFORMATION_MESSAGE
            );

            clearForm();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Booking failed. Check the database connection.",
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void clearForm() {
        passengerNameField.setText("");
        trainNumberField.setText("");
        trainNameField.setText("");
        classTypeBox.setSelectedIndex(0);
        journeyDateField.setText("");
        sourceField.setText("");
        destinationField.setText("");
    }
}
