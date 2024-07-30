package basicMultiThreading;

public class JoinThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " " + i);
            }
        });

        thread1.start();
        thread2.start();
        thread1.join(); // waits for thread1 to be executed
        thread2.join(); // waits for thread2 tb be executed
        System.out.println("Done executing threads");
    }
}
