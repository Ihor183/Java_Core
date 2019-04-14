package ua.igorbendera.threads;

public class MyThread extends Thread{

    @Override
    public void run() {
        Thread.currentThread().setName("Thread");
        Fibonacci.showFibonacciNumbers(Fibonacci.lookForFibonacciNumbers());
    }
}
