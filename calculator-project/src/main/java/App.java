public class App {
    public static void main(String[] args) {
        new CalculatorService(new Console(),new Console()).run();
    }
}