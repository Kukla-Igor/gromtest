package lesson10.Homework;

import java.util.Date;

public class ElectronicsOrder extends Order {
    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonth) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }

    @Override
    public void validateOrder() {
        if (getShipFromCity() == "Kiev" || getShipFromCity() == "Odessa" || getShipFromCity() == "Dnepr" || getShipFromCity() == "Kharkov" || getBasePrice() >= 100 || getCustomerOwned().getGender() == "Female" || getShipToCity() == "Kiev" || getShipToCity() == "Odessa" || getShipToCity() == "Dnepr" || getShipToCity() == "Kharkov")
            calculatePrice();
    }

    @Override
    public void calculatePrice() {
        double shippedPrice;
        double totalPrice;

        if (getShipToCity() == "Kiev" || getShipToCity() == "Odessa" )
            shippedPrice = 0.1 * getBasePrice();
        else
            shippedPrice = 0.15 * getBasePrice();

        totalPrice = shippedPrice + getBasePrice();

        if (totalPrice > 1000)
            setTotalPrice(totalPrice * 0.95);
        else
            setTotalPrice(totalPrice);

    }
}
