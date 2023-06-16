package util;

public class ValidationEquation {
    private static final String ZERO = "0";

    public static boolean isDivByZero(String equation) {
        String[] equationArray = equation.split(" ");

        for (int equationIndex = 2; equationIndex < equationArray.length; equationIndex+=2) {
            if (divZero(equationArray[equationIndex], equationArray[equationIndex-1])) {
                return true;
            }
        }
        return false;
    }

    private static boolean divZero(String number, String operator) {
        return number.equals(ZERO) && operator.equals(OperatorMap.DIV.getOperator());
    }

}
