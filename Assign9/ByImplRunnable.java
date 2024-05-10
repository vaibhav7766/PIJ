package Assign9;

public class ByImplRunnable {
    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("Thread " + Thread.currentThread().getName()
                    + " is running");
            for (int i = 1; i <= 5; i++) {
                System.out.println("Print Count: " + i + " by " + Thread.currentThread().getName());
            }
            System.out.println("Thread " + Thread.currentThread().getName()
                    + " is completed");
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(new Task());
            t.start();
        }
    }
}
