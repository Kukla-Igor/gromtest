package lesson15.homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User user = new User(0, "Alex0", "www0");
        User user1 = new User(1, "Alex1", "www1");
        User user2 = new User(2, "Alex2", "www2");
        User user3 = new User(3, "Alex3", "www3");
        User[] users = {null, user1, user2};

        UserRepository userRepository = new UserRepository(users);

       User userNew = new User(1, "AlexNew", "www1");

        System.out.println(userRepository.update(userNew));

        System.out.println(users[1]);
    }
}
