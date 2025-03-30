package dao.daoImpl;

import entity.Room;

public interface RoomDAOImpl {
    void addRoom(Room room);

    void listRooms();

    Room findById(int id);

    void update(Room room);

    void delete(int id);
}
