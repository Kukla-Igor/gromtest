package finalProject.DAO;

import finalProject.exception.InternalServelException;
import finalProject.exception.UserNotFoundException;
import finalProject.model.Hotel;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;

public class HotelDAO  {
    public Hotel findHotelByName(String name) throws Exception {
        String line;
        Hotel hotel;
        int numberOfLine = 1;
        String pathDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//HotelBD.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                hotel = searchHotel(line, name, numberOfLine, pathDB);


                if (hotel != null && hotel.getName().equals(name)) {
                    return hotel;
                }else
                    numberOfLine++;
            }


            throw new UserNotFoundException("Hotel " + name + " not found");
        }
    }

    public Hotel findHotelByCity(String name) throws Exception {
        String line;
        Hotel hotel;
        int numberOfLine = 1;
        String pathDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//HotelBD.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                hotel = searchHotel(line, name, numberOfLine, pathDB);


                if (hotel != null && hotel.getCity().equals(name)) {
                    return hotel;
                }else
                    numberOfLine++;
            }


            throw new UserNotFoundException("Hotel in the " + name + " not found");
        }
    }

    public Hotel findHotelById(Long id) throws Exception {
        String line;
        Hotel hotel;
        int numberOfLine = 1;
        String pathDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//HotelBD.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                hotel = searchHotel(line, "" + id, numberOfLine, pathDB);


                if (hotel != null && hotel.getId() == id) {
                    return hotel;
                }else
                    numberOfLine++;
            }


            throw new UserNotFoundException("Hotel with id: " + id + " not found");
        }
    }




    private Hotel searchHotel(String line, String search, int numberOfLine, String pathDB) throws Exception{
        if (!line.contains(search))
            return null;


        Hotel hotel;


        String[] arr = line.split(",");
        int i = 0;


        try {
            hotel = new Hotel(Long.valueOf(arr[i]), arr[++i].trim(), arr[++i].trim(), arr[++i].trim(), arr[++i].trim());
        } catch (Exception e) {
            throw new InternalServelException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
        }


        return hotel;
    }
}
