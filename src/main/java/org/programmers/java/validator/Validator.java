package org.programmers.java.validator;

import org.programmers.java.console.Output;
import org.programmers.java.message.Error;

import java.util.ArrayList;
import java.util.List;

public class Validator {
    private final Output output;
    private final FormulaCountValidator formulaCountValidator;
    private final FormulaSplitValidator formulaSplitValidator;

    public Validator(Output output) {
        this.output = output;
        this.formulaCountValidator = new FormulaCountValidator();
        this.formulaSplitValidator = new FormulaSplitValidator(output);
    }

    // 연산식 검증 로직
    public boolean formulaValidate(String formulaInput) {
        boolean isNormalFormula = false;

        List<String> formularAfterSplitValidate = formulaSplitValidator.validate(formulaInput);

        if(formularAfterSplitValidate.size() != 0) {
            isNormalFormula = formulaCountValidator.validate(formularAfterSplitValidate);
        }

        if(!isNormalFormula) {
            output.errorMsg(Error.CALCULATE_VALIDATION.getMsg());
        }

        return isNormalFormula;
    }
}
