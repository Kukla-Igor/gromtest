package finalProject.DAO;

import finalProject.exception.BadRequestException;
import finalProject.exception.InternalServerException;
import finalProject.model.IdEntity;
import finalProject.model.Order;
import finalProject.model.Room;
import finalProject.model.User;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class OrderDAO extends DAO {

    String pathDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//OrderBD.txt";


    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        User user = (User) new UserDAO().findById(userId);
        Room room = (Room) new RoomDAO().findById(roomId);


        if (room.getHotel().getId() != hotelId)
            throw new BadRequestException("In the hotel with id " + hotelId + " not found room with id " + roomId);


        Calendar dayFrom = Calendar.getInstance();
        Calendar dayTo = Calendar.getInstance();


        dayTo.add(Calendar.DAY_OF_MONTH, 3);


        if (room.getDateAvailableFrom().getTime() > dayFrom.getTimeInMillis())
            throw new BadRequestException("Sorry, the room with id " + roomId + " is busy");


        Order order = new Order(user, room, dayFrom.getTime(), dayTo.getTime(), room.getPrice());


        add(order);

        new RoomDAO().updateDateRoom(room.getDateAvailableFrom(), order.getDateTo(), roomId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        File file = new File(pathDB);
        Order order;
        int numberOfLine = 0;

        List<String> fileContent = new ArrayList<>(Files.readAllLines(file.toPath()));
        for (int i = 0; i < fileContent.size(); i++) {
            String[] arr = fileContent.get(i).split(",");

            try {
                numberOfLine++;
                order = (Order) mapTOObject(arr);


                Room room = order.getRoom();

                if (order.getRoom().getId() == roomId && (order.getUser().getId() == userId) && (new SimpleDateFormat("dd-MM-yyyy").format(room.getDateAvailableFrom()).equals(new SimpleDateFormat("dd-MM-yyyy").format(order.getDateTo())))) {

                    delete(order.getId());

                    new RoomDAO().updateDateRoom(order.getRoom().getDateAvailableFrom(), new Date(), roomId);

                    return;
                }
            } catch (Exception e) {
                throw new InternalServerException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
            }
        }

        throw new BadRequestException("Order with room (id: " + roomId + ") and user (id: " + userId + ") not found");

    }

    @Override
    IdEntity mapTOObject(String[] arr) throws InternalServerException {
        Order order;
        int index = 0;
        try {
            order = new Order(Long.valueOf(arr[index]), (User) new UserDAO().findById(Long.valueOf(arr[++index].trim())), (Room) new RoomDAO().findById(Long.valueOf(arr[++index].trim())), new SimpleDateFormat("dd-MM-yyyy").parse(arr[++index]), new SimpleDateFormat("dd-MM-yyyy").parse(arr[++index]), Double.valueOf(arr[++index]));
            return order;
        } catch (Exception e) {
            throw new InternalServerException("Invalid data of the file " + new File(pathDB).getName());
        }
    }

    @Override
    String path() {
        return pathDB;
    }


}


