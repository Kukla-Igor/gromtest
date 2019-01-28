package finalProject.DAO;

import finalProject.UserType;
import finalProject.exception.BadRequestException;
import finalProject.exception.InternalServelException;
import finalProject.exception.UserNotFoundException;
import finalProject.model.User;

import java.io.*;

public class UserDAO {
    String pathDB =  "G://Работа//Java//Gromcod//Java Core//Final Project//BD//UserBD.txt";

    public User registerUser(User user) throws Exception{

        user.setId(new DAO().idGenerator(pathDB));
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null){
                if (findUserById(Long.valueOf(line.substring(0, line.indexOf(',')))).equals(user))
                    throw new BadRequestException("User "  + user + " already in the database");
            }
        }catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDB, true))) {
            bw.append("\n");
            bw.append(user.getId() + ", " + user.getUserName() + ", " + user.getPassword() + ", " + user.getCountry() + ", " + user.getUserType());
        } catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }

        return user;
    }


    public User findUserById(Long id) throws Exception {
        String line;
        User user;
        int numberOfLine = 1;



        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                int i = 0;


                try {
                    user = new User(arr[++i].trim(), arr[++i].trim(), arr[++i].trim(), UserType.valueOf(arr[++i].trim()));
                    user.setId(Long.valueOf(arr[0]));
                } catch (Exception e) {
                    throw new InternalServelException("Invalid data in line " + numberOfLine + " of the file " + new File(pathDB).getName());
                }


                if (user.getId() == id) {
                    return user;
                }else
                    numberOfLine++;
            }


            throw new UserNotFoundException("User with id: " + id + " not found");
        }
    }
}
