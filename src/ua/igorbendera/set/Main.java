package ua.igorbendera.set;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Set<Car> car = new HashSet<>();
        fillData(car);

        System.out.println("Not sorted\n");
        show(car);

        Set<Car> carSortComparator = new TreeSet<>(new BrandComparator());
        fillData(carSortComparator);

        System.out.println("\nComparator sorting\n");
        show(carSortComparator);

        System.out.println();

        Set<Car> carSortComparable = new TreeSet<>();
        fillData(carSortComparable);

        System.out.println("\nComparable sorting\n");
        show(carSortComparable);
    }

    static void fillData(Set<Car> car) {
        car.add(new Car("BMW", "M4 GTS", 700));
        car.add(new Car("Audi", "S8", 1000));
        car.add(new Car("BMW", "M3", 300));
        car.add(new Car("BMW", "M3", 310));
        car.add(new Car("Mercedes", "AMG", 600));
        car.add(new Car("Audi", "RS8", 1000));
        car.add(new Car("Volkswagen", "Arteon r-line", 500));
        car.add(new Car("Tesla", "Model S", 450));
    }

    static void show(Set<Car> car) {
        for(Car c : car) {
            System.out.println(c);
        }
    }
}
