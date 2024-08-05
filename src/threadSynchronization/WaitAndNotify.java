package threadSynchronization;

public class WaitAndNotify {
    private static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread one = new Thread(() -> {
            try {
                one();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread two = new Thread(() -> {
            try {
                two();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        one.start();
        two.start();
        one.join();
        two.join();
    }

    private static void one() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Hello from one");
            lock.wait();
            System.out.println("Hello from one after wait");
        }
    }

    private static void two() throws InterruptedException {
        synchronized (lock) {
            System.out.println("Hello from two");
            lock.notify();
            System.out.println("Hello from one after notifying");
        }
    }
}
