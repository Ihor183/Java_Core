package ua.igorbendera.exponential;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ShowExponentialForm exponentialForm = System.out::println;

        exponentialForm.toExponential("DOUBLE MIN - " + Double.MIN_VALUE);
        exponentialForm.toExponential("DOUBLE MAX - " + Double.MAX_VALUE);
        exponentialForm.toExponential("FLOAT MIN - " + Float.MIN_VALUE);
        exponentialForm.toExponential("FLOAT MAX - " + Float.MAX_VALUE);

        System.out.println("-------------------OR-----------------");

        List<String> list = new ArrayList<>();

        double min = Double.MIN_VALUE;
        double max = Double.MAX_VALUE;
        float minF = Float.MIN_VALUE;
        float maxF = Float.MAX_VALUE;

        list.add(Double.toString(min));
        list.add(Double.toString(max));
        list.add(Float.toString(minF));
        list.add(Float.toString(maxF));

        list.forEach(System.out::println);
    }
}
