package pack_sum_of_two_integer_numbers;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть перше число ");
        double firstNumber = scanner.nextDouble();
        System.out.print("Введіть друге число ");
        double secondNumber = scanner.nextDouble();

        if (firstNumber % 1 == 0 && secondNumber % 1 == 0) {
            System.out.println("Sum = " + (firstNumber + secondNumber));
        } else {
            System.out.println("Помилка! Числа введені неправильно");
        }
    }
}
