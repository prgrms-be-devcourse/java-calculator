package org.programmers.java.validation;

import org.programmers.java.console.Output;
import org.programmers.java.message.ErrorMsg;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    private final Output output;
    private final String numberMatch = "[0-9]+";
    private final String operatorMatch = "[*+/-]";


    public Validation(Output output) {
        this.output = output;
    }

    // 연산식 검증 로직
    public boolean calculateValidation(String inputMsg) {
        Boolean afterCheck = false;

        List<String> formulaList = formulaSplitValidation(inputMsg);

        if(formulaList.size() != 0) afterCheck = checkFormulaValidation(formulaList);

        if(!afterCheck) output.errorMsg(ErrorMsg.CALCULATE_VALIDATION_ERROR_MSG.getErrorMsg());

        return afterCheck;
    }


    // 연산식 검증: 연산식 분해 후 하나씩 검증
    public List<String> formulaSplitValidation(String inputMsg){
        String[] splitMsg = inputMsg.split(" ");
        List<String> formulaBeforeValidation = new ArrayList<>();

        for(String str : splitMsg){
            if(str.matches(numberMatch)) formulaBeforeValidation.add(str);
            else if(str.matches(operatorMatch)) formulaBeforeValidation.add(str);
            else {
                output.errorMsg(ErrorMsg.CALCULATE_VALIDATION_ERROR_MSG.getErrorMsg());
                formulaBeforeValidation.clear();
                break;
            }
        }
        return formulaBeforeValidation;
    }


    // 연산식 검증: 연산자와 피연산자의 전체 개수 검증 및 위치 검증
    public boolean checkFormulaValidation(List<String> formulaList){
        if(formulaList.size() % 2 == 0) return false;

        for(int i=0; i < formulaList.size(); i++){
            if(i % 2 == 0 && !formulaList.get(i).matches(numberMatch)) return false;
            if(i % 2 == 1 && !formulaList.get(i).matches(operatorMatch)) return false;
        }

        return true;
    }
}
