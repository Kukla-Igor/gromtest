package finalProject.DAO;

import finalProject.UserType;
import finalProject.exception.InternalServelException;
import finalProject.exception.UserNotFoundException;
import finalProject.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class UserDAO {
    public User findUserById(Long id) throws Exception {
        String line;
        User user;
        int numberOfLine = 1;
        String pathDB = "G://Работа//Java//Gromcod//Java Core//Final Project//BD//UserBD.txt";


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                int i = 0;


                try {
                    user = new User(Long.valueOf(arr[i]), arr[++i].trim(), arr[++i].trim(), arr[++i].trim(), UserType.valueOf(arr[++i].trim()));
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
