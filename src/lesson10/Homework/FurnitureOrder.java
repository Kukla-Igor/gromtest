package lesson10.Homework;

import java.util.Date;

public class FurnitureOrder extends Order {
   private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    public void validateOrder() {
        if (getShipFromCity() == "Kiev" || getShipFromCity() == "Lvov" ||  getBasePrice() >= 500 || getCustomerOwned().getName() != "Test")
            calculatePrice();

    }

    @Override
    public void calculatePrice() {
        double totalPrice;

        if (getTotalPrice() < 5000)
            totalPrice = getTotalPrice() + 0.05 * getTotalPrice();
        else
            totalPrice = getTotalPrice() + 0.02 * getTotalPrice();

        setTotalPrice(totalPrice);
    }
}
