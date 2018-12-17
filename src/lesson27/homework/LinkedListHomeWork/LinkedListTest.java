package lesson27.homework.LinkedListHomeWork;

import java.util.LinkedList;

public class LinkedListTest {
    public static LinkedList useList(){
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList1 = new LinkedList();

        Order order1 = new Order(0, 1, "string1", "order1", "0");
        Order order2 = new Order(1, 1, "string2", "order2", "1");
        Order order3 = new Order(2, 1, "string3", "order3", "2");
        Order order4 = new Order(3, 1, "string4", "order4", "3");
        Order order5 = new Order(4, 1, "string5", "order5", "4");

        linkedList.add(order1);
        linkedList.add(1, order2);

        linkedList1.add(order1);
        linkedList1.add(order2);

        linkedList.remove(0);
        linkedList.remove(order2);

        linkedList.addAll(linkedList1);
        linkedList.add(order3);
        linkedList.add(order4);
        linkedList.set(1, order5);
        linkedList.add(order2);








        return linkedList;
    }
}
