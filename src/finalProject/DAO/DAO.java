package finalProject.DAO;

import finalProject.exception.InternalServerException;
import finalProject.exception.UserNotFoundException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class DAO {


    public long idGenerator(String pathDB) throws InternalServerException {
        long id = 0;
        int numberOfLine = 1;
        ArrayList<Long> list = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Long.valueOf(line.substring(0, line.indexOf(','))));
                numberOfLine++;
            }
        } catch (Exception e) {
            throw new InternalServerException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
        }


        while (list.contains(id))
            id++;


        return id;
    }


    public String[] getStringArr(long id, String pathDB) throws Exception {
        String line;
        String[] arr;
        int numberOfLine = 0;


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                numberOfLine++;
                arr = line.split(",");

                if (Long.valueOf(arr[0]) == id) {
                    arr[0] = "" + numberOfLine;
                    return arr;
                }
            }


        } catch (Exception e) {
            throw new InternalServerException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
        }
        throw new UserNotFoundException("Object with id " + id + " not found");
    }
}
