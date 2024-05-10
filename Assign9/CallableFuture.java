package Assign9;

import java.util.Random;
import java.util.concurrent.*;

public class CallableFuture {
    // Define an inner class called "Task" that implements the Callable interface
    static class Task implements Callable<Integer> {

        @Override
        public Integer call() {
            // Inside the call() method, execute the following steps:
            System.out.println("Thread : " + Thread.currentThread().getName()); // Print the name of the executing thread
            return new Random().nextInt(); // Generate a random integer and return it
        }
    }

    public static void main(String[] args){
        // Create a ThreadPoolExecutor with a fixed pool size of 10 threads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        Future<Integer> future;

        // Print the estimated number of active threads (before any tasks are executed)
        System.out.println("Estimate no of active threads : " + Thread.activeCount());

        // Submit three instances of the "Task" class to the thread pool
        for (int i = 1; i <= 3; i++) {
            future = executor.submit(new Task());
            // Print the number of active threads executing tasks
            System.out.println("Active Threads executing tasks : " + executor.getActiveCount());
            // Print the estimated number of active threads
            System.out.println("Estimate no of active threads : " + Thread.activeCount());

            try {
                // Get the result from the future (blocking until the task completes)
                Integer result = future.get();
                System.out.println("Result : " + result);

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Print additional information about the thread pool
        System.out.println("\nMaximum allowed threads : " + executor.getMaximumPoolSize());
        System.out.println("Current no of threads in Pool : " + executor.getPoolSize());
        System.out.println("Task Count : " + executor.getTaskCount());
        System.out.println("Completed Task Count : " + executor.getCompletedTaskCount());
        System.out.println("Estimate no of active threads : " + Thread.activeCount());
        System.out.println("Active Threads executing tasks : " + executor.getActiveCount());

        // Shut down the thread pool
        executor.shutdown();
    }
}
