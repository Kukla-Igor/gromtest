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
        int numberOfLine = 1;


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                hotel = searchHotel(line, name, numberOfLine, pathDB);


                if (hotel != null && hotel.getName().equals(name)) {
                    return hotel;
                } else
                    numberOfLine++;
            }


            throw new UserNotFoundException("Hotel " + name + " not found");
        }
    }


    public Hotel findHotelByCity(String name) throws Exception {
        String line;
        Hotel hotel;
        int numberOfLine = 1;


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                hotel = searchHotel(line, name, numberOfLine, pathDB);


                if (hotel != null && hotel.getCity().equals(name)) {
                    return hotel;
                } else
                    numberOfLine++;
            }


            throw new UserNotFoundException("Hotel in the " + name + " not found");
        }
    }

    public Hotel addHotel(Hotel hotel) throws Exception{
        return (Hotel) add(hotel, pathDB);
    }

    public void deleteHotel (long hotelId) throws Exception{
        delete(hotelId, pathDB);
    }

    private Hotel searchHotel(String line, String search, int numberOfLine, String pathDB) throws InternalServerException{
        if (!line.contains(search))
            return null;

        String[] arr = line.split(",");


        return (Hotel) mapTOObject(arr, numberOfLine);
    }

    @Override
    IdEntity mapTOObject(String[] arr, int numberOfLine) throws InternalServerException {
        Hotel hotel;
        int index = 0;
        try {
            hotel = new Hotel(arr[++index].trim(), arr[++index].trim(), arr[++index].trim(), arr[++index].trim());
            hotel.setId(Long.valueOf(arr[0]));
        } catch (Exception e) {
            throw new InternalServerException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
        }
        return hotel;

    }

    @Override
    void writeToFile(IdEntity idEntity, String pathDB) throws InternalServerException {
        Hotel hotel = (Hotel) idEntity;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDB, true))) {
            bw.append("\n");
            bw.append(hotel.getId() + ", " + hotel.getName() + ", " + hotel.getCountry() + ", " + hotel.getCity() + ", " + hotel.getStreet());
        } catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }
    }
}

