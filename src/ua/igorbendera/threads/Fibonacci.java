package ua.igorbendera.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fibonacci {
    public static final int numberOfNumbersFibonacci;

    static {
        System.out.println("Введіть кількість чисел Фібоначчі");
        numberOfNumbersFibonacci = new Scanner(System.in).nextInt();
    }

    static List<Integer> lookForFibonacciNumbers() {
        List<Integer> FibonacciList = new ArrayList<>();
        FibonacciList.add(0);
        FibonacciList.add(1);

        for(int i = 2; i < numberOfNumbersFibonacci; i++) {
            FibonacciList.add(FibonacciList.get(i - 2) + FibonacciList.get(i - 1));
        }

        return FibonacciList;
    }

    static synchronized void showFibonacciNumbers(List<Integer> FibonacciNumbers) {
        System.out.print(Thread.currentThread().getName() + ": ");

        for(Integer i : FibonacciNumbers) {
            System.out.print(i + " ");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println();
    }
}
