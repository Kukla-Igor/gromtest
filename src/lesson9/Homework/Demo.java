package lesson9.Homework;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
       User[] users = new User[3];

       users [0] = new User(0, "00", "55");
       users [1] = new User(1, "11", "55");
       users [2] = new User(2, "22", "55");


       UserRepository user = new UserRepository(users);

        System.out.println(Arrays.toString(user.getUserNames()));

       users[0] = null;

        user = new UserRepository(users);

        System.out.println(Arrays.toString(user.getUserNames()));


        user = null;

        System.out.println(Arrays.toString(user.getUserNames()));


    }
}