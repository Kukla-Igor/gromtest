package finalProject.DAO;

import finalProject.exception.BadRequestException;
import finalProject.exception.InternalServerException;
import finalProject.exception.UserNotFoundException;
import finalProject.model.IdEntity;
import java.io.*;
import java.util.*;

public abstract class DAO<T extends IdEntity> {
    abstract T mapTOObject(String[] arr) throws InternalServerException;
    abstract String path();


    public long idGenerator() throws InternalServerException {

        String pathDB = path();
        long id =Math.round(Math.random()*Long.MAX_VALUE);
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
            id = idGenerator();


        return id;
    }

    public T findById(long id) throws Exception {

        ArrayList<T> list = createList();

        for (T t : list) {

            if (t.getId() == id) {
                return t;
            }
        }
        throw new UserNotFoundException("Object with id " + id + " not found");

    }

    public T add(T t) throws Exception {
        t.setId(idGenerator());
        ArrayList<T> list = createList();

        for (T m : list) {

            if (t.equals(m)) {
                throw new BadRequestException(t + " already in the database");
            }
        }

        writeToFile(t);
        return t;
    }

    public void delete(long id) throws Exception {


        ArrayList<T> list = createList();

        for (int i = 0; i < list.size(); i++) {

            if (id == list.get(i).getId()) {
                list.remove(i);
                reWriter(list);
                return;
            }
        }

        throw new BadRequestException("Object with id: " + id + " not found");
    }

    private void reWriter(ArrayList list){
        String pathDB = path();
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDB))) {
            for (int i = 0; i < list.size() - 1; i++) {
                bw.append(list.get(i).toString());
                bw.append('\n');
            }

            bw.append((list.get(list.size() - 1).toString()));
        } catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }
    }



    void writeToFile(T t) {
        String pathDB = path();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDB, true))) {
            bw.append("\n");
            bw.append(t.toString());
        } catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }
    }

    private ArrayList<T> createList() throws Exception {
        String pathDB = path();
        String line;
        ArrayList<T> list = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                list.add(mapTOObject(arr));
            }
        } catch (IOException e) {
            System.err.println("Can`t read file: " + pathDB);
        }

        return list;
    }
}

