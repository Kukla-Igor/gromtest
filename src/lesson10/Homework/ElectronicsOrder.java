package lesson10.Homework;

import java.util.Date;

public class ElectronicsOrder extends Order {
    int guaranteeMonth;

    public ElectronicsOrder(String itemName, Date dateCreate, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonth) {
        super(itemName, dateCreate, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonth = guaranteeMonth;
    }

    @Override
    void validateOrder() {
        if (getShipFromCity() == "Kiev" || getShipFromCity() == "Odessa" || getShipFromCity() == "Dnepr" || getShipFromCity() == "Kharkov" || getBasePrice() >= 100 || getCustomerOwned().getGender() == "Female" || getShipToCity() == "Kiev" || getShipToCity() == "Odessa" || getShipToCity() == "Dnepr" || getShipToCity() == "Kharkov")
            calculatePrice();
    }

    @Override
    void calculatePrice() {
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
