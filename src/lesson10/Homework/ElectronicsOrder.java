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
        if ((getShipFromCity() == "Kiev" || getShipFromCity() == "Odessa" || getShipFromCity() == "Dnieper" || getShipFromCity() == "Kharkov") && getBasePrice() >= 100 && getCustomerOwned().getGender() == "Female" && (getShipToCity() == "Kiev" || getShipToCity() == "Odessa" || getShipToCity() == "Dnieper" || getShipToCity() == "Kharkov"))
            calculatePrice();
    }

    @Override
    public void calculatePrice() {
        double shippedPrice;
        double totalPrice = getBasePrice();

        if (getBasePrice() > 1000)
            totalPrice *= 0.95 ;


        if (getShipToCity() == "Kiev" || getShipToCity() == "Odessa" )
            shippedPrice = 0.1 * getBasePrice();
        else
            shippedPrice = 0.15 * getBasePrice();

        setTotalPrice(shippedPrice + totalPrice);

    }
}
