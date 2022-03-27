package calculator;

public class InputValidator {
    public boolean valid(String[] splittedInputFormula) {
        if(splittedInputFormula == null) return false;
        if(splittedInputFormula.length < 3 || splittedInputFormula.length % 2 == 0) return false;
        for (int i = 0; i < splittedInputFormula.length; i++) {
            if(i % 2 == 0 && !isNumber(splittedInputFormula[i])) return false;
            if(i % 2 == 1 && !isOperator(splittedInputFormula[i])) return false;
        }
        return true;
    }

    private boolean isOperator(String operator) {
        return OPERATOR.isOperator(operator);
    }

    private boolean isNumber(String stringNumber) {
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
