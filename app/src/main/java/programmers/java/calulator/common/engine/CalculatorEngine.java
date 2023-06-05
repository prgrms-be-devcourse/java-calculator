package programmers.java.calulator.common.engine;

import programmers.java.calulator.common.operator.Operator;
import programmers.java.calulator.common.utils.Tokenizer;
import programmers.java.calulator.common.utils.Number;
import java.util.Stack;

public class CalculatorEngine {
    private final Stack<Integer> numberStack = new Stack<>();
    private final Stack<Operator> operatorStack = new Stack<>();

    public CalculatorEngine(String rawExpression) {
        Tokenizer tokenizer = new Tokenizer(rawExpression);
        parse(tokenizer.getTokens());
    }

    private void parse(String[] tokens) {
        for (String token : tokens) {
            Number number = new Number(token);
            if (number.isValid()) {
                numberStack.push(number.toInt());
                continue;
            }
            handleOperator(Operator.of(token));
        }

        finalizeCalculation();
    }

    private void handleOperator(Operator operator) {
        while (!operatorStack.isEmpty() && !operator.isHighPriority(operatorStack.peek())) {
            calculateTop();
        }

        operatorStack.push(operator);
    }

    private void finalizeCalculation() {
        while (!operatorStack.isEmpty()) {
            calculateTop();
        }
    }

    private void calculateTop() {
        int number2 = numberStack.pop();
        int number1 = numberStack.pop();
        Operator operator = operatorStack.pop();

        numberStack.push(operator.calculate(number1, number2));
    }

    public int evaluate() {
        return numberStack.pop();
    }
}
