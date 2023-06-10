package model;

import util.CalculatorUtil;

public class Calculator {
    private final Operand operand;
    private final Operator operator;

    public Calculator() {
        this.operand = new Operand();
        this.operator = new Operator();
    }

    public int calculate(String expression) {
        for (char component : expression.toCharArray()) {
            if (component == ' ') {
                continue;
            }

            if (CalculatorUtil.isDigit(component)) {
                operand.push(Character.getNumericValue(component));
                continue;
            }

            if (!operator.isEmpty()) {
                OperatorType currentOperator = OperatorType.getOperator(String.valueOf(component));
                OperatorType peekOperator = operator.peekOperator();

                if (peekOperator.getPrecedence() > currentOperator.getPrecedence()) {
                    int num2 = operand.pop();
                    int num1 = operand.pop();
                    int result = peekOperator.applyCalculate(num1, num2);
                    operand.push(result);
                    operator.pop();
                }
            }
            operator.push(component);
        }

        while (!operator.isEmpty()) {
            OperatorType currentOperator = operator.pop();
            int num2 = operand.pop();
            int num1 = operand.pop();
            int result = currentOperator.applyCalculate(num1, num2);
            operand.push(result);
        }

        return operand.pop();
    }
}

// 연산자면 에러와 예외의 차이
// 에러는 메모리 부족,
// 터지거나 예상치 못한 것
// 예외는 비즈니스 서비스에서 지원하지 않는 값이 들어온것,
// 예기치 못한 이상한 ? -> 프로그램 수행에 영향
// 비즈니스 로직에 관한 예외
// ex) 너무 큰 숫자일 경우 -> 같은 예외처리 중복으로 했는지도 생각해보기
