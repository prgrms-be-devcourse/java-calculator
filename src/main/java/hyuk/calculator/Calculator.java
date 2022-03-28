package hyuk.calculator;

import hyuk.entity.Operands;
import hyuk.entity.Operators;
import hyuk.entity.Result;
import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    public int add(int firstOperand, int secondOperand) {
        return firstOperand + secondOperand;
    }

    public int subtract(int firstOperand, int secondOperand) {
        return firstOperand - secondOperand;
    }

    public int divide(int firstOperand, int secondOperand) {
        if (secondOperand == 0) {
            throw new IllegalStateException("0으로 나눌 수 없습니다.");
        }
        return firstOperand / secondOperand;
    }

    public int multiply(int firstOperand, int secondOperand) {
        return firstOperand * secondOperand;
    }

    public Result calculate(Operands operands, Operators operators) {
        Deque<Integer> operandsStack = new ArrayDeque<>();
        Deque<Character> operatorsStack = new ArrayDeque<>();

        operandsStack.addLast(operands.getOperands().get(0));

        int operandIdx = 1;
        int operatorIdx = 0;
        while (true) {
            if (operatorIdx >= operators.getOperators().size()) {
                break;
            }

            Character op = operators.getOperators().get(operatorIdx++);
            while (!operatorsStack.isEmpty()) {
                if (op == '+' || op == '-') {
                    if (operatorsStack.getLast() == '*'
                        || operatorsStack.getLast() == '/') {
                        int b = operandsStack.pollLast();
                        int a = operandsStack.pollLast();
                        Character operator = operatorsStack.pollLast();

                        int result = 0;
                        if (operator == '+') {
                            result = add(a, b);
                        } else if (operator == '-') {
                            result = subtract(a, b);
                        } else if (operator == '*') {
                            result = multiply(a, b);
                        } else {
                            result = divide(a, b);
                        }
                        operandsStack.addLast(result);
                        continue;
                    }
                }
                break;
            }

            operatorsStack.add(op);
            operandsStack.add(operands.getOperands().get(operandIdx++));
        }

        while (!operatorsStack.isEmpty()) {
            Character operator = operatorsStack.pollLast();

            int b = operandsStack.pollLast();
            int a = operandsStack.pollLast();

            int result = 0;
            if (operator == '+') {
                result = add(a, b);
            } else if (operator == '-') {
                result = subtract(a, b);
            } else if (operator == '*') {
                result = multiply(a, b);
            } else {
                result = divide(a, b);
            }
            operandsStack.addLast(result);
        }

        return new Result(operandsStack.getLast());
    }
}
