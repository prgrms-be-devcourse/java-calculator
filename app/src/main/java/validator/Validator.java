package validator;

public class Validator {
    private static final int END_CHOICE = 0;
    private static final int READ_CHOICE = 1;
    private static final int CALCULATE_CHOICE = 2;
    private static final String positiveRegularExp = "\\d+(\\.\\d+)?";
    private static final char[] ops = {'(', ')', '+', '-', '*', '/'};

    public static int checkChoiceNum(int num) {
        if (num != END_CHOICE && num != READ_CHOICE && num != CALCULATE_CHOICE) {
            throw new IllegalArgumentException("0 또는 1 또는 2를 선택하십시오");
        }
        return num;
    }

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