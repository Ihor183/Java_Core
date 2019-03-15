package ua.igorbendera.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter array size ");

        int size = scanner.nextInt();
        Integer[] arrayOfRandomNumbers = new Integer[size];

        for(int i = 0; i < arrayOfRandomNumbers.length; i++) {
            arrayOfRandomNumbers[i] = setValue();
        }

        System.out.println("Before sorting: " + showArray(arrayOfRandomNumbers));

        Arrays.sort(arrayOfRandomNumbers);
        System.out.println("After sorting \'asc\': " + showArray(arrayOfRandomNumbers));

        Arrays.sort(arrayOfRandomNumbers, Collections.reverseOrder());
        System.out.println("After sorting \'desc\': " + showArray(arrayOfRandomNumbers));


    }

    private static int setValue() {
        Random r = new Random();
        return r.nextInt(100);
    }

    private static String showArray(Integer[] array) {
        return Arrays.toString(array);
    }
}
