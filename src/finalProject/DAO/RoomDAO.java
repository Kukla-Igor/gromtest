package finalProject.DAO;

import finalProject.exception.InternalServerException;
import finalProject.exception.UserNotFoundException;
import finalProject.model.Filter;
import finalProject.model.Hotel;
import finalProject.model.IdEntity;
import finalProject.model.Room;
import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RoomDAO extends DAO {
    private String pathDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//RoomBD.txt";
    private String pathHotelDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//HotelBD.txt";


    public ArrayList<Room> findRooms(Filter filter) throws Exception {
        ArrayList<Room> list = new ArrayList<>();
        String line;
        Room room;
        int numberOfLine = 1;
        HotelDAO hotelDAO = new HotelDAO();


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                int i = 0;
                Hotel hotel = (Hotel) hotelDAO.findById(Long.valueOf(arr[arr.length - 1].trim()), pathHotelDB);
                SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");


                if (hotelCheck(hotel, filter) != null) {
                    room = new Room(Long.valueOf(arr[i].trim()), Integer.valueOf(arr[++i].trim()), Double.valueOf(arr[++i].trim()), Boolean.valueOf(arr[++i].trim()), Boolean.valueOf(arr[++i].trim()), sd.parse(arr[++i]), hotel);
                    numberOfLine++;
                } else
                    continue;


                if (roomCheck(room, filter) != null)
                    list.add(room);
            }
        } catch (Exception e) {
            throw new InternalServerException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
        }


        if (list.isEmpty())
            throw new UserNotFoundException("Found nothing");


        return list;
    }


    public void updateDateRoom(Date oldDate, Date newDate, long id) throws InternalServerException {
        File file = new File(pathDB);
        SimpleDateFormat simple = new SimpleDateFormat("dd-MM-yyyy");
        String stringOldDate = simple.format(oldDate);


        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(file.toPath()));
            for (int i = 0; i < fileContent.size(); i++) {
                if (fileContent.get(i).contains(stringOldDate) && fileContent.get(i).substring(0, fileContent.get(i).indexOf(',')).equals(String.valueOf(id))) {
                    String line = fileContent.get(i);
                    line = line.replace((simple.format(oldDate)).trim(), (simple.format(newDate)).trim());
                    fileContent.set(i, line);
                    Files.write(file.toPath(), fileContent);
                    break;
                }
            }
        } catch (IOException e) {
            throw new InternalServerException("something wrong in updateRoom");
        }
    }


    public Room addRoom(Room room) throws Exception {

        return (Room) add(room, pathDB);
    }


    public void deleteRoom(long roomId) throws Exception {
        delete(roomId, pathDB);
    }


    private Hotel hotelCheck(Hotel hotel, Filter filter) {
        if ((filter.getName() == null || filter.getName().equals(hotel.getName())) && (filter.getCountry() == null || filter.getCountry().equals(hotel.getCountry())) && (filter.getCity() == null || filter.getCity().equals(hotel.getCity())))
            return hotel;
        return null;
    }


    private Room roomCheck(Room room, Filter filter) {
        if ((filter.getNumberOfGuests() == 0 || filter.getNumberOfGuests() == room.getNumberOfGuests()) && (filter.getPrice() == 0 || filter.getPrice() == room.getPrice()) && (filter.isBreakfastIncluded() == room.isBreakfastIncluded()) && (filter.isPetsAllowed() == room.isPetsAllowed()) && (filter.getDateAvailableFrom() == null || filter.getDateAvailableFrom().equals(room.getDateAvailableFrom())))
            return room;
        return null;

    }

    @Override
    IdEntity mapTOObject(String[] arr, int numberOfLine) throws InternalServerException {
        Room room;
        int index = 0;
        try {
            room = new Room(Long.valueOf(arr[index]), Integer.valueOf(arr[++index].trim()), Double.valueOf(arr[++index].trim()), Boolean.valueOf(arr[++index].trim()), Boolean.valueOf(arr[++index].trim()), new SimpleDateFormat("dd-MM-yyyy").parse(arr[++index]), (Hotel) new HotelDAO().findById(Long.valueOf(arr[++index].trim()), pathHotelDB));
            return room;
        } catch (Exception e) {
            throw new InternalServerException("Invalid data in line " + arr[0] + " of the file " + new File(pathDB).getName());
        }
    }

    @Override
    void writeToFile(IdEntity idEntity, String pathDB)  {
        Room room = (Room) idEntity;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDB, true))) {
            bw.append("\n");
            bw.append(room.getId() + ", " + room.getNumberOfGuests() + ", " + room.getPrice() + ", " + room.isBreakfastIncluded() + ", " + room.isPetsAllowed() + ", " + room.getDateAvailableFrom() + ", " + room.getHotel());
        } catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }
    }
}
