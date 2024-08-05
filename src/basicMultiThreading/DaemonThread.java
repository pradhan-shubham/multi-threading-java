package basicMultiThreading;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread userThread = new Thread(new UserThread());
        Thread deamonThread = new Thread(new DaemonThreadHelper());

        deamonThread.setDaemon(true);
        userThread.start();
        deamonThread.start();
    }
}

// Daemon thread runs in background until all the other user thread have completed.
// In this case Daemon thread should be running till the count is 500 but it stops as soon as UserThread is completed.
class DaemonThreadHelper implements Runnable {
    @Override
    public void run(){
        int count = 0;
        while(count < 500) {
            System.out.println("Executing deamon thread ... count: " + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            count++;
        }
    }
}

class UserThread implements Runnable {
    @Override
    public void run(){
        System.out.println("Executing user thread ...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
