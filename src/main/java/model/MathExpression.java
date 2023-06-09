package model;

import exception.CalculatorException;
import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Pattern;

public class MathExpression {
    private static final Pattern OPERAND_PATTERN = Pattern.compile("^[\\-]?[0-9]+$");
    private final ArrayList<String> op = new ArrayList<>();;
    private final ArrayList<Integer> nums = new ArrayList<>();

    private MathExpression(final String exp) throws CalculatorException {
        createMathExpressionWithValidationCheck(exp);
    }

    public static MathExpression from(final String exp) throws CalculatorException {
        return new MathExpression(exp);
    }

    private void createMathExpressionWithValidationCheck(final String exp) throws CalculatorException {
        String[] splitExp = exp.split(" ");
        boolean numFlag = true; // 숫자 연산자 숫자... 형식으로 구성된 식인지 검증
        for (String s : splitExp) {
            if (OPERAND_PATTERN.matcher(s).matches() && numFlag) {
                nums.add(Integer.valueOf(s));
                numFlag = false;
            } else if (!numFlag && (s.length() == 1) && (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))) {
                op.add(s);
                numFlag = true;
            }
            else throw new CalculatorException(ErrorMessage.INVALID_EXPRESSION);
        }
        if (numFlag) {
            throw new CalculatorException(ErrorMessage.INVALID_EXPRESSION); //ex)5 + 3 / 2 +
        }
    }

    public int calculate() {
        ArrayList<String> remainOp = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(nums.get(0));
        for (int i = 0; i < op.size(); ++i) {
            switch (op.get(i)) {
                case "+", "-" -> {
                    stack.push(nums.get(i + 1));
                    remainOp.add(op.get(i));
                }
                case "*" -> stack.push(stack.pop() * nums.get(i + 1));
                case "/" -> stack.push(stack.pop() / nums.get(i + 1));
            }
        }
        int sum = stack.get(0);
        for (int i = 0; i < remainOp.size(); ++i) {
            switch (remainOp.get(i)) {
                case "+" -> sum += stack.get(i + 1);
                case "-" -> sum -= stack.get(i + 1);
            }
        }
        return sum;
    }
}
