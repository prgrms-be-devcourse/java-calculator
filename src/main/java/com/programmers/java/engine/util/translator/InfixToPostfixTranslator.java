package com.programmers.java.engine.util.translator;

import com.programmers.java.engine.model.Expression;
import com.programmers.java.engine.util.Operator;

import java.util.Arrays;
import java.util.List;

public class InfixToPostfixTranslator extends Translator {
    public InfixToPostfixTranslator() {
        super();
    }

    // 중위 표기식을 후위 표기식으로 바꾸는 함수
    @Override
    public Expression translate(Expression origin) {
        StringBuffer expression = new StringBuffer();
        List<String> tokens = Arrays.asList(origin.toString().split(" "));

        tokens.stream()
                .forEach(token -> {
                    if (token.matches("[0-9]+")) {
                        // 피연산자인 경우에는 수식에 바로 포함
                        expression.append(token).append(" ");
                    } else {
                        Operator operator = Operator.findOperator(token);

                        if (Operator.RIGHT_BRACKET.equals(operator)) {
                            // "(" 괄호가 나올 때까지 연산자 꺼내기
                            while (!Operator.LEFT_BRACKET.equals(this.deque.peek())) {
                                expression.append(this.deque.pop().toString()).append(" ");
                            }
                            // "(" 괄호 제거
                            this.deque.pop();
                        } else {
                            // 연산 가능한 연산자인 경우
                            while (!this.deque.isEmpty() && Operator.getISP(this.deque.peekFirst()) >= Operator.getICP(operator)) {
                                expression.append(this.deque.pop().toString()).append(" ");
                            }
                            this.deque.push(operator);
                        }
                    }
                });
        while (!this.deque.isEmpty()) {
            expression.append(this.deque.pop().toString()).append(" ");
        }
        return new Expression(expression.toString());
    }
}
