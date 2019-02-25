package finalProject.DAO;

import finalProject.exception.BadRequestException;
import finalProject.exception.InternalServerException;
import finalProject.exception.UserNotFoundException;
import finalProject.model.IdEntity;
import java.io.*;
import java.nio.file.Files;
import java.util.*;

public abstract class DAO <T extends IdEntity> {


    abstract T mapTOObject(String[] arr, int numberOfLine) throws InternalServerException;

    abstract String toString(T t);

    public long idGenerator(String pathDB) throws InternalServerException {

        Random random = new Random();
        long id = random.nextLong();
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
            id = idGenerator(pathDB);


        return id;
    }

    public T findById(long id, String pathDB) throws Exception {

        ArrayList<T> list = createList(pathDB);

        for (T t:list) {

                if (t.getId() == id){
                    return t;
                }
        }
        throw new   UserNotFoundException("Object with id " + id + " not found");

    }

    public T add(T t, String pathDB) throws Exception {
        t.setId(idGenerator(pathDB));

        ArrayList<T> list = createList(pathDB);

        for (T m:list) {

            if (m.equals(t)){
                throw new BadRequestException(t + " already in the database");
            }
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

    void writeToFile(T t, String pathDB) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDB, true))) {
            bw.append("\n");
            bw.append(toString(t));
        } catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }
    }

    private ArrayList<T> createList (String pathDB) throws Exception{
        String line;
        ArrayList<T> list = new ArrayList<>();
        int numberOfLine = 1;


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                list.add(mapTOObject(arr, numberOfLine));
                numberOfLine++;
            }
        } catch (IOException e) {
            System.err.println("Can`t read file: " + pathDB);
        }

        return list;
    }
}

