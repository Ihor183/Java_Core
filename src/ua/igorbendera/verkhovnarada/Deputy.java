package ua.igorbendera.verkhovnarada;

import java.util.Scanner;

public class Deputy extends Human implements Comparable<Deputy>{
    private String name;
    private String surname;
    private int age;
    private boolean bribe_taker;
    private int size_of_bribe;

    public Deputy() {}

    public Deputy(double weight, double growth, String name, String surname, int age, boolean bribe_taker) {
        super(weight, growth);
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bribe_taker = bribe_taker;
    }

    public void giveBribe() {
        if(!bribe_taker) {
            System.out.println("Цей депутат не бере хабарів! ");
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введіть розмір хабара");
            int bribe = scanner.nextInt();
            if(bribe > 5000) {
                System.out.println("Поліція увязнить депутата");
            } else {
                size_of_bribe = bribe;
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public boolean isBribe_taker() {
        return bribe_taker;
    }

    public int getSize_of_bribe() {
        return size_of_bribe;
    }

    @Override
    public String toString() {
        return "\nДепутат { " +
                " Імя = '" + name + "\' " +
                ", Прізвище = '" + surname + "\' " +
                ", Вік = " + age +
                ", Хабарник = " + bribe_taker +
                ", Розмір хабара = " + size_of_bribe +
                ", " + super.toString() +
                " }\n";
    }

    @Override
    public int compareTo(Deputy o) {
        if(this.size_of_bribe < o.getSize_of_bribe()) {
            return 1;
        } else if(this.size_of_bribe > o.getSize_of_bribe()) {
            return -1;
        } else {
            if(this.surname.compareTo(o.getSurname()) > 0) {
                return 1;
            } else if(this.surname.compareTo(o.getSurname()) < 0) {
                return -1;
            }
            else {
                if(this.name.compareTo(o.getName()) > 0) {
                    return 1;
                } else if(this.name.compareTo(o.getName()) < 0) {
                    return -1;
                }
                else {
                    if(this.age < o.getAge()) {
                        return 1;
                    } else if(this.age > o.getAge()) {
                        return -1;
                    }
                }
            }
        }
        return 0;
    }
}
