package lesson28;

import java.util.Comparator;

public class DateComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {
        if (o1.getDateCreated() == null)
           return 1;
        else if (o2.getDateCreated() == null)
            return -1;
        else if (o1.getId() - o2.getId() > 0)
            return 1;
        else
            return -1;


    }
}
