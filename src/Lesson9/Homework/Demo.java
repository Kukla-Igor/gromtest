package Lesson9.Homework;

import Lesson9.Homework.UserRepository;

public class Demo {
    public static void main(String[] args) {
       User[] users = new User[3];

       //users [0] = new User(0, "00", "55");
       users [1] = new User(1, "11", "55");
       users [2] = new User(2, "22", "55");


       UserRepository user = new UserRepository(users);


        //System.out.println(user.getUserByName("00").getName());
        //System.out.println(user.getUserByName("11").getId());
        System.out.println(user.getUserByName(""));





    }
}