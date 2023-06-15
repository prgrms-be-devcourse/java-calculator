package org.programmers.java.validator;

import org.programmers.java.calculation.Operator;
import org.programmers.java.message.Error;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private static final List<String> formularAfterSplitValidate = new ArrayList<>();

    public static void formulaValidate(String formulaInput) {
        formularAfterSplitValidate.clear();
        formulaSplitValidate(formulaInput);
        formulaCountValidate(formularAfterSplitValidate);
    }

    private static void formulaSplitValidate(String formulaInput) {
        String[] splitFormula = formulaInput.split(" ");

        for (String operatorOrOperand : splitFormula) {
            if (!isValid(operatorOrOperand)) {
                throw new IllegalArgumentException(Error.CALCULATE_VALIDATION.getMsg());
            }
            formularAfterSplitValidate.add(operatorOrOperand);
        }
    }

    private static boolean isValid(String operatorOrOperand) {
        return Operator.isNumber(operatorOrOperand) ||
                Operator.isSymbol(operatorOrOperand).isPresent();
    }

    private static void formulaCountValidate(List<String> formularAfterSplitValidate){
        if(formularAfterSplitValidate.size() % 2 == 0) {
            throw new IllegalArgumentException(Error.CALCULATE_VALIDATION.getMsg());
        }

        for(int i=0; i < formularAfterSplitValidate.size(); i++){
            String operatorOrOperand = formularAfterSplitValidate.get(i);
            checkOperatorAndOperandLocation(i, operatorOrOperand);
        }
    }

    private static void checkOperatorAndOperandLocation(int index, String operatorOrOperand) {
        if(index % 2 != 0 && Operator.isNumber(operatorOrOperand)) {
            throw new IllegalArgumentException(Error.CALCULATE_VALIDATION.getMsg());
        }

        if(index % 2 != 1 && Operator.isSymbol(operatorOrOperand).isPresent()) {
            throw new IllegalArgumentException(Error.CALCULATE_VALIDATION.getMsg());
        }
    }
}
