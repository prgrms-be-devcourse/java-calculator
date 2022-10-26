package calculator.engine.converter;

import calculator.engine.calculator.ArithmeticOperator;
import calculator.engine.model.Expression;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostfixConverter implements Converter {

    @Override
    public Expression toPostfix(Expression infix) {
        List<String> converted = parseExpression(infix.getExpression());
        return new Expression(converted);
    }

    private List<String> parseExpression(List<String> infix) {
        List<String> converted = new ArrayList<>();
        Deque<ArithmeticOperator> deque = new ArrayDeque<>();

        infix.forEach(each -> separate(converted, deque, each));
        while (!deque.isEmpty()) {
            converted.add(deque.removeFirst().getSymbol());
        }

        return converted;
    }

    private void separate(List<String> converted, Deque<ArithmeticOperator> deque, String each) {
        if (!ArithmeticOperator.isOperator(each)) {
            converted.add(each);
            return;
        }

        ArithmeticOperator operator = ArithmeticOperator.toOperator(each);
        if (deque.isEmpty()) {
            deque.addFirst(operator);
            return;
        }
        while (!deque.isEmpty() && deque.getFirst().hasSamePriorityOrPrecede(operator)) {
            converted.add(deque.removeFirst().getSymbol());
        }
        deque.addFirst(operator);
    }
}
