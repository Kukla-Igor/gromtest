package finalProject.DAO;

import finalProject.exception.InternalServelException;

import finalProject.model.Filter;
import finalProject.model.Hotel;
import finalProject.model.Room;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.Date;

public class RoomDAO {

    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> list = new ArrayList<>();
        String line;
        Room room;
        int numberOfLine = 0;
        String pathDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//RoomBD.txt";
        HotelDAO hotelDAO = new HotelDAO();


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                int i = 0;


                Hotel hotel = hotelDAO.findHotelById(Long.valueOf(arr[arr.length - 1].trim()));

                try {

                    if (hotelCheck(hotel, filter) != null) {
                        room = new Room(Integer.valueOf(arr[i].trim()), Double.valueOf(arr[++i].trim()), Boolean.valueOf(arr[++i].trim()), Boolean.valueOf(arr[++i].trim()), new Date(Integer.valueOf(arr[++i].trim())), hotel);
                        numberOfLine++;
                    } else
                        continue;
                } catch (Exception e) {
                    throw new InternalServelException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
                }

                if (roomCheck(room, filter) != null)
                    list.add(room);
            }
        }
        return list;
    }


    private Hotel hotelCheck(Hotel hotel, Filter filter) {
        if ((filter.getName() != null && filter.getName().equals(hotel.getName())) && (filter.getCountry() != null && filter.getCountry().equals(hotel.getCountry())) && (filter.getCity() != null && filter.getCity().equals(hotel.getCity())))
            return hotel;
        return null;
    }

    private Room roomCheck(Room room, Filter filter) {
        if ((filter.getNumberOfGuests() != 0 && filter.getNumberOfGuests() == room.getNumberOfGuests()) && (filter.getPrice() != 0 && filter.getPrice() == room.getPrice()) && (filter.isBreakfastIncluded() == room.isBreakfastIncluded()) && (filter.isPetsAllowed() == room.isPetsAllowed()) && (filter.getDateAvailableFrom() != null && filter.getDateAvailableFrom() == room.getDateAvailableFrom()))
            return room;
        return null;

    }


}
