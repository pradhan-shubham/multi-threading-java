package threadSynchronization;

public class Synchronization {

    private static int counter = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread threadOne = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increaseCounter();
            }
        });

        Thread threadTwo = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                increaseCounter();
            }
        });

        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();

        System.out.println(counter);
    }

    private synchronized static void increaseCounter() {
        counter++;
    }
}
