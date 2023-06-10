package org.programmers.java;

import org.programmers.java.calculation.Calculation;
import org.programmers.java.console.Input;
import org.programmers.java.console.Output;
import org.programmers.java.message.Error;
import org.programmers.java.repository.FormulaRepository;
import org.programmers.java.validator.Validator;

public class Calculator {
    private boolean exitStatus = true;
    private final Input input;
    private final Output output;
    private final Calculation calculation;
    private final FormulaRepository formulaRepository;
    private final Validator validator;

    Calculator(Input input, Output output, Calculation calculation, FormulaRepository formulaRepository, Validator validator){
        this.input = input;
        this.output = output;
        this.calculation = calculation;
        this.formulaRepository = formulaRepository;
        this.validator = validator;
    }

    void run() {
        while (exitStatus) {
            output.menuMsg();
            String selectNum = input.selectNumInput();
            output.selectMsg(selectNum);
            switch (selectNum) {
                case "1":
                    output.getCalculationValues(formulaRepository.getFormulaList());
                    break;
                case "2":
                    formulaCalculate();
                    break;
                case "3":
                    output.exitMsg();
                    exitStatus = false;
                    break;
                default:
                    output.errorMsg(Error.SELECT_VALIDATION.getMsg());
            }
        }
    }

    private void formulaCalculate() {
        String formula = input.formulaInput();

        if(validator.formulaValidate(formula)){
            String result = calculation.requestCalculate(formula);
            output.calculationValue(result);
            formulaRepository.save(formula, result);
        }
    }
}
