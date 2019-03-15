package ua.igorbendera.car;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Car[][] car = new Car[randomValues(1, 5)][randomValues(1, 5)];
        HelmMaterial[] helmMaterial = HelmMaterial.values();

        for(int i = 0; i < car.length; i++) {
            for(int j = 0; j < car[i].length; j++) {

                car[i][j] = new Car(randomValues(50,701),
                        new Helm(randomValues(25, 36),
                                helmMaterial[(randomValues(0, 2))]),
                        new Engine(engineMustHaveEvenNumberOfCylinders()));
            }
        }

        boolean flag = false;

        while(!flag) {
            switch(menu()) {
                case 1: {
                    System.out.println(Arrays.deepToString(car));
                    break;
                }
                case 2: {
                    Car carTemplate = new Car(randomValues(50,701),
                            new Helm(randomValues(25, 36),
                                    helmMaterial[(randomValues(0, 2))]),
                            new Engine(engineMustHaveEvenNumberOfCylinders()));

                    for(int i = 0; i < car.length; i++) {
                        Arrays.fill(car[i], carTemplate);
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
