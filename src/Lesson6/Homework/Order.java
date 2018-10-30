package Lesson6.Homework;


import java.util.Date;

public class Order {



    long id;
    public static int price;
    public static Date dateCreated;
    public static boolean isConfirmed;
    public static Date dateConfirmed;
    public static String city;
    public static String country;
    public static String type;

    public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }


    public Order() {
    }

    public void confirmOrder(){
        if (isConfirmed == true) {
            return;
        }
        isConfirmed = true;
        dateConfirmed = new Date();
    }

    public  boolean checkPrice(){
        return price > 1000 ? true : false;
    }

    public boolean isValidType(){
        if (type == "Buy" || type == "Sale")
            return true;
        return false;
    }


}
