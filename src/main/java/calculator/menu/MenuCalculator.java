package calculator.menu;

import calculator.calculator.Calculator;
import calculator.calculator.PostfixCalculator;
import calculator.view.input.MenuCalculatorInput;

public class MenuCalculator implements Menu {

    private final MenuCalculatorInput input;
    public final Calculator calculator;

    public MenuCalculator() {
        input = new MenuCalculatorInput();
        calculator = new PostfixCalculator();
    }

    @Override
    public void process() {
        Double result =
                calculator.calculate(
                        input.askFormula());
    }

}
