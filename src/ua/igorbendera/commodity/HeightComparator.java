package ua.igorbendera.commodity;

import java.util.Comparator;

public class HeightComparator implements Comparator<Commodity> {

    @Override
    public int compare(Commodity o1, Commodity o2) {
        if(o1.getHeight() < o2.getHeight()) {
            return 1;
        } else if(o1.getHeight() > o2.getHeight()) {
            return -1;
        }
        return 0;
    }
}
