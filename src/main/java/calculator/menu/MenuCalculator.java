package calculator.menu;

import calculator.calculator.Calculator;
import calculator.calculator.PostfixCalculator;
import calculator.calculator.history.CalculationHistory;
import calculator.view.input.MenuCalculatorInput;

public class MenuCalculator implements Menu {

    private final CalculationHistory calculationHistory;
    private final MenuCalculatorInput input;
    public final Calculator calculator;

    public MenuCalculator() {
        calculationHistory = new CalculationHistory();
        input = new MenuCalculatorInput();
        calculator = new PostfixCalculator();
    }

    @Override
    public void process() {
        String formula = input.askFormula();
        Double result = calculator.calculate(formula);

        calculationHistory.save(formula, result);
    }

}
