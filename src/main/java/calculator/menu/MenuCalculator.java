package calculator.menu;

import calculator.calculator.Calculator;
import calculator.calculator.PostfixCalculator;
import calculator.calculator.history.CalculationHistory;
import calculator.calculator.history.History;
import calculator.view.input.MenuCalculatorInput;

import java.math.BigDecimal;

public class MenuCalculator implements Menu {

    private final History history;
    private final MenuCalculatorInput input;
    public final Calculator calculator;

    public MenuCalculator() {
        history = new CalculationHistory();
        input = new MenuCalculatorInput();
        calculator = new PostfixCalculator();
    }

    @Override
    public void process() {
        String formula = input.askFormula();
        BigDecimal result = calculator.calculate(formula);

        history.save(formula, String.valueOf(result));
    }

}
