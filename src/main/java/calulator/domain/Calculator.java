package calulator.domain;

import calulator.repository.ExpressionRepository;
import calulator.view.InputView;
import calulator.view.OutputView;

import java.util.List;

import static calulator.domain.Expression.createExpression;
import static calulator.domain.Menu.*;

public class Calculator {

    private final InputView inputView;
    private final OutputView outputView;

    private final ExpressionRepository expressionRepository;

    public Calculator(InputView inputView, OutputView outputView, ExpressionRepository expressionRepository) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.expressionRepository = expressionRepository;
    }

    public void run() {
        Menu menu;
        do {
            menu = inputView.inputMenu();
            executeMenuOption(menu);
        } while (menu != null);
    }

    private void executeMenuOption(Menu menu) {
        if (menu == CALCULATED_LOG) {
            List<String> strings = expressionRepository.resultsToList();
            outputView.printCalculateResults(strings);
        } else if (menu == CALCULATE) {
            String expression = inputView.inputExpression();
            String calculateResult = calculateResult(expression);
            outputView.printCalculateResult(calculateResult);
        }
    }

    private String calculateResult(String inputValue) {
        final Expression expression = createExpression(inputValue);
        String calculateResult = expression.calculate();
        expressionRepository.addExpressionAndResult(inputValue, calculateResult);
        return calculateResult;
    }

}
