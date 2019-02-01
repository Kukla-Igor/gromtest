package finalProject.Service;

import finalProject.DAO.RoomDAO;
import finalProject.exception.BadRequestException;
import finalProject.model.Filter;
import finalProject.model.Room;

import java.util.ArrayList;

public class RoomService {
    private RoomDAO roomDAO = new RoomDAO();

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        if (filter == null)
            throw new BadRequestException("You do not enter the filter");
        return roomDAO.findRooms(filter);
    }

    public Room addRoom(Room room) throws Exception {
        if (room == null)
            throw new BadRequestException("You do not enter the name of the hotel");
        return roomDAO.addRoom(room);
    }

    public void deleteRoom(Long roomId) throws Exception{
        if (roomId == null)
            throw new BadRequestException("You do not enter the name of the hotel");
        roomDAO.deleteRoom(roomId);
    }
}
