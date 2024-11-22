package org.example;


import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ThreadExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // Creating Lambda expression for run() method in functional interface "Runnable"
        Runnable myThread = () ->
        {
            try {
                System.out.println(
                        Thread.currentThread().getName()
                                + " is running");
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

//        Callable<String> task = () -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                return "Returning after sleeping for 2 seconds";
//            }
//            catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(myThread);
//        // submit method does not wait until task completes, the executor service cannot return result to callable directly until the task completes
//        // Executor returns a special result of type Future which can be used to retrieve the actual result.
//        Future<String> f = executorService.submit(task);
//        System.out.println("Is Done?" + f.isDone());
//        // Future is tightly coupled with executor service. Every non-terminated future will throw exceptions if you shut down the executor while running.
//        // Any call to get method will block and wait until callable is terminated. worst case, callable can run forever making application unresponsive.
//        String result = f.get();
//        System.out.println(result);
        executorService.shutdown();
//        // invokeAll method allows us to submit  multiple callables at once. accepts a collection of callables and returns list of futures.
//        ExecutorService executorService1 = Executors.newWorkStealingPool();
//        // Created for given parallelism size - by default, no of cores available in CPU - Java 8
//        List<Callable<String>> callablesList = Arrays.asList(() -> "Task1", () -> "Task2", () -> "Task3");
//        for (Future<String> future : executorService1.invokeAll(callablesList)) {
//            System.out.println(future.get());
//        }
//        //InvokeAny - wait for executor service to terminates and returns result of that callable instead of returning future.
//        //ScheduledExecutorService for periodically run a task. newScheduledThreadPool()
////        Thread t = new Thread(myThread);
////        t.start();
////        Thread t2 = new Thread(myThread);
////        t2.start();
////        Thread t3 = new Thread(myThread);
////        t3.start();
    }
}
