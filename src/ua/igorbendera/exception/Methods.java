package ua.igorbendera.exception;

public class Methods {

    static double add(double firstOperand, double secondOperand) throws IllegalAccessException {
        checkException(firstOperand, secondOperand);
        return firstOperand + secondOperand;
    }

    static double subtract(double firstOperand, double secondOperand) throws IllegalAccessException {
        checkException(firstOperand, secondOperand);
        return firstOperand - secondOperand;
    }

    static double multiply(double firstOperand, double secondOperand) throws IllegalAccessException {
        checkException(firstOperand, secondOperand);
        return firstOperand * secondOperand;
    }

    static double divide(double firstOperand, double secondOperand) throws IllegalAccessException {
        checkException(firstOperand, secondOperand);
        return firstOperand / secondOperand;
    }

    private static void checkException(double firstOperand, double secondOperand) throws IllegalAccessException {
        if(firstOperand < 0 || secondOperand < 0) {
            throw new IllegalArgumentException();
        }

        if(firstOperand == 0 && secondOperand == 0) {
            throw new IllegalAccessException();
        }

        if(firstOperand == 0 || secondOperand == 0) {
            throw new ArithmeticException();
        }

        if(firstOperand > 0 && secondOperand > 0) {
            try {
                throw new MyException("Two numbers is rather than 0");
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }
}
