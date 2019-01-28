package finalProject.Controller;
import finalProject.Service.UserService;
import finalProject.exception.InternalServelException;
import finalProject.model.User;

public class UserController {
    UserService userService = new UserService();

    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }
}
