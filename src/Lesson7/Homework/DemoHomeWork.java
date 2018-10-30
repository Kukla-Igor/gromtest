package Lesson7.Homework;

import Lesson6.Homework.Order;

import java.util.Date;

public class DemoHomeWork {


    public static Order createOrder() {
        Order newOrder = new Order();
        newOrder.price = 100;
        newOrder.dateCreated = new Date();
        newOrder.isConfirmed = false;
        newOrder.dateConfirmed = null;
        newOrder.city = "Dnepr";
        newOrder.country = "Ukraine";
        newOrder.type = "Buy";
        return newOrder;
    }

    public static Order createOrderAndCallMethods() {
       Order newOrder = new Order(100, new Date(), true, new Date(), "Kiev", "Ukraine", "SomeValue");
       newOrder.confirmOrder();
       newOrder.checkPrice();
       newOrder.isValidType();
       return newOrder;
    }


}
