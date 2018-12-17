package lesson28;

import java.util.Comparator;

public class FullComparator implements Comparator<Capability> {

    @Override
    public int compare(Capability o1, Capability o2) {
            if (!o1.getChanelName().equals(o2.getChanelName())){
                return o1.getChanelName().compareTo(o2.getChanelName());
            } else if (!o1.getFingerprint().equals(o2.getFingerprint()))
                return o1.getFingerprint().compareTo(o2.getFingerprint());
            else
                return (int) (o2.getDateCreated().getTime() - o1.getDateCreated().getTime());

        }
}
