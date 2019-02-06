package finalProject.demo;

import finalProject.Controller.RoomController;
import finalProject.model.Filter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RoomDemo {
    public static void main(String[] args) throws Exception {

        RoomController roomController = new RoomController();

        Filter filter = new Filter(5, 1050.26, false, true, new SimpleDateFormat("dd-MM-yyyy").parse("01-02-2019"), "Fregat", null, "Kherson");

        System.out.println(roomController.findRooms(filter));
    }
}
