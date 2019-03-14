package finalProject.DAO;

import finalProject.exception.InternalServerException;
import finalProject.exception.UserNotFoundException;
import finalProject.model.Hotel;
import finalProject.model.IdEntity;
import java.io.*;

public class HotelDAO extends DAO{
    String pathDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//HotelBD.txt";


    public Hotel findHotelByName(String name) throws Exception {
        String line;
        Hotel hotel;


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                hotel = searchHotel(line, name);


                if (hotel != null && hotel.getName().equals(name)) {
                    return hotel;
                }
            }
            throw new UserNotFoundException("Hotel " + name + " not found");
        }
    }


    public Hotel findHotelByCity(String name) throws Exception {
        String line;
        Hotel hotel;

        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                hotel = searchHotel(line, name);


                if (hotel != null && hotel.getCity().equals(name)) {
                    return hotel;
                }
            }


            throw new UserNotFoundException("Hotel in the " + name + " not found");
        }
    }

    public Hotel addHotel(Hotel hotel) throws Exception{
        return (Hotel) add(hotel);
    }

    public void deleteHotel (long hotelId) throws Exception{
        delete(hotelId);
    }

    private Hotel searchHotel(String line, String search) throws InternalServerException{
        if (!line.contains(search))
            return null;

        String[] arr = line.split(",");


        return (Hotel) mapTOObject(arr);
    }

    @Override
    IdEntity mapTOObject(String[] arr) throws InternalServerException {
        Hotel hotel;
        int index = 0;
        try {
            hotel = new Hotel(arr[++index].trim(), arr[++index].trim(), arr[++index].trim(), arr[++index].trim());
            hotel.setId(Long.valueOf(arr[0]));
        } catch (Exception e) {
            throw new InternalServerException("Invalid data of the file " + new File(pathDB).getName());
        }
        return hotel;

    }
    @Override
    String path() {
        return pathDB;
    }

}

