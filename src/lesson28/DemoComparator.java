package lesson28;

import java.util.*;

public class DemoComparator {
    public static void main(String[] args) {

        Capability capability2 = new Capability(1005, "test", "rrrr",false,  new Date());
        Capability capability4 = new Capability(900, "test", "rrrr",false,  new Date());
        Capability capability3 = new Capability(900, "test", "rrrr",true,  new Date());
        Capability capability1 = new Capability(1001, "test", "rrrr",true,  new Date());


        ArrayList<Capability> capabilities = new ArrayList<>();
        capabilities.add(capability1);
        capabilities.add(capability2);
        capabilities.add(capability3);
        capabilities.add(capability4);
        System.out.println(capabilities);

        capabilities.sort(new IsActiveComparator());

        System.out.println(capabilities);


    }
}
