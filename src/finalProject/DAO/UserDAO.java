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


        user.setId(idGenerator(pathDB));
        String line;


        try (BufferedReader br = new BufferedReader(new FileReader(pathDB))) {
            while ((line = br.readLine()) != null){
                if (findById(Long.valueOf(line.substring(0, line.indexOf(','))), pathDB).equals(user))
                    throw new BadRequestException("User "  + user + " already in the database");
            }
        }catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }


       writeToFile(user, pathDB);


        return user;
    }

    @Override
    IdEntity mapTOObject(String[] arr, int numberOfLine) throws InternalServerException {
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
    void writeToFile(IdEntity idEntity, String pathDB) {
        User user = (User) idEntity;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathDB, true))) {
            bw.append("\n");
            bw.append(user.getId() + ", " + user.getUserName() + ", " + user.getPassword() + ", " + user.getCountry() + ", " + user.getUserType());
        } catch (IOException e) {
            System.err.println("Can`t write to file: " + pathDB);
        }
    }
}
