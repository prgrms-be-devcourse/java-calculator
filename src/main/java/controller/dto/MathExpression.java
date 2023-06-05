package controller.dto;

import exception.CalculatorException;
import exception.ErrorMessage;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class MathExpression {
    private static final Pattern OPERAND_PATTERN = Pattern.compile("^[\\-]?[0-9]+$");
    private final ArrayList<String> op = new ArrayList<>();;
    private final ArrayList<Integer> nums = new ArrayList<>();

    public MathExpression(final String exp) throws CalculatorException {
        String[] splitExp = exp.split(" ");
        extractFromStringExp(splitExp);
    }

    private void extractFromStringExp(final String[] splitExp) throws CalculatorException {
        boolean numFlag = true; // 숫자->연산자->숫자... 형식으로 구성된 식인지 검증
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
            throw new CalculatorException(ErrorMessage.INVALID_EXPRESSION); //예시)5 + 3 / 2 +
        }
    }

    public static MathExpression from(final String exp) throws CalculatorException {
        return new MathExpression(exp);
    }

    public ArrayList<String> getOp() {
        return op;
    }

    public ArrayList<Integer> getNums() {
        return nums;
    }
}
