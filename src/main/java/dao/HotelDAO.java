package dao;

import config.DatabaseConfig;
import dao.daoImpl.HotelDAOImpl;
import entity.Hotel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HotelDAO implements HotelDAOImpl {

    @Override
    public void save(Hotel hotel) throws SQLException {
        String sql = "INSERT INTO hotels (name, location) VALUES (?, ?)";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hotel.getName());
            stmt.setString(2, hotel.getLocation());
            stmt.executeUpdate();
        }
    }

    @Override
    public void findAll() throws SQLException {
        List<Hotel> hotels = new ArrayList<>();
        String sql = "SELECT * FROM hotels";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                hotels.add(new Hotel(rs.getInt("id"), rs.getString("name"), rs.getString("location"), rs.getDate("date")));
            }
        }
    }

    @Override
    public void findByid(int id) {
        String sql = "SELECT * FROM hotels WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateHotel(Hotel hotel, int id) {
        String sql = "UPDATE hotels SET name = ?, location = ? WHERE id = ?";

        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, hotel.getName());
            stmt.setString(2, hotel.getLocation());
            int rowsUpdated = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update hotel", e);
        }
    }

    @Override
    public void deleteHotel(int id) {
        String sql = "DELETE FROM hotels WHERE id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsDeleted = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update hotel", e);
        }
    }
}
