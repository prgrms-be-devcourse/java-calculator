package calulator.domain;

import calulator.repository.ExpressionRepository;
import calulator.view.InputView;
import calulator.view.OutputView;

import java.util.List;

import static calulator.domain.Expression.createExpression;
import static calulator.domain.Menu.*;

public class Calculator {

    private final InputView inputView;
    private final ExpressionRepository expressionRepository;
    private Expression expression;

    public Calculator(InputView inputView, ExpressionRepository expressionRepository) {
        this.inputView = inputView;
        this.expressionRepository = expressionRepository;
    }

    public void run() {
        Menu menu;
        do {
            menu = inputView.inputMenu();
            process(menu);
        } while (menu != null);
    }

    private void process(Menu menu) {
        if (menu == CALCULATED_LOG) {
            List<String> strings = expressionRepository.resultsToList();
            OutputView.printCalculateResults(strings);
        } else if (menu == CALCULATE) {
            String expression = inputView.inputExpression();
            String calculateResult = getCalculateResult(expression);
            OutputView.printCalculateResult(calculateResult);
        }
    }

    private String getCalculateResult(String inputValue) {
        this.expression = createExpression(inputValue);
        String calculateResult = expression.calculateExpression();
        expressionRepository.addExpression(inputValue, calculateResult);
        return calculateResult;
    }

}
