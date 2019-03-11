package ua.igorbendera.exception;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        Methods.add(-1, 5);
        Methods.subtract(0, 5);
        Methods.multiply(0, 0);
        Methods.divide(-1, 0);
        Methods.divide(1, 2);
    }
}
