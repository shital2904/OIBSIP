package com.shital.reservation.dao;

import com.shital.reservation.db.DBConnection;
import com.shital.reservation.model.Reservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class ReservationDAO {

    public boolean insertReservation(Reservation reservation) {
        String sql = """
                INSERT INTO reservations
                (pnr, passenger_name, train_number, class_type, journey_date,
                 source_station, destination_station)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, reservation.getPnr());
            ps.setString(2, reservation.getPassengerName());
            ps.setInt(3, reservation.getTrainNumber());
            ps.setString(4, reservation.getClassType());
            ps.setDate(5, java.sql.Date.valueOf(reservation.getJourneyDate()));
            ps.setString(6, reservation.getSourceStation());
            ps.setString(7, reservation.getDestinationStation());

            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Reservation findByPNR(String pnr) {
        String sql = """
                SELECT r.pnr, r.passenger_name, r.train_number, t.train_name,
                       r.class_type, r.journey_date, r.source_station,
                       r.destination_station
                FROM reservations r
                JOIN trains t ON r.train_number = t.train_number
                WHERE r.pnr = ?
                """;

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, pnr);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    LocalDate date = rs.getDate("journey_date").toLocalDate();

                    return new Reservation(
                            rs.getString("pnr"),
                            rs.getString("passenger_name"),
                            rs.getInt("train_number"),
                            rs.getString("train_name"),
                            rs.getString("class_type"),
                            date,
                            rs.getString("source_station"),
                            rs.getString("destination_station")
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean deleteByPNR(String pnr) {
        String sql = "DELETE FROM reservations WHERE pnr = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setString(1, pnr);
            return ps.executeUpdate() == 1;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
