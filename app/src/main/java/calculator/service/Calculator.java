package calculator.service;

import static calculator.entity.Operator.getOperatorWithSameSymbol;
import static calculator.utils.StringUtils.isNumeric;
import static calculator.utils.StringUtils.makeHistory;
import static calculator.utils.StringUtils.splitToElements;
import static calculator.view.InputView.inputExpression;
import static calculator.view.OutputView.showCalculationResult;
import static calculator.view.OutputView.showExpressionInputMessage;

import calculator.entity.Operator;
import calculator.storage.HistoryStorage;
import java.util.Stack;

public class Calculator {

    private final HistoryStorage historyStorage;

    public Calculator(HistoryStorage historyStorage) {
        this.historyStorage = historyStorage;
    }

    public void execute() {
        showExpressionInputMessage();

        String expression = inputExpression();
        int calculationResult = calculate(expression);

        String history = makeHistory(expression, calculationResult);
        historyStorage.save(history);

        showCalculationResult(calculationResult);
    }

    private int calculate(String expression) {
        String[] elements = splitToElements(expression);
        Stack<Integer> operands = new Stack<>();
        Stack<Operator> operators = new Stack<>();

        for (String element : elements) {
            savePartialEvaluationResult(operands, operators, element);
        }

        return operands.pop();
    }

    private void savePartialEvaluationResult(Stack<Integer> operands, Stack<Operator> operators,
        String element) {
        if (!isNumeric(element)) {
            Operator operator = getOperatorWithSameSymbol(element);
            operators.push(operator);

            return;
        }

        if (operators.isEmpty()) {
            int operand = Integer.parseInt(element);
            operands.push(operand);

            return;
        }

        pushEvaluationResult(operands, operators, element);
    }

    private void pushEvaluationResult(Stack<Integer> operands, Stack<Operator> operators,
        String element) {
        Operator operator = operators.pop();
        int operand1 = operands.pop();
        int operand2 = Integer.parseInt(element);

        int evaluationResult = operator.evaluate(operand1, operand2);
        operands.push(evaluationResult);
    }
}
