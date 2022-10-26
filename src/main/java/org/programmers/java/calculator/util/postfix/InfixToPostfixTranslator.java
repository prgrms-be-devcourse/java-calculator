package org.programmers.java.calculator.util.postfix;

import org.programmers.java.calculator.model.Operator;

import java.util.List;
import java.util.Stack;

public class InfixToPostfixTranslator {

    public static String infixToPostfix(List<String> tokens) {
        StringBuffer sb = new StringBuffer();
        Stack<Operator> stack = new Stack<>();

        middleProcess(tokens, sb, stack);
        extractRemainOperatorFromStack(sb, stack);

        return sb.toString();
    }

    private static void extractRemainOperatorFromStack(StringBuffer sb, Stack<Operator> stack) {
        while (!stack.isEmpty()){
            Operator pop = stack.pop();
            if(Operator.OPEN_BRACKET.equals(pop)) throw new IllegalStateException();//남은 연산자에 (가 있으면 오류
            sb.append(pop.getCharValue());
        }
    }

    private static void middleProcess(List<String> tokens, StringBuffer sb, Stack<Operator> stack) {
        for (int i = 0; i < tokens.size(); i++) {
            char character = tokens.get(i).charAt(0);

            if (Character.isDigit(character)) {
                sb.append(character);
                continue;
            }

            Operator inputOperator = Operator.from(character);
            checkValid(inputOperator);//유효한 연산자인지 검사하고, 아닌 경우 예외 발생


            if (Operator.CLOSE_BRACKET.equals(inputOperator)) {//닫는 괄호가 나온 경우
                if (stack.isEmpty()) throw new IllegalStateException();//스택이 비어있으면 오류
                Operator poppedOperator = stack.pop();
                while (!Operator.OPEN_BRACKET.equals(poppedOperator)) {
                    sb.append(poppedOperator.getCharValue());
                    if (stack.isEmpty()) throw new IllegalStateException();
                    poppedOperator = stack.pop();
                }
            }

            else {//닫는 괄호 이외의 연산자
                while (!stack.isEmpty() &&
                        stack.peek().getPriorityInStack() >= inputOperator.getPriorityAsInput()) {
                    sb.append(stack.pop().getCharValue());
                }
                stack.push(inputOperator);
            }
        }
    }

    private static void checkValid(Operator inputOperator) {
        if(Operator.NOT_DEFINED.equals(inputOperator))  throw new IllegalStateException();
    }
}
