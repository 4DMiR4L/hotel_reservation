package dao.daoImpl;

import entity.Hotel;

public interface HotelDAOImpl {

    void addHotel(Hotel hotel);
    void allList();
    void findByid(int id);
    void updateHotel(Hotel hotel);
    void deleteHotel(int id);
}
