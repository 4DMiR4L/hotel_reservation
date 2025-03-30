package dao;

import config.DatabaseConfig;
import dao.daoImpl.BookingDAOImpl;
import entity.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO implements BookingDAOImpl {

    @Override
    public void cancelReservation(int id) {
//        String sql = "UPDATE booking SET cancel = true WHERE booking_id = ?";
//        try (Connection conn = DatabaseConfig.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, booking.getId());
//            int rowsUpdated = stmt.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to cancel reservation", e);
//        }
    }

    @Override
    public void findById(int id) {
        String sql = "SELECT * FROM booking WHERE booking_id = ?";
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                id = rs.getInt("id");
                int roomNumber = rs.getInt("room_number");
                double price = rs.getDouble("price");
                String status = rs.getString("status");
                Date date = rs.getDate("created_at");

            } else {
                System.out.println("No room found with ID: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to find room by ID", e);
        }
    }

    @Override
    public void createReservation(Booking booking) {

    }

    @Override
    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String sql = "SELECT * FROM bookings";
        try (Connection con = DatabaseConfig.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Booking booking = new Booking(
                        rs.getInt("id"),
                        rs.getInt("room_id"),
                        rs.getString("customer_name"),
                        rs.getString("customer_email"),
                        rs.getDate("start_date"),
                        rs.getDate("end_date"),
                        rs.getString("status"),
                        rs.getTimestamp("created_at")
                );
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }


}
