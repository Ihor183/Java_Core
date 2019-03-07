package pack_isInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть число ");
        double number = scanner.nextDouble();

        if(number % 1 == 0) {
            if (number % 2 == 0) {
                System.out.println("Число " + number + " парне");
            } else {
                System.out.println("Число " + number + " непарне");
            }
        } else  {
            System.out.println("Число " + number + " не ціле");
        }
    }
}
