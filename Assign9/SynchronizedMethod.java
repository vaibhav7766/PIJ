package Assign9;

public class SynchronizedMethod {
    // Define a synchronized method called "syncMethodTableOf7"
    synchronized void syncMethodTableOf7() {
        int k;
        // Inside the synchronized method, execute a loop from 1 to 10
        for (int i = 1; i <= 10; i++) {
            // Calculate the value of 7 * i
            k = 7 * i;
            // Print a message with the current thread's name, the base value 7, the multiplier i, and the result k
            System.out.println(Thread.currentThread().getName() + " :- " + 7 + "*" + i + " = " + k);
        }
        // Print a newline after completing the loop
        System.out.println("\n");
    }

    // Define an inner class called "Thread1" that extends Thread
    static class Thread1 extends Thread {
        SynchronizedMethod synchronizedMethod;

        Thread1(SynchronizedMethod synchronizedMethod) {
            this.synchronizedMethod = synchronizedMethod;
        }

        // Override the run() method
        public void run() {
            // Call the syncMethodTableOf7() method on the provided synchronizedMethod instance
            synchronizedMethod.syncMethodTableOf7();
        }
    }

    // Define another inner class called "Thread2" that extends Thread
    static class Thread2 extends Thread {
        SynchronizedMethod synchronizedMethod;

        Thread2(SynchronizedMethod synchronizedMethod) {
            this.synchronizedMethod = synchronizedMethod;
        }

        // Override the run() method
        public void run() {
            // Call the syncMethodTableOf7() method on the provided synchronizedMethod instance
            synchronizedMethod.syncMethodTableOf7();
        }
    }

    public static void main(String[] args) {
        // Create an instance of SynchronizedMethod
        SynchronizedMethod objSyncMethod = new SynchronizedMethod();

        // Create two threads (Thread1 and Thread2) with references to the same SynchronizedMethod instance
        Thread1 t1 = new Thread1(objSyncMethod);
        t1.setName("T1");
        Thread2 t2 = new Thread2(objSyncMethod);
        t2.setName("T2");

        // Start both threads
        t1.start();
        t2.start();
    }
}
