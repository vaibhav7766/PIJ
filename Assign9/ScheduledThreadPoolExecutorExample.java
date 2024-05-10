package Assign9;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExecutorExample {
    // Define an inner class called "Task" that implements the Runnable interface
    static class Task implements Runnable {

        @Override
        public void run() {
            // Inside the run() method, execute the following steps:
            System.out.println("Executing : " + Thread.currentThread().getName() + ", Current Seconds : " + new Date().getSeconds());
            // Print a message with the name of the executing thread and the current seconds
        }
    }

    public static void main(String[] args) {
        // Create a ScheduledThreadPoolExecutor with a fixed pool size of 2 threads
        ScheduledThreadPoolExecutor executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(1);

        // Schedule the "Task" to run with a fixed delay of 2 seconds between executions
        executor.scheduleWithFixedDelay(new Task(), 1, 1, TimeUnit.SECONDS);
    }
}
