package lesson28;

import java.util.Comparator;
import java.util.Date;

public class FullComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {
        if (o1.getChanelName() == null || o1.getFingerprint() == null )
            return 1;
        else if (o2.getChanelName() == null || o2.getFingerprint() == null)
            return -1;
        if (!o1.getChanelName().equals(o2.getChanelName())) {
            return o1.getChanelName().compareTo(o2.getChanelName());
        }  if (!o1.getFingerprint().equals(o2.getFingerprint()))
            return o1.getFingerprint().compareTo(o2.getFingerprint());
        else {
            DateComparator dateComparator = new DateComparator();
            return dateComparator.compare(o1, o2);
        }

    }
}
