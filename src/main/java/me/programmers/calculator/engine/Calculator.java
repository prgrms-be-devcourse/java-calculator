package me.programmers.calculator.engine;

import java.util.List;
import java.util.Stack;

public class Calculator {

    public long calculateFormula(String problem) {
        List<String> posteriorProblem = Posterior.convertToPosterior(problem);  // 후위표기식 변환 1+2*3 -> 123*+
        return fourArithmeticOperations(posteriorProblem);
    }

    // 후위표기식 계산
    private long fourArithmeticOperations(List<String> postOrderProblem) {
        Stack<Long> calcStack = new Stack<>();
        for (String s : postOrderProblem) {
            long sum = 0;
            if (Operator.isOperator(s.charAt(0))) {
                Operator op = Operator.getOperator(s.charAt(0));
                long b = calcStack.pop();
                long a = calcStack.pop();
                sum = doOperation(a, b, op);
            } else {
                sum = Long.parseLong(s);
            }
            calcStack.push(sum);
        }

        return calcStack.pop();
    }

    private long doOperation(long a, long b, Operator op) {
        switch (op){
            case PLUS:
                return a + b;
            case MINUS:
                return a - b;
            case MUL:
                return a * b;
            case DIV:
                if (b == 0)
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                return a / b;
            default:
                throw new ArithmeticException("연산자를 잘못 입력했습니다.");
        }
    }

}
