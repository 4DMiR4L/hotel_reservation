package dao.daoImpl;

import entity.Booking;

import java.util.List;

public interface BookingDAOImpl {
    void createReservation(Booking booking);
    List<Booking> getAllBookings();
    void findById(int id);
    void cancelReservation(int id);
}
