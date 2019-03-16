package ua.igorbendera.car;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size = randomValues(1, 6);
        int outerSize = randomValues(1, 6);

        ArrayList<ArrayList<Car>> car = new ArrayList<>();
        ArrayList<HelmMaterial> helmMaterial = new ArrayList<>();

        for (HelmMaterial materials : HelmMaterial.values()) {
            helmMaterial.add(materials);
        }

        for(int i = 0; i < size; i++) {
            ArrayList<Car> outer = new ArrayList<>(randomValues(1, 6));
            car.add(outer);

            for(int j = 0; j < outerSize; j++) {
                Car carInitial = setCar(helmMaterial);
                outer.add(carInitial);
            }
        }

        boolean flag = false;

        while(!flag) {
            switch(menu()) {
                case 1: {
                    System.out.println(car);
                    break;
                }
                case 2: {
                    Car carTemplate = setCar(helmMaterial);

                    for(int i = 0; i < size; i++) {
                        Collections.fill(car.get(i), carTemplate);
                    }

                    System.out.println("Success");
                    break;
                }
                case 3: {
                    flag = true;
                    break;
                }
                default:
                    System.out.println("This action isn't exist");
                    return;
            }
        }
    }

    private static Car setCar(ArrayList<HelmMaterial> helmMaterial) {
        return new Car(randomValues(50,701),
                new Helm(randomValues(25, 36),
                        helmMaterial.get(randomValues(0, 2))),
                new Engine(engineMustHaveEvenNumberOfCylinders()));
    }

    private static int randomValues(int lowerBorder, int upperBorder) {
        if (lowerBorder < upperBorder) {
            return lowerBorder + (int) (Math.random() * (upperBorder - lowerBorder));
        } else {
            return upperBorder + (int) (Math.random() * (lowerBorder - upperBorder));
        }
    }

    private static int engineMustHaveEvenNumberOfCylinders() {
        int numberOfCylinders = randomValues(2, 12);
        numberOfCylinders = (numberOfCylinders % 2 == 0)? numberOfCylinders : numberOfCylinders + 1;

        return numberOfCylinders;
    }

    private static int menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose action\n" +
                "1 - Show all cars\n" +
                "2 - Set car for all objects\n" +
                "3 - Exit\n");

        return scanner.nextInt();
    }
}
