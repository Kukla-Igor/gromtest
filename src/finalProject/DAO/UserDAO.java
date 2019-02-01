package finalProject.DAO;

import finalProject.UserType;
import finalProject.exception.BadRequestException;
import finalProject.exception.InternalServerException;
import finalProject.model.User;
import java.io.*;


public class UserDAO {
    private String pathDB =  "G://Работа//Java//Gromcod//Java Core//Final Project//BD//UserBD.txt";
    private DAO dao = new DAO();


    public User registerUser(User user) throws Exception{


        user.setId(dao.idGenerator(pathDB));
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
        String[] arr = dao.getStringArr(id, pathDB);
        int i = 0;


        try {
            User user = new User(arr[++i].trim(), arr[++i].trim(), arr[++i].trim(), UserType.valueOf(arr[++i].trim()));
            user.setId(id);
            return user;
        } catch (Exception e) {
            throw new InternalServerException("Invalid data in line " + arr[0] + " of the file " + new File(pathDB).getName());
        }
    }
}
