package org.programmers.java.validator;

import org.programmers.java.calculation.Operator;
import org.programmers.java.console.Output;
import org.programmers.java.message.Error;

import java.util.ArrayList;
import java.util.List;

public class FormulaSplitValidator {

    private final Output output;
    private List<String> formularAfterSplitValidate = new ArrayList<>();

    public FormulaSplitValidator(Output output) {
        this.output = output;
    }

    // 연산식 검증: 연산식 분해 후 하나씩 검증
    public List<String> validate(String formulaInput){
        String[] splitFormula = formulaInput.split(" ");

        for(String operatorOrOperand : splitFormula){
            splitValidateAddInList(operatorOrOperand);
        }

        return formularAfterSplitValidate;
    }

    private void splitValidateAddInList(String operatorOrOperand){
        if(Operator.isNumber(operatorOrOperand)) {
            formularAfterSplitValidate.add(operatorOrOperand);
        }

        if(Operator.isSymbol(operatorOrOperand).isPresent()) {
            formularAfterSplitValidate.add(operatorOrOperand);
        }

        if(!Operator.isNumber(operatorOrOperand) && !Operator.isSymbol(operatorOrOperand).isPresent()){
            output.errorMsg(Error.CALCULATE_VALIDATION.getMsg());
            formularAfterSplitValidate.clear();
        }
    }
}
