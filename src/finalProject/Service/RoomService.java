package finalProject.Service;

import finalProject.DAO.RoomDAO;
import finalProject.model.Filter;
import finalProject.model.Room;

import java.util.ArrayList;

public class RoomService {
    RoomDAO roomDAO = new RoomDAO();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        return roomDAO.findRooms(filter);
    }
}
