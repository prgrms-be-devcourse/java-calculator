import calculator.Calculator;
import calculator.DependencyConfigurer;

public class App {
    public static void main(String[] args) {
        DependencyConfigurer dependencyConfigurer = new DependencyConfigurer();
        Calculator calculator = dependencyConfigurer.calculator();
        calculator.run();
    }
}
