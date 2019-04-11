package ua.igorbendera.serialize;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("data.txt");
        File file1 = new File("data1.txt");

        List<Employee> list = new ArrayList<>();
        list.add(new Employee("Dima", 22, 1500));
        list.add(new Employee("Vasya", 23, 500));
        list.add(new Employee("Taras", 21, 600));
        list.add(new Employee("Petya", 23, 700));
        list.add(new Employee("Nazar", 19, 800));

        Scanner scanner = new Scanner(System.in);
        int action;
        boolean flag = false;

        while(!flag) {
            menu();
            action = scanner.nextInt();

            switch(action) {
                case 1: {
                    Methods.serialize(file, new Employee("Igor", 19, 1000));
                    System.out.println("Success");
                    break;
                }
                case 2: {
                    for(Employee e : list) {
                        Methods.serialize(file1, e);
                    }
                    System.out.println("Success");
                    break;
                }
                case 3: {
                    System.out.println(Methods.deserealize(file) + "\n");
                    break;
                }
                case 4: {
                    List<Employee> employees = Methods.deserealize(file1);

                    System.out.println();
                    for(Employee e : employees) {
                        System.out.println(e);
                    }
                    System.out.println();
                    break;
                }
                case 5: {
                    flag = true;
                    break;
                }
                default:
                    return;
            }
        }


    }

    static void menu() {
        System.out.println("1 - Add object to First file\n" +
                "2 - Add collection to Second file\n" +
                "3 - Read First file\n" +
                "4 - Read Second File\n");
    }
}
