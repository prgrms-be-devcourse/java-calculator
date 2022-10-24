package calculator.menu;

import calculator.calculator.Calculator;
import calculator.calculator.PostfixCalculator;
import calculator.calculator.history.CalculationHistory;
import calculator.calculator.history.History;
import calculator.view.input.MenuCalculatorInput;
import calculator.view.output.MenuCalculatorOutput;

public class MenuCalculator implements Menu {

    private final MenuCalculatorInput input;
    private final MenuCalculatorOutput output;
    private final History history;
    public final Calculator calculator;

    public MenuCalculator() {
        input = new MenuCalculatorInput();
        output = new MenuCalculatorOutput();
        history = new CalculationHistory();
        calculator = new PostfixCalculator();
    }

    @Override
    public void process() {
        String formula = input.askFormula();
        String result = calculator.calculate(formula).toString();

        history.save(formula, result);

        output.printAnswer(result);
        output.printAfter();
    }

}
