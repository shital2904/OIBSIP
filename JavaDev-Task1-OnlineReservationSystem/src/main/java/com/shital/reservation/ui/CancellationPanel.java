package com.shital.reservation.ui;

import com.shital.reservation.dao.ReservationDAO;
import com.shital.reservation.model.Reservation;

import javax.swing.*;
import java.awt.*;

public class CancellationPanel extends JPanel {

    private final JTextField pnrField = new JTextField();
    private final JTextArea detailsArea = new JTextArea();

    private final ReservationDAO reservationDAO = new ReservationDAO();
    private Reservation currentReservation;

    public CancellationPanel() {
        setLayout(new BorderLayout(10, 10));
        setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel title = new JLabel("Cancel Reservation", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel top = new JPanel(new BorderLayout(10, 10));
        top.add(new JLabel("Enter PNR:"), BorderLayout.WEST);
        top.add(pnrField, BorderLayout.CENTER);

        JButton fetchButton = new JButton("Fetch Booking");
        top.add(fetchButton, BorderLayout.EAST);

        add(top, BorderLayout.BEFORE_FIRST_LINE);

        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        detailsArea.setLineWrap(true);
        detailsArea.setWrapStyleWord(true);

        add(new JScrollPane(detailsArea), BorderLayout.CENTER);

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton cancelButton = new JButton("Confirm Cancellation");
        JButton clearButton = new JButton("Clear");

        bottom.add(cancelButton);
        bottom.add(clearButton);
        add(bottom, BorderLayout.SOUTH);

        fetchButton.addActionListener(e -> fetchBooking());
        cancelButton.addActionListener(e -> cancelBooking());
        clearButton.addActionListener(e -> clearForm());
    }

    private void fetchBooking() {
        String pnr = pnrField.getText().trim().toUpperCase();

        if (pnr.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a PNR number.",
                    "Validation Error",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        currentReservation = reservationDAO.findByPNR(pnr);

        if (currentReservation == null) {
            detailsArea.setText("");
            JOptionPane.showMessageDialog(
                    this,
                    "No booking found for PNR: " + pnr,
                    "Not Found",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        detailsArea.setText(formatReservation(currentReservation));
    }

    private void cancelBooking() {
        if (currentReservation == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Fetch a valid booking first.",
                    "No Booking",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to cancel PNR "
                        + currentReservation.getPnr() + "?",
                "Confirm Cancellation",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE
        );

        if (choice != JOptionPane.YES_OPTION) {
            return;
        }

        boolean deleted = reservationDAO.deleteByPNR(currentReservation.getPnr());

        if (deleted) {
            JOptionPane.showMessageDialog(
                    this,
                    "Reservation cancelled successfully.",
                    "Cancellation Successful",
                    JOptionPane.INFORMATION_MESSAGE
            );
            clearForm();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Cancellation failed. Check the database connection.",
                    "Database Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private String formatReservation(Reservation r) {
        return """
                BOOKING DETAILS
                ------------------------------
                PNR              : %s
                Passenger Name   : %s
                Train Number     : %d
                Train Name       : %s
                Class Type       : %s
                Journey Date     : %s
                Source Station   : %s
                Destination      : %s
                ------------------------------
                """.formatted(
                r.getPnr(),
                r.getPassengerName(),
                r.getTrainNumber(),
                r.getTrainName(),
                r.getClassType(),
                r.getJourneyDate(),
                r.getSourceStation(),
                r.getDestinationStation()
        );
    }

    private void clearForm() {
        pnrField.setText("");
        detailsArea.setText("");
        currentReservation = null;
    }
}
