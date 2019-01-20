package finalProject.Service;

import finalProject.DAO.HotelDAO;
import finalProject.exception.BadRequestException;
import finalProject.model.Hotel;

public class HotelService {

    HotelDAO hotelDAO = new HotelDAO();

    public Hotel findHotelByName (String name) throws Exception {
        if (name.isEmpty())
            throw new BadRequestException("You do not enter the name of the hotel");
        return hotelDAO.findHotelByName(name);
    }

    public Hotel findHotelByCity (String city) throws Exception {
        if (city.isEmpty())
            throw new BadRequestException("You do not enter the name of the hotel");
        return hotelDAO.findHotelByCity(city);
    }
    }
