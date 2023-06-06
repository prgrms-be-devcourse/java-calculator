package calulator.domain;

import calulator.util.StringSplitter;

import java.util.List;
import java.util.function.Predicate;

public class Expression {

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

    public String calculateExpression() {
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

    private int operateResult(int index) {
        return Operation.operator(expressions.get(index),
                Integer.valueOf(expressions.get(index - 1)),
                Integer.valueOf(expressions.get(index + 1)));
    }

    private void replaceExpression(int index, int result) {
        for (int i = index + 1; i >= index - 1; i--) {
            expressions.remove(i);
        }
        expressions.add(index - 1, String.valueOf(result));
    }

}
