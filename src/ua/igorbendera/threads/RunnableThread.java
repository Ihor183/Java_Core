package ua.igorbendera.threads;

import java.util.Collections;
import java.util.List;

public class RunnableThread implements Runnable {
    
    @Override
    public void run() {
        Thread.currentThread().setName("Runnable");

        List<Integer> FibonacciNumbers = Fibonacci.lookForFibonacciNumbers();
        Collections.reverse(FibonacciNumbers);

        Fibonacci.showFibonacciNumbers(FibonacciNumbers);
    }
}
