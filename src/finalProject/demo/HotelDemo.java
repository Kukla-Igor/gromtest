package finalProject.demo;

import finalProject.Controller.HotelController;

public class HotelDemo {
    public static void main(String[] args) throws Exception {
        HotelController hotelController = new HotelController();

        System.out.println(hotelController.findHotelByName("Fregat"));
        System.out.println(hotelController.findHotelByCity("Kherson"));
    }
}
