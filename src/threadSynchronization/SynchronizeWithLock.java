package threadSynchronization;

public class SynchronizeWithLock {
    private static int counter = 0;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            for(int i=0; i<10000; i++) {
                increaseCounter();
            }
        });

        Thread two = new Thread(() -> {
            for(int i=0; i<10000; i++) {
                increaseCounter();
            }
        });

        one.start();
        two.start();
        one.join();
        two.join();

        System.out.println(counter);
    }

    private static void increaseCounter() {
        synchronized (lock) {
            counter++;
        }
    }
}
