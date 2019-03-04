package com.lgs.lab.interface2;

import com.lgs.lab.interface1.Numerable;

public class MyCalculator implements Numerable {

    public static void main(String[] args) {
        MyCalculator myCalculator = new MyCalculator();

        myCalculator.add(5, 10);
        myCalculator.divide(20, 10);
        myCalculator.multiply(7, 8);
        myCalculator.subtract(4, 12);
    }

    @Override
    public void divide(double a, double b) {
        System.out.println("a / b = " + (a / b));
    }

    @Override
    public void subtract(double a, double b) {
        System.out.println("a - b = " + (a - b));
    }

    @Override
    public void multiply(double a, double b) {
        System.out.println("a * b = " + (a * b));
    }

    @Override
    public void add(double a, double b) {
        System.out.println("a + b = " + (a + b));
    }
}
