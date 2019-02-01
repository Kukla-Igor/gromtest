package finalProject.Controller;

import finalProject.DAO.RoomDAO;
import finalProject.Service.RoomService;
import finalProject.model.Filter;
import finalProject.model.Room;

import java.util.ArrayList;

public class RoomController {

    private RoomService roomService = new RoomService();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        return roomService.findRooms(filter);
    }

    public Room addRoom(Room room) throws Exception {
        return roomService.addRoom(room);
    }

    public void deleteRoom(Long roomId) throws Exception{
        roomService.deleteRoom(roomId);
    }
}
