package lesson26.homework;

import java.util.ArrayList;

public class ArrayListTest {
    public ArrayList useList(){
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList1 = new ArrayList();

        Order order1 = new Order(0, 1, "string1", "order1", "0");
        Order order2 = new Order(1, 1, "string2", "order2", "1");
        Order order3 = new Order(2, 1, "string3", "order3", "2");
        Order order4 = new Order(3, 1, "string4", "order4", "3");
        Order order5 = new Order(4, 1, "string5", "order5", "4");

        arrayList.add(order1);
        arrayList.add(1, order2);

        arrayList1.add(order1);
        arrayList1.add(order2);

        arrayList.remove(0);
        arrayList.remove(order2);

        arrayList.addAll(arrayList1);
        arrayList.add(order3);
        arrayList.add(order4);
        arrayList.set(1, order5);
        arrayList.add(order2);








        return arrayList;
    }
}
