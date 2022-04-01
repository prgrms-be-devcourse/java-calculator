package me.programmers.calculator.engine;

import java.util.List;
import java.util.Stack;

public class Calculator {

    private final String PLUS = "+";
    private final String MINUS = "-";
    private final String MUL = "*";
    private final String DIV = "/";

    public long calculateFormula(String problem) {
        List<String> posteriorProblem = Posterior.convertToPosterior(problem);  // 후위표기식 변환 1+2*3 -> 123*+
        return fourArithmeticOperations(posteriorProblem);
    }

    // 후위표기식 계산
    private long fourArithmeticOperations(List<String> problem) {
        Stack<Long> calcStack = new Stack<>();
        for (String s : problem) {
            long res = 0;
            if (Operator.isOperator(s.charAt(0))) {
                long b = calcStack.pop();
                long a = calcStack.pop();
                switch (s){
                    case PLUS:
                        res = a + b;
                        break;
                    case MINUS:
                        res = a - b;
                        break;
                    case MUL:
                        res = a * b;
                        break;
                    case DIV:
                        if (b == 0)
                            throw new ArithmeticException("0으로 나눌 수 없습니다.");
                        res = a / b;
                        break;
                    default:
                        throw new ArithmeticException("연산자를 잘못 입력했습니다.");
                }
            } else {
                res = Long.parseLong(s);
            }
            calcStack.push(res);
        }

        return calcStack.pop();
    }

}
