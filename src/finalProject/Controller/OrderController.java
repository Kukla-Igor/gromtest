package finalProject.Controller;

import finalProject.DAO.OrderDAO;
import finalProject.Service.OrderService;

public class OrderController {
    OrderService orderService = new OrderService();

    public void bookRooms(long roomId, long userId, long hotelId) throws Exception{
        orderService.bookRooms(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception{
        orderService.cancelReservation(roomId, userId);
    }
}
