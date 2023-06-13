package org.programmers.java.validator;

import org.programmers.java.calculation.Operator;
import org.programmers.java.console.Console;
import org.programmers.java.console.Output;
import org.programmers.java.message.Error;

import java.util.ArrayList;
import java.util.List;

public class FormulaSplitValidator {

    private final Output output;
    private List<String> formularAfterSplitValidate = new ArrayList<>();

    public FormulaSplitValidator() {
        this.output = Console.getInstance();
    }

    // 연산식 검증: 연산식 분해 후 하나씩 검증
    public List<String> validate(String formulaInput){
        formularAfterSplitValidate.clear();
        String[] splitFormula = formulaInput.split(" ");

        for(String operatorOrOperand : splitFormula){
            if(!splitValidateAddInList(operatorOrOperand)){
                break;
            }
        }

        return formularAfterSplitValidate;
    }

    private boolean splitValidateAddInList(String operatorOrOperand){
        if(Operator.isNumber(operatorOrOperand)) {
            formularAfterSplitValidate.add(operatorOrOperand);
            return true;
        }

        if(Operator.isSymbol(operatorOrOperand).isPresent()) {
            formularAfterSplitValidate.add(operatorOrOperand);
            return true;
        }

        if(!Operator.isNumber(operatorOrOperand) && !Operator.isSymbol(operatorOrOperand).isPresent()){
            output.errorMsg(Error.CALCULATE_VALIDATION.getMsg());
            formularAfterSplitValidate.clear();
            return false;
        }

        return true;
    }
}
