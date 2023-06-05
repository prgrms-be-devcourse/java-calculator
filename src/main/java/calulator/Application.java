package calulator;

import calulator.domain.Calculator;
import calulator.repository.ExpressionRepository;
import calulator.view.InputView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(new InputView(), new ExpressionRepository());

        calculator.run();
    }

}
