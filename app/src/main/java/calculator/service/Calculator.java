package calculator.service;

import static calculator.entity.Operator.getOperatorWithSameSymbol;
import static calculator.utils.StringUtils.isNumeric;
import static calculator.utils.StringUtils.splitToElements;
import static calculator.view.InputView.inputExpression;
import static calculator.view.OutputView.showCalculationResult;
import static calculator.view.OutputView.showExpressionInputMessage;

import calculator.entity.Operator;
import java.util.Stack;

public class Calculator {

    public void calculate() {
        showExpressionInputMessage();
        int calculationResult = solve(inputExpression());
        showCalculationResult(calculationResult);
    }

    private int solve(String expression) {
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

        Operator operator = operators.pop();
        int operand1 = operands.pop();
        int operand2 = Integer.parseInt(element);

        int evaluationResult = operator.evaluate(operand1, operand2);
        operands.push(evaluationResult);
    }
}
