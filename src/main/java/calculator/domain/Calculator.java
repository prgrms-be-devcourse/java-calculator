package calculator.domain;

import calculator.exception.NotSolveEquationException;
import calculator.exception.ValidationEquation;
import util.OperatorMap;

import java.util.List;
import java.util.Stack;

public class Calculator {
    private static final String EQUALS = " = ";

    private String equation;
    private double result;

    public Calculator(String equation, double result) {
        this.equation =equation;
        this.result = result;
    }

    public Calculator(String equation) {
        validate(equation);

        this.equation = equation;
        this.result = makeResult(equation);
    }

    private void validate(String equation) {
        if (ValidationEquation.isDivByZero(equation)) {
            throw new NotSolveEquationException();
        }
    }

    private double makeResult(String equation) {
        String[] eachEquation = equation.split(" ");
        if (eachEquation.length == 1) {
            return Double.parseDouble(eachEquation[0]);
        }
        return calculate(eachEquation);
    }


    private double calculate(String[] eachEquation) {
        Stack<Double> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();

        calculateFirstOrder(eachEquation, numbers, operators);
        return calculateEquation(numbers, operators);
    }

    private void calculateFirstOrder(String[] eachEquation, Stack<Double> numbers, Stack<String> operators) {
        for (int i = 0; i < eachEquation.length; i++) {
            if (isOddNumber(i)) {
                operators.add(eachEquation[i]);
                continue;
            }

            Double num = Double.parseDouble(eachEquation[i]);
            addNumbers(numbers, operators, num);
        }
    }

    private double calculateEquation(Stack<Double> numbers, Stack<String> operators) {
        double ret = numbers.pop();
        while (!numbers.isEmpty()) {
            ret = OperatorMap.apply(operators.pop(), numbers.pop(), ret);
        }
        return ret;
    }

    private void addNumbers(Stack<Double> numbers, Stack<String> operators, double num) {
        if (operators.isEmpty() || !OperatorMap.firstOrder(operators.peek())) {
            numbers.add(num);
            return;
        }

        numbers.add(OperatorMap.apply(operators.pop(), numbers.pop(), num));
    }

    private boolean isOddNumber(int index) {
        return index % 2 != 0;
    }

    public Calculator getCalculator() {
        return new Calculator(this.equation, this.result);
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return this.equation + EQUALS + this.result;
    }
}
