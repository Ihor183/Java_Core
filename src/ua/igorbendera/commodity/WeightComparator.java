package ua.igorbendera.commodity;

import java.util.Comparator;

public class WeightComparator implements Comparator<Commodity> {

    @Override
    public int compare(Commodity o1, Commodity o2) {
        if(o1.getWeight() < o2.getWeight()) {
            return 1;
        } else if(o1.getWeight() > o2.getWeight()) {
            return -1;
        }
        return 0;
    }
}
