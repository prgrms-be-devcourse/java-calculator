package org.programmers.java.calculator.util.postfix;

import org.programmers.java.calculator.model.Operator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class PostfixTranslator {

    private final PostfixCalculator postfixCalculator = new PostfixCalculator();

    public Double infixToPostfix(List<String> tokens) {
        StringBuilder sb = new StringBuilder();
        Deque<Operator> deque = new ArrayDeque<>();

        translator(tokens, sb, deque);
        extractRemainOperatorFromDeque(sb, deque);
        return postfixCalculator.calculate(sb.toString());
    }

    private void extractRemainOperatorFromDeque(StringBuilder sb, Deque<Operator> deque) {
        while (!deque.isEmpty()) {
            Operator pollFirst = deque.pollFirst();
            if (Operator.OPEN_BRACKET.equals(pollFirst)) throw new IllegalStateException("( 연산자가 남아 있습니다!");//남은 연산자에 (가 있으면 오류
            sb.append(pollFirst.getCharValue());
        }
    }

    private void translator(List<String> tokens, StringBuilder sb, Deque<Operator> deque) {
        for (int i = 0; i < tokens.size(); i++) {
            char character = tokens.get(i).charAt(0);

            if (Character.isDigit(character)) {
                sb.append(character);
                continue;
            }

            Operator inputOperator = Operator.from(character);
            checkValid(inputOperator);//유효한 연산자인지 검사하고, 아닌 경우 예외 발생

            if (Operator.CLOSE_BRACKET.equals(inputOperator)) {//닫는 괄호가 나온 경우
                if (deque.isEmpty()) throw new IllegalStateException("잘못된 공식이 입력되었습니다.");//스택이 비어있으면 오류
                Operator poppedOperator = deque.pollFirst();
                while (!Operator.OPEN_BRACKET.equals(poppedOperator)) {
                    sb.append(poppedOperator.getCharValue());
                    if (deque.isEmpty()) throw new IllegalStateException("잘못된 공식이 입력되었습니다.");
                    poppedOperator = deque.pollFirst();
                }
            } else {//닫는 괄호 이외의 연산자
                while (!deque.isEmpty() &&
                        deque.peekFirst().getPriorityInStack() >= inputOperator.getPriorityAsInput()) {
                    sb.append(deque.pollFirst().getCharValue());
                }
                deque.addFirst(inputOperator);
            }
        }
    }

    private void checkValid(Operator inputOperator) {
        if (Operator.NOT_DEFINED.equals(inputOperator)) throw new IllegalStateException("잘못된 공식이 입력되었습니다.");
    }
}
