package calulator.domain;

import calulator.repository.ExpressionRepository;
import calulator.util.StringSplitter;
import calulator.view.InputView;
import calulator.view.OutputView;

import java.util.List;

import static calulator.domain.Menu.SELECT;

public class Calculator {

    private final InputView inputView;
    private final ExpressionRepository expressionRepository;
    private Expression expression;

    public Calculator(InputView inputView, ExpressionRepository expressionRepository) {
        this.inputView = inputView;
        this.expressionRepository = expressionRepository;
    }

    public void run() {
        while (true) {
            Menu menu = inputView.inputMenu();
            process(menu);
        }
    }

    private void process(Menu menu) {
        if (menu == SELECT) {
            List<String> strings = expressionRepository.resultsToList();
            OutputView.printCalculateResults(strings);
            return;
        }

        String inputValue = inputView.inputExpression();
        String calculateResult = getCalculateResult(inputValue);
        OutputView.printCalculateResult(calculateResult);
    }

    private void createExpression(String inputValue) {
        List<String> expressions = StringSplitter.splitByOperator(inputValue);
        this.expression = new Expression(expressions);
    }

    private String getCalculateResult(String inputValue) {
        createExpression(inputValue);
        String calculateResult = expression.calculateExpression();
        expressionRepository.addExpression(inputValue, calculateResult);
        return calculateResult;
    }

}
