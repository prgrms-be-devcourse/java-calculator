package org.programmers.java.calculator.util.postfix;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.programmers.java.calculator.model.Operator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class InfixToPostfixTranslator {

    InfixToPostfixTranslator() {

    }

    public static String infixToPostfix(List<String> tokens) {
        StringBuilder sb = new StringBuilder();
        Deque<Operator> deque = new ArrayDeque<>();

        middleProcess(tokens, sb, deque);
        extractRemainOperatorFromStack(sb, deque);

        return sb.toString();
    }

    private static void extractRemainOperatorFromStack(StringBuilder sb, Deque<Operator> deque) {
        while (!deque.isEmpty()){
            Operator pop = deque.pop();
            if(Operator.OPEN_BRACKET.equals(pop)) throw new IllegalStateException();//남은 연산자에 (가 있으면 오류
            sb.append(pop.getCharValue());
        }
    }

    private static void middleProcess(List<String> tokens, StringBuilder sb, Deque<Operator> deque) {
        for (int i = 0; i < tokens.size(); i++) {
            char character = tokens.get(i).charAt(0);

            if (Character.isDigit(character)) {
                sb.append(character);
                continue;
            }

            Operator inputOperator = Operator.from(character);
            checkValid(inputOperator);//유효한 연산자인지 검사하고, 아닌 경우 예외 발생


            if (Operator.CLOSE_BRACKET.equals(inputOperator)) {//닫는 괄호가 나온 경우
                if (deque.isEmpty()) throw new IllegalStateException();//스택이 비어있으면 오류
                Operator poppedOperator = deque.pop();
                while (!Operator.OPEN_BRACKET.equals(poppedOperator)) {
                    sb.append(poppedOperator.getCharValue());
                    if (deque.isEmpty()) throw new IllegalStateException();
                    poppedOperator = deque.pop();
                }
            }

            else {//닫는 괄호 이외의 연산자
                while (!deque.isEmpty() &&
                        deque.peek().getPriorityInStack() >= inputOperator.getPriorityAsInput()) {
                    sb.append(deque.pop().getCharValue());
                }
                deque.push(inputOperator);
            }
        }
    }

    private static void checkValid(Operator inputOperator) {
        if(Operator.NOT_DEFINED.equals(inputOperator))  throw new IllegalStateException();
    }
}
