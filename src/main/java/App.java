import calculator.Calculator;
import calculator.config.DependencyConfigurer;

public class App {
    public static void main(String[] args) {
        DependencyConfigurer dependencyConfigurer = new DependencyConfigurer();
        Calculator calculator = dependencyConfigurer.createCalculatorWithDependency();
        calculator.run();
    }
}
