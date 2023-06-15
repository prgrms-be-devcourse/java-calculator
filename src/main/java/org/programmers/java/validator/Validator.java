package org.programmers.java.validator;

import org.programmers.java.console.Console;
import org.programmers.java.console.Output;
import org.programmers.java.message.Error;

import java.util.List;

public class Validator {
    private final Output output;
    private final FormulaCountValidator formulaCountValidator;
    private final FormulaSplitValidator formulaSplitValidator;

    public Validator() {
        this.output = Console.getInstance();
        this.formulaCountValidator = new FormulaCountValidator();
        this.formulaSplitValidator = new FormulaSplitValidator();
    }

    // 연산식 검증 로직
    public boolean formulaValidate(String formulaInput) {
        boolean isNormalFormula = false;

        List<String> formularAfterSplitValidate = formulaSplitValidator.validate(formulaInput);

        if(formularAfterSplitValidate.isEmpty()) {
            isNormalFormula = formulaCountValidator.validate(formularAfterSplitValidate);
        }

        if(!isNormalFormula) {
            output.errorMsg(Error.CALCULATE_VALIDATION.getMsg());
        }

        return isNormalFormula;
    }
}
