package finalProject.Controller;

import finalProject.DAO.RoomDAO;
import finalProject.Service.RoomService;
import finalProject.model.Filter;
import finalProject.model.Room;

import java.util.ArrayList;

public class RoomController {

    RoomService roomService = new RoomService();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        return roomService.findRooms(filter);
    }
}
