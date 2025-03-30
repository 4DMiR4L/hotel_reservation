package dao.daoImpl;

import entity.Booking;

public interface BookingDAOImpl {
    void createReservation(Booking booking);
    void listReservation(Booking booking);
    void findById(int id);
    void cancelReservation(Booking booking);
}
