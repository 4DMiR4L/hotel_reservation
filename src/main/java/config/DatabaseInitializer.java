package config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInitializer {
    public static void initialize() {
        try (Connection conn = DatabaseConfig.getConnection()) {
            createHotelsTable(conn);
            createRoomsTable(conn);
            createBookingsTable(conn);
            System.out.println("Database tables initialized successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize database", e);
        }
    }

    private static void createHotelsTable(Connection conn) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS hotels (
                    id SERIAL PRIMARY KEY,
                    name VARCHAR(255) NOT NULL,
                    location VARCHAR(255),
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                );
                """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    private static void createRoomsTable(Connection conn) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS rooms (
                    id SERIAL PRIMARY KEY,
                    hotel_id INT REFERENCES hotels(id) ON DELETE CASCADE,
                    room_number VARCHAR(50) NOT NULL,
                    price DECIMAL(10,2) NOT NULL,
                    status VARCHAR(50) CHECK (status IN ('available', 'booked')),
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                );
                """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }

    private static void createBookingsTable(Connection conn) throws SQLException {
        String sql = """
                CREATE TABLE IF NOT EXISTS bookings (
                    id SERIAL PRIMARY KEY,
                    room_id INT REFERENCES rooms(id) ON DELETE CASCADE,
                    customer_name VARCHAR(255) NOT NULL,
                    customer_email VARCHAR(255) NOT NULL,
                    start_date DATE NOT NULL,
                    end_date DATE NOT NULL,
                    status VARCHAR(50) CHECK (status IN ('active', 'cancelled')),
                    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
                );
                """;
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        }
    }
}
