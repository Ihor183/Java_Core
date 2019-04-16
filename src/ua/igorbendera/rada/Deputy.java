package ua.igorbendera.rada;

import java.util.Objects;
import java.util.Scanner;
import java.util.function.Predicate;

public class Deputy extends Person implements Comparable<Deputy>{
    private String name;
    private String surname;
    private int age;
    private boolean bribe_taker;
    private int size_of_bribe;

    public Deputy() {}

    public Deputy(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }

    public Deputy(double weight, int height, String name, String surname, int age, boolean bribe_taker) {
        super(weight, height);
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.bribe_taker = bribe_taker;
    }

    public void giveBribe() {
        if(!bribe_taker) {
            System.out.println("Цей депутат не бере хабарів! ");
        } else {
            System.out.println("Введіть розмір хабара");
            int bribe = new Scanner(System.in).nextInt();
            Predicate<Integer> bribeLimit = x -> x > 5000;

            if(bribeLimit.test(bribe)) {
                System.out.println("Поліція увязнить депутата");
            } else {
                size_of_bribe = bribe;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isBribe_taker() {
        return bribe_taker;
    }

    public void setBribe_taker(boolean bribe_taker) {
        this.bribe_taker = bribe_taker;
    }

    public int getSize_of_bribe() {
        return size_of_bribe;
    }

    public void setSize_of_bribe(int size_of_bribe) {
        this.size_of_bribe = size_of_bribe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deputy deputy = (Deputy) o;
        return age == deputy.age &&
                name.equalsIgnoreCase(deputy.name) &&
                surname.equalsIgnoreCase(deputy.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, surname, age);
    }

    @Override
    public String toString() {
        return " name = '" + name + '\'' +
                ", surname = '" + surname + '\'' +
                ", age = " + age +
                ", bribe_taker = " + bribe_taker +
                ", size_of_bribe = " + size_of_bribe +
                super.toString();
    }

    @Override
    public int compareTo(Deputy o) {
        return o.getSize_of_bribe() - this.size_of_bribe;
    }
}
