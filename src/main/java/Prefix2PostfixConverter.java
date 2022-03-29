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
        validate(expressionList);

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
     * 각 조건마다 validate 하여 예외를 던집니다.
     *
     * @param expressionList
     * @throws CalculatorException
     */
    @Override
    public void validate(List<String> expressionList) throws CalculatorException {

        if (expressionList.size() <= 2)
            throw new CalculatorException("적어도 3개의 연산항이 필요합니다.");

        String firstOp = expressionList.get(0);
        if (Opcode.isOperator(firstOp) && !Opcode.isLeftParenthesis(firstOp))
            throw new CalculatorException("연산자로 시작하는 올바르지 않은 연산식 입니다.");

        String lastOp = expressionList.get(expressionList.size() - 1);
        if (Opcode.isOperator(lastOp) && !Opcode.isRightParenthesis(lastOp))
            throw new CalculatorException("연산자로 끝난 올바르지 않은 연산식 입니다.");

        int parenthesisCount = 0;
        for (String s : expressionList) {
            if (!Opcode.isOperator(s) && !isValidDouble(s))
                throw new CalculatorException("피연산자가 범위를 초과했거나 지원하지 않는 연산자가 포함되어 있습니다.");

            if (s.equals("(")) parenthesisCount++;
            if (s.equals(")")) parenthesisCount--;
            if (parenthesisCount < 0) throw new CalculatorException("괄호의 짝이 맞지 않는 연산식입니다.");
        }

        if (parenthesisCount != 0) throw new CalculatorException("괄호의 짝이 맞지 않는 연산식입니다.");

    }

    /**
     * input값이 Double값에 적절하면 true를 반환합니다.
     * input값이 Double값을 초과하거나, NumberFormat에 맞지않으면 false를 반환합니다.
     *
     * @param input
     * @return
     */
    private static boolean isValidDouble(String input) {
        final BigDecimal MAX_DOUBLE = new BigDecimal(Double.MAX_VALUE);
        try {
            BigDecimal bigInput = new BigDecimal(input);
            return bigInput.compareTo(MAX_DOUBLE) < 1;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
