package lesson30.homework;

import java.util.ArrayList;

public class CustomerDAO {
    private Customer billy = new Customer("Billy", "USA", 1000);
    private Customer garry = new Customer("Garry", "Ukraine", 1500);
    private Customer jack = new Customer("Jack", "Germany", 500);

    public Customer getBilly() {
        return billy;
    }

    public Customer getGarry() {
        return garry;
    }

    public Customer getJack() {
        return jack;
    }

    public ArrayList<Customer> getAll() {
        ArrayList<Customer> list = new ArrayList<>();
        list.add(billy);
        list.add(garry);
        list.add(jack);
        return list;
    }
}
