package calculator.service;

import static calculator.entity.Operator.getOperatorWithSameSymbol;
import static calculator.utils.StringUtils.isNumeric;
import static calculator.utils.StringUtils.makeHistory;
import static calculator.utils.StringUtils.splitToElements;
import static calculator.view.InputView.inputExpression;
import static calculator.view.OutputView.showCalculationResult;
import static calculator.view.OutputView.showExpressionInputMessage;

import calculator.entity.Expression;
import calculator.entity.Operator;
import calculator.storage.HistoryStorage;
import java.util.Optional;
import java.util.Stack;

public class Calculator {

    private final HistoryStorage historyStorage;

    public Calculator(HistoryStorage historyStorage) {
        this.historyStorage = historyStorage;
    }

    public void execute() {
        showExpressionInputMessage();

        String infixExpression = inputExpression();
        int calculationResult = calculate(infixExpression);

        String history = makeHistory(infixExpression, calculationResult);
        historyStorage.save(history);

        showCalculationResult(calculationResult);
    }

    private int calculate(String infixExpression) {
        String[] elements = splitToElements(infixExpression);
        Stack<Integer> operands = new Stack<>();
        Stack<Operator> operators = new Stack<>();

        for (String element : elements) {
            makeExpression(operands, operators, element)
                .map(Expression::evaluate)
                .ifPresent(operands::push);
        }

        return operands.pop();
    }

    private Optional<Expression> makeExpression(Stack<Integer> operands, Stack<Operator> operators,
        String element) {
        if (!isNumeric(element)) {
            Operator operator = getOperatorWithSameSymbol(element);
            operators.push(operator);

            return Optional.empty();
        }

        if (operators.isEmpty()) {
            int operand = Integer.parseInt(element);
            operands.push(operand);

            return Optional.empty();
        }

        Operator operator = operators.pop();
        int operand1 = operands.pop();
        int operand2 = Integer.parseInt(element);

        return Optional.of(new Expression(operator, operand1, operand2));
    }
}
