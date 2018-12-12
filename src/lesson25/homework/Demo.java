package lesson25.homework;

public class Demo {
    public static void main(String[] args) throws Exception {
        GeneralDAO<Order> generalDAO = new GeneralDAO<>();


        Order order1 = new Order(0);
        Order order2 = new Order(1);
        Order order3 = new Order(2);
        Order order4 = new Order(3);
        Order order5 = new Order(4);
        Order order6 = new Order(5);
        Order order7 = new Order(6);
        Order order8 = new Order(7);
        Order order9 = new Order(8);
        Order order10 = new Order(9);



        System.out.println(generalDAO.save(order1));


    }
}
