public class Main {
    public static void main(String[] args) {
        System.out.println("Available processors: " + Runtime.getRuntime().availableProcessors());
        System.out.println("Available memory: " + Runtime.getRuntime().freeMemory()/1024/1024);
        System.out.println("Available processors: " + Runtime.getRuntime());
    }
}
