package ua.igorbendera.streamCompere;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Car> car = new HashSet<>();
        fillData(car);

        System.out.println("Not sorted\n");
        show(car);

        System.out.println("\nStream sorting with one field");
        car.stream().sorted(Comparator.comparing(Car::getBrand)).forEach(System.out::println);

        System.out.println("\nStream sorting with two fields");
        car.stream().sorted(Comparator.comparing(Car::getBrand).thenComparing(
                Car::getModel)).forEach(System.out::println);

        System.out.println("\nStream sorting with all fields");
        car.stream().sorted(Comparator.comparing(Car::getBrand).thenComparing(
                Car::getModel).thenComparing(Car::getPower)).forEach(System.out::println);

    }

    static void fillData(Set<Car> car) {
        car.add(new Car("BMW", "M4 GTS", 700));
        car.add(new Car("Audi", "S8", 1000));
        car.add(new Car("BMW", "M3", 310));
        car.add(new Car("BMW", "M3", 300));
        car.add(new Car("Mercedes", "AMG", 600));
        car.add(new Car("Audi", "RS8", 1000));
        car.add(new Car("Volkswagen", "Arteon r-line", 500));
        car.add(new Car("Tesla", "Model S", 450));
    }

    static void show(Set<Car> car) {
        car.forEach(System.out::println);
    }
}
