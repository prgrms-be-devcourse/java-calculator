import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prefix2PostfixConverter implements ExpressionConverter {

    @Override
    public List<String> convert(String expression) {

        List<String> expressionList = expressionToList(expression);
        List<String> postfixExpression = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        for (String s : expressionList) {

            if (!Opcode.isOperator(s)) {
                postfixExpression.add(s);
                continue;
            }

            if (Opcode.isRightParenthesis(s)) {
                while (!stack.isEmpty() && !Opcode.isLeftParenthesis(stack.peek())) {
                    postfixExpression.add(stack.pop());
                }
                stack.pop();
                continue;
            }

            Opcode opcode = Opcode.findOperator(s);
            while (!stack.isEmpty() && Opcode.compareTo(opcode, stack.peek())) {
                if (Opcode.isParenthesis(stack.peek())) break;
                postfixExpression.add(stack.pop());
            }

            stack.push(s);
        }

        while (!stack.isEmpty()) postfixExpression.add(stack.pop());

        return postfixExpression;
    }

}
