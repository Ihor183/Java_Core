package ua.igorbendera.commodity;

import java.util.Comparator;

public class NameComparator implements Comparator<Commodity> {

    @Override
    public int compare(Commodity o1, Commodity o2) {
        if(o1.getName().compareToIgnoreCase(o2.getName()) > 0) {
            return 1;
        } else if(o1.getName().compareToIgnoreCase(o2.getName()) < 0) {
            return -1;
        }
        return 0;
    }
}
