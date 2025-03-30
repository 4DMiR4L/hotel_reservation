package dao.daoImpl;

import entity.Hotel;

public interface HotelDAOImpl {

    void save(Hotel hotel);
    void findAll();
    void findByid(int id);
    void updateHotel(Hotel hotel);
    void deleteHotel(int id);
}
