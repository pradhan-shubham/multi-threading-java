package basicMultiThreading;

public class ExtendThread {
    public static void main(String[] args) {
       Thread thread1 = new Thread(new Thread1());
       Thread thread2 = new Thread(new Thread2());

       // randomly jumps between thread based scheduling
       thread1.start();
       thread2.start();
    }
}

class Thread1 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
        }
    }
}