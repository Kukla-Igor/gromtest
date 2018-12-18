package lesson29.homework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class HashSetTest {
    public Set<Order> useHashSet(){
        Set<Order> hashSet = new HashSet<>();
        Set<Order> hashSet1 = new HashSet<>();

        Order order1 = new Order(0, 1, "string1", "order1", "0");
        Order order2 = new Order(1, 1, "string2", "order2", "1");
        Order order3 = new Order(2, 1, "string3", "order3", "2");
        Order order4 = new Order(3, 1, "string4", "order4", "3");
        Order order5 = new Order(4, 1, "string5", "order5", "4");

        hashSet.add(order1);
        hashSet.add(order2);
        hashSet.add(order3);
        hashSet.add(order4);
        hashSet.add(order5);

        hashSet1.add(order1);
        hashSet1.add(order2);


        //hashSet.remove(order1);

        //hashSet.retainAll(hashSet1);

        //hashSet.iterator().hasNext();









       return hashSet;
    }
}
