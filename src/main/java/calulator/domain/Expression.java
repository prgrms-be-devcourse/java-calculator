package calulator.domain;

import calulator.util.StringSplitter;

import java.util.List;
import java.util.function.Predicate;

public class Expression {
    private static final int LEFT_OPERAND_POSITION = -1;
    private static final int RIGHT_OPERAND_POSITION = 1;
    private static final int INDEX_INIT_VALUE = 2;
    private static final int RESULT_INDEX = 0;
    private final List<String> expressions;

    private Expression(List<String> expressions) {
        this.expressions = expressions;
    }

    public static Expression createExpression(String expression) {
        List<String> expressions = StringSplitter.splitByOperator(expression);
        return new Expression(expressions);
    }

    public String calculate() {
        operate(Operation::isPriority);
        operate(Operation::isNonePriority);

        return expressions.get(RESULT_INDEX);
    }

    private void operate(Predicate<String> isPriority) {
        for (int index = 0; index < expressions.size(); index++) {
            if (isPriority.test(expressions.get(index))) {
                int result = operateResult(index);

                replaceExpression(index, result);
                index -= INDEX_INIT_VALUE;
            }
        }
    }

    private int operateResult(int operatorIndex) {
        return Operation.calculateByOperation(
                expressions.get(operatorIndex),
                Integer.valueOf(expressions.get(operatorIndex + LEFT_OPERAND_POSITION)),
                Integer.valueOf(expressions.get(operatorIndex + RIGHT_OPERAND_POSITION)));
    }

    private void replaceExpression(int operatorIndex, int result) {
        for (int i = operatorIndex + RIGHT_OPERAND_POSITION; i >= operatorIndex + LEFT_OPERAND_POSITION; i--) {
            expressions.remove(i);
        }
        expressions.add(operatorIndex + LEFT_OPERAND_POSITION, String.valueOf(result));
    }

}

