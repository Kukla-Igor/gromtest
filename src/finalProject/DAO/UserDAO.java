package finalProject.DAO;

import finalProject.UserType;
import finalProject.exception.BadRequestException;
import finalProject.exception.InternalServerException;
import finalProject.model.IdEntity;
import finalProject.model.User;
import java.io.*;


public class UserDAO extends DAO {
    private String pathDB =  "G://Работа//Java//Gromcod//Java Core//Final Project//BD//UserBD.txt";


    public User registerUser(User user) throws Exception{

        return (User) add(user);

    }

    @Override
    IdEntity mapTOObject(String[] arr) throws InternalServerException {
        try {
            User user;
            int index = 0;
            user = new User(arr[++index].trim(), arr[++index].trim(), arr[++index].trim(), UserType.valueOf(arr[++index].trim()));
            user.setId(Long.valueOf(arr[0].trim()));
            return user;
        } catch (Exception e) {
            throw new InternalServerException("Invalid data in line " + arr[0] + " of the file " + new File(pathDB).getName());
        }
    }

    @Override
    String path() {
        return pathDB;
    }


}
