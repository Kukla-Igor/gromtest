package finalProject.Service;

import finalProject.DAO.RoomDAO;
import finalProject.exception.BadRequestException;
import finalProject.model.Filter;
import finalProject.model.Room;

import java.util.ArrayList;

public class RoomService {
    RoomDAO roomDAO = new RoomDAO();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        if (filter == null)
            throw new BadRequestException("You do not enter the filter");
        return roomDAO.findRooms(filter);
    }
}
