package basicMultiThreading;

public class RunnableThread {
    public static void main(String[] args) {
        Thread threadOne = new Thread(new ThreadOne());
        Thread threadTwo = new Thread(new ThreadTwo());
        Thread threadThree = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        });
        //randomly switch between threadOne and threadTwu based on scheduling
        threadOne.start();
        threadTwo.start();
        threadThree.start();
    }
}

class ThreadOne implements Runnable {

    @Override
    public void run() {
       for (int i = 0; i < 10; i++) {
           System.out.println(Thread.currentThread().getName() + " : " + i);
       }
    }
}

class ThreadTwo implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}