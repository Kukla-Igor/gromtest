package finalProject.demo;

import finalProject.Controller.RoomController;
import finalProject.model.Filter;
import finalProject.model.Hotel;
import finalProject.model.Room;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomDemo {
    public static void main(String[] args) throws Exception {

        RoomController roomController = new RoomController();



        //Filter filter = new Filter(5, 1050.26, false, true, new SimpleDateFormat("dd-MM-yyyy").parse("01-02-2019"), "Fregat", null, "Kherson");

        Hotel hotel = new Hotel(0,"Hilton", "Egypt", "Sharm", "Soho");

        Room room = new Room(5, 100.00, false, true, new Date(), hotel);
        System.out.println(roomController.addRoom(room));
    }
}
