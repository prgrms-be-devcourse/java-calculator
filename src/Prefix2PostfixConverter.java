import exception.CalculatorException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prefix2PostfixConverter implements ExpressionConverter {

    private static boolean isValidDouble(String input){
        final BigDecimal MAX_DOUBLE = new BigDecimal(Double.MAX_VALUE);
        try{
            BigDecimal bigInput = new BigDecimal(input);
            return bigInput.compareTo(MAX_DOUBLE) < 1;
        }catch(NumberFormatException e){
            return false;
        }
    }

    @Override
    public void validate(List<String> expressionList) throws CalculatorException {

        String lastOp = expressionList.get(expressionList.size() - 1);
        if (Opcode.isOperator(lastOp) && !Opcode.isRightParenthesis(lastOp))
            throw new CalculatorException("연산자로 끝난 올바르지 않은 연산식 입니다.");
        if (expressionList.size() <= 2) throw new CalculatorException("적어도 3개의 연산항이 필요합니다.");

        int parenthesisCount = 0;
        for (String s : expressionList) {
            if (!Opcode.isOperator(s) && !isValidDouble(s)) throw new CalculatorException("피연산자가 범위를 초과했거나 지원하지 않는 연산자가 포함되어 있습니다.");
            if (s.equals("(")) parenthesisCount++;
            if (s.equals(")")) parenthesisCount--;
            if (parenthesisCount < 0) throw new CalculatorException("괄호의 짝이 맞지 않는 연산식입니다.");
        }
    }

    @Override
    public List<String> convert(String expression) {

        List<String> expressionList = expressionToList(expression);
        validate(expressionList);
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
            while (!stack.isEmpty() && Opcode.comparePriority(opcode, stack.peek())) {
                if (Opcode.isParenthesis(stack.peek())) break;
                postfixExpression.add(stack.pop());
            }

            stack.push(s);
        }

        while (!stack.isEmpty()) postfixExpression.add(stack.pop());

        return postfixExpression;
    }

}
