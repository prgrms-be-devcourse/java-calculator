package calculator.exception;

public class ValidationEquation {
    private static final String ZERO = "0";
    private static final String DIV_OPERATOR = "/";

    public static boolean isDivByZero(String equation) {
        String[] equationArray = equation.split(" ");

        for (int equationIndex = 2; equationIndex < equationArray.length; equationIndex++) {
            if (afterOperator(equationArray[equationIndex], equationArray[equationIndex-1])) {
                return false;
            }
        }
        return true;
    }

    private static boolean afterOperator(String number, String operator) {
        return number.equals(ZERO) && operator.equals(DIV_OPERATOR);
    }

}
