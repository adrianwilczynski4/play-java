package dao;

import model.Room;

import java.util.Date;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface RoomDAO {

    List<Room> getRoomsByFeature(Room room); //TODO

    List<Room> getAllRoomsList(); //TODO
    void AddRoom(Room room); //TODO
    void editRoom(Room room);//TODO
    void removeRoom(Room room); //TODO
}
