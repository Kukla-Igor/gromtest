package finalProject.demo;

import finalProject.Controller.OrderController;

public class OrderDemo {
    public static void main(String[] args) throws Exception {
        OrderController orderController = new OrderController();

       //orderController.bookRooms(1, 1, 1);

        orderController.cancelReservation(1, 1);
    }

}
