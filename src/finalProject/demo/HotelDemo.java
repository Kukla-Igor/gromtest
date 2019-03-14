package finalProject.demo;

import finalProject.Controller.HotelController;
import finalProject.model.Hotel;

public class HotelDemo {
    public static void main(String[] args) throws Exception {
        HotelController hotelController = new HotelController();

//        System.out.println(hotelController.findHotelByName("Fregat"));
//        System.out.println(hotelController.findHotelByCity("Kherson"));

        Hotel hotel = new Hotel("Sea2", "Greece", "Poltava", "Kanatnaya");

        //System.out.println(hotelController.addHotel(hotel));



        hotelController.deleteHotel( (long) 555);
    }
}
