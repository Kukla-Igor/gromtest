package finalProject.Controller;

import finalProject.DAO.HotelDAO;
import finalProject.Service.HotelService;
import finalProject.model.Hotel;

public class HotelController {
    HotelService hotelService = new HotelService();

    public Hotel findHotelByName (String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public Hotel findHotelByCity (String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }
}
