package calculator.menu;

import calculator.calculator.Calculator;
import calculator.calculator.formula.FormulaBasicParser;
import calculator.calculator.history.CalculationHistory;
import calculator.calculator.history.CalculationHistoryForm;
import calculator.calculator.history.History;
import calculator.calculator.notation.calculation.NotationPostfixCalculation;
import calculator.calculator.notation.parser.NotationPostfixParser;
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
        calculator = new Calculator(
                new NotationPostfixCalculation(),
                new NotationPostfixParser(),
                new FormulaBasicParser()
        );
    }

    @Override
    public void process() {
        String formula = input.askFormula();
        CalculationHistoryForm calculationHistoryForm = calculator.calculate(formula);

        history.save(calculationHistoryForm);

        output.printAnswer(calculationHistoryForm);
    }

}
