package javacalculator.calculator;

public class InputValidator {
    public boolean valid(String[] splittedInputFormula) {
        if (
                splittedInputFormula != null &&
                isValidLength(splittedInputFormula) &&
                isValidElements(splittedInputFormula)
        ) return true;
        return false;
    }

    private boolean isValidElements(String[] splittedInputFormula) {
        for (int i = 0; i < splittedInputFormula.length; i++) {
            String element = splittedInputFormula[i];
            if (i % 2 == 0 && !isNumber(element)) return false;
            if (i % 2 == 1 && !isOperator(element)) return false;
        }
        return true;
    }

    private boolean isValidLength(String[] splittedInputFormula) {
        return splittedInputFormula.length >= 3 && splittedInputFormula.length % 2 != 0;
    }

    private boolean isOperator(String operator) {
        return Operator.isTextOperator(operator);
    }

    private boolean isNumber(String stringNumber) {
        try {
            Double.parseDouble(stringNumber);
        } catch (NumberFormatException nfe) {
            return false;
        } catch (NullPointerException npe) {
            return false;
        }
        return true;
    }
}
