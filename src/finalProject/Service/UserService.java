package finalProject.Service;

import finalProject.DAO.UserDAO;
import finalProject.model.User;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws Exception {
        return userDAO.registerUser(user);
    }
}
