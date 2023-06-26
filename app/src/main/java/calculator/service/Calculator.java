package calculator.service;

import static calculator.utils.StringUtils.makeHistory;

import calculator.entity.Expression;
import calculator.entity.Notation;
import calculator.entity.Operator;
import calculator.storage.HistoryStorage;
import java.util.Stack;

public class Calculator {

    private final HistoryStorage historyStorage;
    private final Notation notation;

    public Calculator(HistoryStorage historyStorage, Notation notation) {
        this.historyStorage = historyStorage;
        this.notation = notation;
    }

    public int calculate(String expression) {
        String[] elements = notation.makeElements(expression);
        int result = evaluate(elements);

        String history = makeHistory(expression, result);
        historyStorage.save(history);

        return result;
    }

    private int evaluate(String[] elements) {
        Stack<Integer> operands = new Stack<>();
        Stack<Operator> operators = new Stack<>();

        for (String element : elements) {
            notation.makeExpression(operands, operators, element)
                .map(Expression::evaluate)
                .ifPresent(operands::push);
        }

        return operands.pop();
    }
}
