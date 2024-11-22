//Callable vs Runnable
package org.example.multithreading;

/*
* public interface Runnable {
*   public void run();
* }
* */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class RunnableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println("The thread is inside runnable");
    }
}

public class MultiThreadingRunnable {
    public static void main(String[] args) {
        Runnable rn = () -> {
            System.out.println("The thread is inside runnable");
        };
        //Thread thrd = new Thread(rn);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(rn);
        executorService.shutdown();
        //thrd.start();
    }
}
