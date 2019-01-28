package finalProject.Controller;

import finalProject.DAO.HotelDAO;
import finalProject.Service.HotelService;
import finalProject.exception.BadRequestException;
import finalProject.exception.InternalServelException;
import finalProject.model.Hotel;

public class HotelController {
    HotelService hotelService = new HotelService();

    public Hotel findHotelByName (String name) throws Exception {
        return hotelService.findHotelByName(name);
    }

    public Hotel findHotelByCity (String city) throws Exception {
        return hotelService.findHotelByCity(city);
    }

    public Hotel addHotel(Hotel hotel) throws Exception {
        return hotelService.addHotel(hotel);
    }

    public void deleteHotel(Long hotelId) throws Exception{
        hotelService.deleteHotel(hotelId);
    }
}
