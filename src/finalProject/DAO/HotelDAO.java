package finalProject.DAO;

import finalProject.exception.BadRequestException;
import finalProject.exception.InternalServelException;
import finalProject.exception.UserNotFoundException;
import finalProject.model.Hotel;
import finalProject.model.Order;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HotelDAO  {
    String pathDB =  "G://Работа//Java//Gromcod//Java Core//Final Project//BD//HotelBD.txt";

    public Hotel findHotelByName(String name) throws Exception {
        String line;
        Hotel hotel;
        int numberOfLine = 1;


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

    public Hotel addHotel(Hotel hotel) throws Exception{

        hotel.setId(new DAO().idGenerator(pathDB));

        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null){
                if (findHotelById(Long.valueOf(line.substring(0, line.indexOf(',')))).equals(hotel))
                    throw new BadRequestException(hotel + " already in the database");
            }
        }catch (IOException e) {
            System.err.println("Can`t read file: " + pathDB);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDB, true))) {
            bw.append("\n");
            bw.append(hotel.getId() + ", " + hotel.getName() + ", " + hotel.getCountry() + ", " + hotel.getCity() + ", " + hotel.getStreet());
        } catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }

        return hotel;
    }

    public void deleteHotel (long hotelId) throws Exception{
        File file = new File(pathDB);
        Hotel hotel;
        int numberOfLine = 1;


        List<String> fileContent = new ArrayList<>(Files.readAllLines(file.toPath()));
        for (int i = 0; i < fileContent.size(); i++) {
            int index = 0;
            String[] arr = fileContent.get(i).split(",");

            try {

                hotel = new Hotel(arr[++index], arr[++index], arr[++index], arr[++index]);
                hotel.setId(Long.valueOf(arr[0]));
                numberOfLine++;

                if (hotel.getId() == hotelId) {

                    fileContent.remove(i);
                    Files.write(file.toPath(), fileContent);

                    return;
                }
            }catch (Exception e){
                throw new InternalServelException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
            }
        }

        throw new BadRequestException("Hotel with id: " + hotelId + " not found");

    }

    public Hotel findHotelById(Long id)  throws Exception  {
        String line;
        Hotel hotel;
        int numberOfLine = 1;


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
            hotel = new Hotel(arr[++i].trim(), arr[++i].trim(), arr[++i].trim(), arr[++i].trim());
            hotel.setId(Long.valueOf(arr[0]));
        } catch (Exception e) {
            throw new InternalServelException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
        }


        return hotel;
    }
}
