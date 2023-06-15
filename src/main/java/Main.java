import Common.Runner.Runner;

public class Main {
    public static void main(String[] args) {
        Runnable runnable = new Runner();
        Thread t = new Thread(runnable);
        t.start();
    }
}
