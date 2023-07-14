package model.calculation;

import constant.Operator;
import model.vo.CalculationResult;

import java.util.List;
import java.util.Stack;

import static constant.Operator.*;

public class CalculationImpl implements Calculation {
    private static final String IS_NUMBER_PATTERN = "^[0-9]+$";
    public static final String ZERO_DIVIDE = "0으로 나눌 수 없습니다.";
    private final Stack<Integer> numberStack = new Stack<>();

    @Override
    public CalculationResult calculate(List<String> postfixExpression) {
        for (String textSegment : postfixExpression) {
            if (isNumber(textSegment)) {
                pushNumberToStack(Integer.parseInt(textSegment));
            }

            if (isOperator(textSegment)) {
                Integer operationResult = calculatePostfixOperation(textSegment);
                pushNumberToStack(operationResult);
            }
        }

        return new CalculationResult(numberStack.pop());
    }

    private boolean isNumber(String s) {
        return s.matches(IS_NUMBER_PATTERN);
    }

    private Integer calculatePostfixOperation(String textSegment) {
        Integer nowNumber = numberStack.pop();
        Integer prevNumber = numberStack.pop();
        Operator operator = findOperator(textSegment);
        Integer operationResult = calculateArithmetic(operator, prevNumber, nowNumber);
        return operationResult;
    }

    private void pushNumberToStack(Integer number) {
        numberStack.push(number);
    }
}
