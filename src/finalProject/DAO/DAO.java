package finalProject.DAO;

import finalProject.DAO.abstractModel.IdEntity;
import finalProject.exception.InternalServelException;
import finalProject.exception.UserNotFoundException;
import finalProject.model.Room;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public  class DAO<T extends IdEntity>{

    public long idGenerator(String pathDB) throws InternalServelException {
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
            throw new InternalServelException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
        }

        while (list.contains(id))
            id++;
        return id;
    }

    public T findById(Long id, String pathDB) throws Exception {
        String line;
        T t;
        int numberOfLine = 1;


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");

                try {
                    t =  newCreate(arr);
                } catch (Exception e) {
                    throw new InternalServelException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
                }


                if (t.getId() == id) {
                    return t;
                } else
                    numberOfLine++;
            }


            throw new UserNotFoundException("Room with id: " + id + " not found");
        }
    }





}
