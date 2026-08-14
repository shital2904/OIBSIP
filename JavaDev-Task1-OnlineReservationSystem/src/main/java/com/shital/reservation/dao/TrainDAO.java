package com.shital.reservation.dao;

import com.shital.reservation.db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TrainDAO {

    public String findTrainName(int trainNumber) {
        String sql = "SELECT train_name FROM trains WHERE train_number = ?";

        try (Connection connection = DBConnection.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, trainNumber);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("train_name");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
