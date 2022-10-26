package calculator.engine.calculator;

import calculator.engine.model.CalculationResult;
import calculator.engine.model.Expression;

import java.util.ArrayDeque;
import java.util.Deque;

public class PostfixCalculator implements ArithmeticCalculator {

    @Override
    public CalculationResult calculate(Expression postfix) {
        Deque<Integer> deque = new ArrayDeque<>();
        postfix.getExpression().forEach(each -> calculateByOperator(deque, each));
        return new CalculationResult(deque.removeFirst().toString());
    }

    private void calculateByOperator(Deque<Integer> deque, String each) {
        if (!ArithmeticOperator.isOperator(each)) {
            deque.addFirst(Integer.valueOf(each));
            return;
        }

        ArithmeticOperator operator = ArithmeticOperator.toOperator(each);
        Integer secondOperand = deque.removeFirst();
        Integer firstOperand = deque.removeFirst();
        Integer result = operator.calculate(firstOperand, secondOperand);
        deque.addFirst(result);
    }
}
