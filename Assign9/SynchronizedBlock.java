package Assign9;

public class SynchronizedBlock {
    // Define a method called "syncBlock7Power"
    void syncBlock7Power() {
        // Synchronize on the current instance (this)
        synchronized (this) {
            // Inside the synchronized block, execute a loop from 1 to 5
            for (int i = 1; i <= 5; i++) {
                // Print a message with the current thread's name, the base value 7, the exponent i, and the result of 7^i
                System.out.println(Thread.currentThread().getName() + " :- " + 7 + " power " + i + " value: " + Math.pow(7, i));
            }
            // Print a newline after completing the loop
            System.out.println("\n");
        }
    }

    // Define an inner class called "Thread3" that extends Thread
    static class Thread3 extends Thread {
        SynchronizedBlock synchronizedBlock;

        Thread3(SynchronizedBlock synchronizedBlock) {
            this.synchronizedBlock = synchronizedBlock;
        }

        // Override the run() method
        public void run() {
            // Call the syncBlock7Power() method on the provided synchronizedBlock instance
            synchronizedBlock.syncBlock7Power();
        }
    }

    // Define another inner class called "Thread4" that extends Thread
    static class Thread4 extends Thread {
        SynchronizedBlock synchronizedBlock;

        Thread4(SynchronizedBlock synchronizedBlock) {
            this.synchronizedBlock = synchronizedBlock;
        }

        // Override the run() method
        public void run() {
            // Call the syncBlock7Power() method on the provided synchronizedBlock instance
            synchronizedBlock.syncBlock7Power();
        }
    }

    public static void main(String[] args) {
        // Create an instance of SynchronizedBlock
        SynchronizedBlock objSyncBlock = new SynchronizedBlock();

        // Create two threads (Thread3 and Thread4) with references to the same SynchronizedBlock instance
        Thread3 t1 = new Thread3(objSyncBlock);
        t1.setName("T1");
        Thread4 t2 = new Thread4(objSyncBlock);
        t2.setName("T2");

        // Start both threads
        t1.start();
        t2.start();
    }
}
