package org.programmers.java.validator;

import org.programmers.java.calculation.Operator;

import java.util.List;

public class FormulaCountValidator {
    // 연산식 검증: 연산자와 피연산자의 전체 개수 검증 및 위치 검증
    public boolean validate(List<String> formularAfterSplitValidate){
        boolean isNormalFormula = false;

        if(formularAfterSplitValidate.size() % 2 == 0) {
            return isNormalFormula;
        }

        for(int i=0; i < formularAfterSplitValidate.size(); i++){
            String operatorOrOperand = formularAfterSplitValidate.get(i);

            if (checkOperatorAndOperandLocation(i, operatorOrOperand)) {
                return isNormalFormula;
            }
        }

        return true;
    }

    private boolean checkOperatorAndOperandLocation(int index, String operatorOrOperand) {
        if(index % 2 == 0 && !Operator.isNumber(operatorOrOperand)) {
            return true;
        }

        if(index % 2 == 1 && !Operator.isSymbol(operatorOrOperand).isPresent()) {
            return true;
        }

        return false;
    }
}
