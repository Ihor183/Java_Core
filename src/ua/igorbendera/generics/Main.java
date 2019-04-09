package ua.igorbendera.generics;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scanner data = new Scanner(System.in);
        int action;
        boolean flag = false;

        Map<Integer, String> map = new Map<>(1, "First");

        while(!flag) {
            menu();
            action = scanner.nextInt();

            switch(action) {
                case 1: {
                    System.out.print("Key:");
                    int key = data.nextInt();
                    data = new Scanner(System.in);

                    System.out.print("Value:");
                    String value = data.nextLine();

                    map.addToMap(key, value);
                    break;
                }
                case 2: {
                    System.out.print("Key:");
                    int key = data.nextInt();
                    map.removeByKey(key);

                    break;
                }
                case 3: {
                    System.out.print("Key:");
                    int key = data.nextInt();
                    map.removeValue(key);

                    break;
                }
                case 4: {
                    map.showKeys();

                    break;
                }
                case 5: {
                    map.showValues();

                    break;
                }
                case 6: {
                    map.showMap();

                    break;
                }
                case 7: {
                    flag = true;

                    break;
                }
                default: return;
            }
        }
    }

    static void menu() {
        System.out.println("1 - Add object to map\n" +
                "2 - Remove by key\n" +
                "3 - Set \'null\' value\n" +
                "4 - Show keys\n" +
                "5 - Show values\n" +
                "6 - Show map\n" +
                "7 - Exit\n");
    }
}
