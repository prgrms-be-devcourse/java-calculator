package calculator.domain;

import calculator.repository.CalculatorRepository;

import java.util.List;
import java.util.Stack;

public class BaseCalculator implements Calculator {

    private final Calculation calculation;
    private final CalculatorRepository calculatorRepository;

    public BaseCalculator(Calculation calculation, CalculatorRepository calculatorRepository) {
        this.calculation = calculation;
        this.calculatorRepository = calculatorRepository;
    }

    @Override
    public List<String> getAllData() {
        return calculatorRepository.getAll();
    }

    @Override
    public int calculate(String expression) {
        Stack<Integer> stack = new Stack<>();
        String postFix = transToPostfix(expression);

        char[] array = postFix.toCharArray();
        for (char c : array) {
            if ('0' <= c && c <= '9')
                stack.push(c - '0');
            else {
                int a = stack.pop();
                int b = stack.pop();

                if (c == '+') stack.push(calculation.addition(b, a));
                else if (c == '-') stack.push(calculation.subtraction(b, a));
                else if (c == '*') stack.push(calculation.multiplication(b, a));
                else if (c == '/') stack.push(calculation.division(b, a));
            }
        }
        int answer = stack.pop();
        saveCalculationData(expression, answer);
        return answer;
    }

    private int precedence(char c) {
        if (c == '*' || c == '/') return 2;
        else if (c == '+' || c == '-') return 1;
        else return 0;
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
                while (!stack.isEmpty() && (precedence((char) stack.peek()) >= precedence(c)))
                    postFix += (char) stack.pop();
                stack.push(c);
            } else if ('0' <= c && c <= '9')
                postFix += c;
        }

        while (!stack.isEmpty())
            postFix += (char) stack.pop();

        return postFix;
    }

    private void saveCalculationData(String expression, int answer) {
        calculatorRepository.save(expression + " = " + answer);
    }
}
