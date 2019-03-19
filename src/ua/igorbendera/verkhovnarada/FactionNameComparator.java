package ua.igorbendera.verkhovnarada;

import java.util.Comparator;

public class FactionNameComparator implements Comparator<Faction> {
    @Override
    public int compare(Faction o1, Faction o2) {
        if(o1.getFactionName().compareTo(o2.getFactionName()) > 0) {
            return 1;
        } else if(o1.getFactionName().compareTo(o2.getFactionName()) < 0) {
            return -1;
        } else {
            return 0;
        }
    }
}
