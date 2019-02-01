package finalProject.DAO;

import finalProject.exception.BadRequestException;
import finalProject.exception.InternalServerException;
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

public class OrderDAO {


    public void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        User user = new UserDAO().findUserById(userId);

       Room room = new RoomDAO().findRoomById(roomId);


        if (room.getHotel().getId() != hotelId)
            throw new BadRequestException("In the hotel with id " + hotelId + " not found room with id " + roomId);


        Calendar dayFrom = Calendar.getInstance();
        Calendar dayTo = Calendar.getInstance();
        String pathDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//OrderBD.txt";


        dayTo.add(Calendar.DAY_OF_MONTH, 3);


        if (room.getDateAvailableFrom().getTime() > dayFrom.getTimeInMillis())
            throw new BadRequestException("Sorry, the room with id " + roomId + " is busy");


        Order order = new Order(new DAO().idGenerator(pathDB), user, room, dayFrom.getTime(), dayTo.getTime(), room.getPrice());
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");


        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDB, true))) {
            bw.append("\n");
            bw.append(order.getId() + ", " + order.getUser().getId() + ", " + order.getRoom().getId() + ", " + simple.format(order.getDateFrom()) + ", " + simple.format(order.getDateTo()) + ", " + order.getMoneyPaid());
            new RoomDAO().updateDateRoom(room.getDateAvailableFrom(), order.getDateTo(), roomId);
        } catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }
    }

    public void cancelReservation(long roomId, long userId) throws Exception {
        String pathDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//OrderBD.txt";
        File file = new File(pathDB);
        Order order;
        int numberOfLine = 1;



        List<String> fileContent = new ArrayList<>(Files.readAllLines(file.toPath()));
        for (int i = 0; i < fileContent.size(); i++) {
            int index = 0;
            String[] arr = fileContent.get(i).split(",");

            try {

                order = new Order(Long.valueOf(arr[index]), new UserDAO().findUserById(Long.valueOf(arr[++index].trim())), new RoomDAO().findRoomById(Long.valueOf(arr[++index].trim())), new SimpleDateFormat("dd-MM-yyyy").parse(arr[++index]), new SimpleDateFormat("dd-MM-yyyy").parse(arr[++index]), Double.valueOf(arr[++index]));
                numberOfLine++;

            if (order.getRoom().getId() == roomId && (order.getUser().getId() == userId)) {

                fileContent.remove(i);
                Files.write(file.toPath(), fileContent);

                new RoomDAO().updateDateRoom(order.getRoom().getDateAvailableFrom(), new Date(), roomId);

                return;
            }
            }catch (Exception e){
                throw new InternalServerException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
            }
        }

        throw new BadRequestException("Order with room (id: " + roomId + ") and user (id: " + userId + ") not found");

    }



}
