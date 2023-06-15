package Domain.Expression.utils;

import Common.Exception.WrongValueException;
import Domain.Expression.utils.Validator.NumberValidator;
import Domain.Expression.utils.Validator.OperationValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class InfixToPostfix {

    public List<String> convert(String infix) throws WrongValueException {
        List<String> postfix = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(infix);
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (NumberValidator.validate(s)) {
                forNumber(postfix, s);
            } else if (OperationValidator.validate(s)) {
                forOperation(postfix, stack, s);
            } else {
                throw new WrongValueException();
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix;
    }

    private void forOperation(List<String> postfix, Stack<String> stack, String operator) {
        while (!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(operator)) {
            postfix.add(stack.pop());
        }
        stack.push(operator);
    }

    private void forNumber(List<String> postfix, String number) {
        postfix.add(number);
    }

    private int getPriority(String s) {
        switch (s) {
            case "*":
            case "/":
                return 1;
        }
        return 0;
    }
}