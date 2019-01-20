package finalProject.model;

import finalProject.UserType;

public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;


    public User(String userName, String password, String country, UserType userType) {
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }
}
