package calculator.domain;

import calculator.exception.InvalidOperatorException;
import calculator.repository.CalculatorRepository;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class BaseCalculator implements Calculator {
    private final CalculatorRepository calculatorRepository;

    public BaseCalculator(CalculatorRepository calculatorRepository) {
        this.calculatorRepository = calculatorRepository;
    }

    @Override
    public List<CalculationResultHistory> getAllData() {
        return calculatorRepository.getAll();
    }

    @Override
    public String calculate(String expression) {
        Stack<Integer> stack = new Stack<>();
        expression = expressionFormat(expression);

        Optional<String> history = calculatorRepository.getResultFromExpression(expression);
        if (history.isPresent()) {
            return history.get();
        }

        String postFix = transToPostfix(expression);

        char[] array = postFix.toCharArray();
        for (char c : array) {
            if ('0' <= c && c <= '9')
                stack.push(c - '0');
            else {
                int a = stack.pop();
                int b = stack.pop();

                Operator operator = Operator.getOperator(c);
                stack.push(operator.calculate(b, a));
            }
        }
        String answer = String.valueOf(stack.pop());
        saveCalculationData(expression, answer);
        return answer;
    }

    private String expressionFormat(String expression) {
        return expression.replace(" ", "").trim();
    }

    private String transToPostfix(String inFix) {
        char[] array = inFix.toCharArray();
        Stack<Character> stack = new Stack<>();
        String postFix = "";

        for (char c : array) {
            if (c == '(') stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    postFix += (char) stack.pop();
                stack.pop();
            } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                while (!stack.isEmpty() && (Operator.getPriority(stack.peek()) <= Operator.getPriority(c)))
                    postFix += (char) stack.pop();
                stack.push(c);
            } else if ('0' <= c && c <= '9')
                postFix += c;
            else throw new InvalidOperatorException();
        }

        while (!stack.isEmpty())
            postFix += (char) stack.pop();

        return postFix;
    }

    private void saveCalculationData(String expression, String answer) {
        CalculationResultHistory calculationResult = new CalculationResultHistory(expression, answer);
        calculatorRepository.save(calculationResult);
    }
}
