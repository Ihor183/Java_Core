package ua.igorbendera.threads;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();

        RunnableThread runnableThread = new RunnableThread();
        Thread thread = new Thread(runnableThread);
        thread.start();

        ExecutorService eSFTP = Executors.newFixedThreadPool(2);
        ExecutorService eSTE = Executors.newSingleThreadExecutor();
        ExecutorService eCTP = Executors.newCachedThreadPool();

        eSFTP.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Executor new Fixed Thread Pool");
                Fibonacci.showFibonacciNumbers(Fibonacci.lookForFibonacciNumbers());
            }
        });

        eSFTP.shutdown();

        eSTE.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Executor new Single Thread Pool");

                List<Integer> FibonacciNumbers = Fibonacci.lookForFibonacciNumbers();
                Collections.reverse(FibonacciNumbers);
                Fibonacci.showFibonacciNumbers(FibonacciNumbers);
            }
        });

        eSTE.shutdown();

        eCTP.execute(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Executor new Cached Thread Pool");
                Fibonacci.showFibonacciNumbers(Fibonacci.lookForFibonacciNumbers());
            }
        });

        eCTP.shutdown();

    }
}
