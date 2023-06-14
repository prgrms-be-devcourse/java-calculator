package validator;

public class Validator {
    private static final String positiveRegularExp = "\\d+(\\.\\d+)?";
    private static final char[] ops = {'(', ')', '+', '-', '*', '/'};

    public static char checkValidOperator(char operator) {
        for (char op : ops) {
            if (op == operator) {
                return operator;
            }
        }

        throw new IllegalArgumentException("유효하지 않은 연산자입니다");
    }

    public static boolean checkPositiveNum(String str) {
        if (str.matches(positiveRegularExp)) {
            return true;
        }

        throw new IllegalArgumentException("음수는 입력이 불가합니다.");
    }
}
