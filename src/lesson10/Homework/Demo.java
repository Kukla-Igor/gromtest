package lesson10.Homework;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Customer customer = new Customer("Nemo", "Odessa", "Men");
        ElectronicsOrder electronicsCustomer = new ElectronicsOrder("radio", new Date(), "Kiev", "Odessa", 150, customer, 5);
        ElectronicsOrder electronicsCustomer1 = new ElectronicsOrder("phone", new Date(), "Kherson", "London", 200, customer, 5);
        FurnitureOrder furnitureCustomer = new FurnitureOrder("Sofa", new Date(), "Kiev", "Rome", 2000, customer, "Code");
        FurnitureOrder furnitureCustomer1 = new FurnitureOrder("chair", new Date(), "Paris", "Rome", 2000, customer, "Code");

        electronicsCustomer.validateOrder();
        electronicsCustomer.calculatePrice();
        electronicsCustomer.confirmShipping();
        electronicsCustomer1.validateOrder();
        electronicsCustomer1.calculatePrice();
        electronicsCustomer1.confirmShipping();
        furnitureCustomer.validateOrder();
        furnitureCustomer.calculatePrice();
        furnitureCustomer.confirmShipping();
        furnitureCustomer1.validateOrder();
        furnitureCustomer1.calculatePrice();
        furnitureCustomer1.confirmShipping();

    }
}
