package dao.daoImpl;

import entity.Hotel;

import java.sql.SQLException;

public interface HotelDAOImpl {

    void save(Hotel hotel) throws SQLException;

    void findAll() throws SQLException;

    void findByid(int id);

    void updateHotel(Hotel hotel, int id) throws SQLException;

    void deleteHotel(int id);
}
