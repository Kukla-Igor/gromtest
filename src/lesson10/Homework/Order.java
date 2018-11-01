package lesson10.Homework;

import java.util.Date;

public abstract class Order {
    private String itemName;
    private Date dateCreate;
    private Date dateConfirmed;
    private Date dateShipped;
    private String shipFromCity;
    private String shipToCity;
    private int basePrice;
    private double totalPrice;
    private Customer customerOwned;

    public Order(String itemName, Date dateCreate, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        this.itemName = itemName;
        this.dateCreate = dateCreate;
        this.shipFromCity = shipFromCity;
        this.shipToCity = shipToCity;
        this.basePrice = basePrice;
        this.customerOwned = customerOwned;
    }

    abstract void validateOrder();
    abstract void calculatePrice();

    void confirmShipping() {
        if (dateShipped == null)
           dateShipped = new Date();

    }

    public Date getDateConfirmed() {
        return dateConfirmed;
    }

    public void setDateConfirmed(Date dateConfirmed) {
        this.dateConfirmed = dateConfirmed;
    }

    public Date getDateShipped() {
        return dateShipped;
    }

    public void setDateShipped(Date dateShipped) {
        this.dateShipped = dateShipped;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getItemName() {
        return itemName;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public String getShipFromCity() {
        return shipFromCity;
    }

    public String getShipToCity() {
        return shipToCity;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Customer getCustomerOwned() {
        return customerOwned;
    }
}
