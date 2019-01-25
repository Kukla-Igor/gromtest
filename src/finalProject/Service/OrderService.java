package finalProject.Service;

import finalProject.DAO.OrderDAO;


public class OrderService {
   public OrderDAO orderDAO = new OrderDAO();

    public void bookRooms(long roomId, long userId, long hotelId) throws Exception{
        orderDAO.bookRoom(roomId, userId, hotelId);
    }

    public void cancelReservation(long roomId, long userId) throws Exception{
        orderDAO.cancelReservation(roomId, userId);
    }
}
