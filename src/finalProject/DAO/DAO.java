package finalProject.DAO;

import finalProject.exception.BadRequestException;
import finalProject.exception.InternalServerException;
import finalProject.exception.UserNotFoundException;
import finalProject.model.IdEntity;
import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public abstract class DAO <T extends IdEntity> {

    abstract T mapTOObject(String[] arr, int numberOfLine) throws InternalServerException;

    abstract void writeToFile(T t, String pathDB) throws InternalServerException;

    public long idGenerator(String pathDB) throws InternalServerException {
        long id = (long) (Math.random()*10000);
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


        if (list.contains(id))
            idGenerator(pathDB);


        return id;
    }

    public T findById(long id, String pathDB) throws Exception {
        String line;
        T t;
        int numberOfLine = 1;


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                t = mapTOObject(arr, numberOfLine);


                if (t.getId() == id){
                    return t;
                } else
                    numberOfLine++;
            }
        }
        throw new   UserNotFoundException("Object with id " + id + " not found");

    }

    public T add(T t, String pathDB) throws Exception {
        t.setId(idGenerator(pathDB));
        String line;


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                if (findById(Long.valueOf(line.substring(0, line.indexOf(','))), pathDB).equals(t))
                    throw new BadRequestException(t + " already in the database");
            }
        } catch (IOException e) {
            System.err.println("Can`t read file: " + pathDB);
        }

        writeToFile(t, pathDB);

        return t;
    }

    public void delete(long Id, String pathDB) throws Exception {
        File file = new File(pathDB);
        T t;
        int numberOfLine = 1;


        List<String> fileContent = new ArrayList<>(Files.readAllLines(file.toPath()));
        for (int i = 0; i < fileContent.size(); i++) {
            String[] arr = fileContent.get(i).split(",");

            try {
                t = mapTOObject(arr, numberOfLine);


                if (t.getId() == Id) {
                    fileContent.remove(i);
                    Files.write(file.toPath(), fileContent);
                    return;
                }
            } catch (Exception e) {
                throw new InternalServerException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
            }
        }

        throw new BadRequestException("Object with id: " + Id + " not found");

    }
}

