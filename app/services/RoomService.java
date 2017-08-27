package services;

import model.Room;

import java.util.Date;
import java.util.List;

/**
 * Created by adrian on 02.07.17.
 */
public interface RoomService {

    void editRoomForDoctor(int doctorsId);// TODO
    void editRoom(Room room); // TODO
    List<Room> getRoomsByDoctorsID(int doctorsID); //TODO
    List <Room> getAllRoomsList();//TODO
    void AddRoom(Room room); //TODO
    void removeRoomsforDoctor(int doctorsID, Date StartTime, Date EndTime);//TODO
    void removeRooms(Room room); //TODO
}
