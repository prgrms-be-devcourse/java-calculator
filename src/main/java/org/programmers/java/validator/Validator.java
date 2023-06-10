package org.programmers.java.validator;

import org.programmers.java.console.Output;
import org.programmers.java.message.Error;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private final Output output;
    private final String numberMatch = "[0-9]+";
    private final String operatorMatch = "[*+/-]";


    public Validator(Output output) {
        this.output = output;
    }

    // 연산식 검증 로직
    public boolean formulaValidate(String formulaInput) {
        boolean isNormalFormula = false;

        List<String> formularAfterSplitValidate = formulaSplitValidate(formulaInput);

        if(formularAfterSplitValidate.size() != 0) {
            isNormalFormula = formulaCountValidate(formularAfterSplitValidate);
        }

        if(!isNormalFormula) {
            output.errorMsg(Error.CALCULATE_VALIDATION.getMsg());
        }

        return isNormalFormula;
    }


    // 연산식 검증: 연산식 분해 후 하나씩 검증
    public List<String> formulaSplitValidate(String formulaInput){
        String[] splitFormula = formulaInput.split(" ");
        List<String> formularAfterSplitValidate = new ArrayList<>();

        for(String operatorOrOperand : splitFormula){
            if(operatorOrOperand.matches(numberMatch)) {
                formularAfterSplitValidate.add(operatorOrOperand);
            }

            if(operatorOrOperand.matches(operatorMatch)) {
                formularAfterSplitValidate.add(operatorOrOperand);
            }

            if(!operatorOrOperand.matches(numberMatch) && !operatorOrOperand.matches(operatorMatch)){
                output.errorMsg(Error.CALCULATE_VALIDATION.getMsg());
                formularAfterSplitValidate.clear();
                break;
            }
        }
        return formularAfterSplitValidate;
    }


    // 연산식 검증: 연산자와 피연산자의 전체 개수 검증 및 위치 검증
    public boolean formulaCountValidate(List<String> formularAfterSplitValidate){
        boolean isNormalFormula = false;

        if(formularAfterSplitValidate.size() % 2 == 0) {
            return isNormalFormula;
        }

        for(int i=0; i < formularAfterSplitValidate.size(); i++){
            if(i % 2 == 0 && !formularAfterSplitValidate.get(i).matches(numberMatch)) {
                return isNormalFormula;
            }

            if(i % 2 == 1 && !formularAfterSplitValidate.get(i).matches(operatorMatch)) {
                return isNormalFormula;
            }
        }

        return true;
    }
}
