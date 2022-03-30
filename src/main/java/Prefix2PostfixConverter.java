import exception.CalculatorException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prefix2PostfixConverter implements ExpressionConverter {

    /**
     * 사용자가 입력한 String expression을 List<String>으로 바꾸고, 그에 대한 validate 후 Postfix로 convert 합니다.
     *
     * @param expression
     * @return 사용자가 입력한 Prefix expression을 Postfix로 바꾸어 List<String>로 리턴합니다.
     */
    @Override
    public List<String> convert(String expression) {

        List<String> postfixExpression = new ArrayList<>();
        Stack<String> stack = new Stack<>();

        List<String> expressionList = expressionToList(expression);
        if(!validate(expressionList)) return List.of();

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

            Opcode opcode = Opcode.findOperator(s).orElseThrow();
            while (!stack.isEmpty() && Opcode.comparePriority(opcode, stack.peek())) {
                if (Opcode.isParenthesis(stack.peek())) break;
                postfixExpression.add(stack.pop());
            }

            stack.push(s);
        }

        while (!stack.isEmpty()) postfixExpression.add(stack.pop());

        return postfixExpression;
    }

    /**
     * 각 조건마다 validate 하여 true, false 반환합니다.
     *
     * @param expressionList
     * @throws CalculatorException
     */
    public boolean validate(List<String> expressionList) {

        if (expressionList.size() <= 2)
            return false;

        String firstOp = expressionList.get(0);
        if (Opcode.isOperator(firstOp) && !Opcode.isLeftParenthesis(firstOp))
            return false;

        String lastOp = expressionList.get(expressionList.size() - 1);
        if (Opcode.isOperator(lastOp) && !Opcode.isRightParenthesis(lastOp))
            return false;

        int parenthesisCount = 0;
        for (String s : expressionList) {
            if (!Opcode.isOperator(s) && !isValidDouble(s))
                return false;

            if (s.equals("(")) parenthesisCount++;
            if (s.equals(")")) parenthesisCount--;
            if (parenthesisCount < 0) return false;
        }

        if (parenthesisCount != 0) return false;

        return true;

    }

    /**
     * input값이 Double값에 적절하면 true를 반환합니다.
     * input값이 Double값을 초과하거나, NumberFormat에 맞지않으면 false를 반환합니다.
     *
     * @param input
     * @return
     */
    private boolean isValidDouble(String input) {
        try {
            Double.valueOf(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
