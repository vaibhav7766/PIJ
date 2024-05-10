package Assign9;

public class WithSynchronizedStatic {
    synchronized static void syncStaticPowerOf7() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " :- " + i + " pow " + 7 + " value: " + Math.pow(i, 7));
        }
        System.out.println("\n");
    }


    static class Thread1 extends Thread {
        WithSynchronizedStatic withoutSynchronizedStatic;

        Thread1(WithSynchronizedStatic withoutSynchronizedStatic) {
            this.withoutSynchronizedStatic = withoutSynchronizedStatic;
        }


        public void run() {
            withoutSynchronizedStatic.syncStaticPowerOf7();
        }
    }

    static class Thread2 extends Thread {
        WithSynchronizedStatic withoutSynchronizedStatic;

        Thread2(WithSynchronizedStatic withoutSynchronizedStatic) {
            this.withoutSynchronizedStatic = withoutSynchronizedStatic;
        }


        public void run() {
            withoutSynchronizedStatic.syncStaticPowerOf7();
        }
    }

    static class Thread3 extends Thread {
        WithSynchronizedStatic withoutSynchronizedStatic;

        Thread3(WithSynchronizedStatic withoutSynchronizedStatic) {
            this.withoutSynchronizedStatic = withoutSynchronizedStatic;
        }


        public void run() {
            withoutSynchronizedStatic.syncStaticPowerOf7();
        }
    }

    static class Thread4 extends Thread {
        WithSynchronizedStatic withoutSynchronizedStatic;

        Thread4(WithSynchronizedStatic withoutSynchronizedStatic) {
            this.withoutSynchronizedStatic = withoutSynchronizedStatic;
        }


        public void run() {
            withoutSynchronizedStatic.syncStaticPowerOf7();
        }
    }

    public static void main(String[] args) {

        WithSynchronizedStatic objSyncStatic1 = new WithSynchronizedStatic();
        Thread1 t1 = new Thread1(objSyncStatic1);
        t1.setName("T1");
        Thread2 t2 = new Thread2(objSyncStatic1);
        t2.setName("T2");
        t1.start();
        t2.start();


        WithSynchronizedStatic objSyncStatic2 = new WithSynchronizedStatic();
        Thread3 t3 = new Thread3(objSyncStatic2);
        t3.setName("T3");
        Thread4 t4 = new Thread4(objSyncStatic2);
        t4.setName("T4");
        t3.start();
        t4.start();

    }
}
