package calculator;

public class InputValidator {
    public static boolean valid(String[] splitedInputFormula) {
        if(splitedInputFormula == null) return false;
        if(splitedInputFormula.length < 3 || splitedInputFormula.length % 2 == 0) return false;
        for (int i = 0; i < splitedInputFormula.length; i++) {
            if(i % 2 == 0 && !isNumber(splitedInputFormula[i])) return false;
            if(i % 2 == 1 && !isOperator(splitedInputFormula[i])) return false;
        }
        return true;
    }

    public static boolean isOperator(String operator) {
        for (OPERATOR op:OPERATOR.values()) {
            if(op.getValue() == operator) return true;
        }
        return false;
    }

    public static boolean isNumber(String stringNumber) {
        try{
            Double.parseDouble(stringNumber);
        } catch (NumberFormatException nfe) {
            return false;
        } catch (NullPointerException npe) {
            return false;
        }
        return true;
    }
}
