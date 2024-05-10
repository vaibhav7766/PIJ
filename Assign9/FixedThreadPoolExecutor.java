package Assign9;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExecutor {
    // Define an inner class called "Task" that implements the Runnable interface
    static class Task implements Runnable {

        @Override
        public void run() {
            // Inside the run() method, execute a loop from 1 to 5
            for (int i = 1; i <= 5; i++) {
                // Print a message with the current count and the name of the executing thread
                System.out.println("Print Count: " + i + " by " + Thread.currentThread().getName());
            }
        }
    }

    public static void main(String[] args) {
        // Create an ExecutorService with a fixed thread pool of 2 threads
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Submit three instances of the "Task" class to the thread pool
        for (int i = 1; i <= 3; i++) {
            executorService.execute(new Task());
        }

        // Shut down the thread pool
        executorService.shutdown();
    }
}
