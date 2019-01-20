package finalProject.demo;

import finalProject.Controller.RoomController;
import finalProject.model.Filter;

import java.util.Date;

public class RoomDemo {
    public static void main(String[] args) throws Exception {

        RoomController roomController = new RoomController();

        Filter filter = new Filter(0, 1000.00, true, false, new Date(13-1-2019), "Hilton", "Egypt", "Sharm");

        System.out.println(roomController.findRooms(filter));
    }
}
