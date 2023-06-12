package org.programmers.java;

import org.programmers.java.calculation.Calculation;
import org.programmers.java.console.Input;
import org.programmers.java.console.Output;
import org.programmers.java.message.Error;
import org.programmers.java.message.FunctionSelect;
import org.programmers.java.repository.FormulaRepository;
import org.programmers.java.validator.Validator;

import java.util.Optional;

public class Calculator {
    private boolean programStatus = true;
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
        while (programStatus) {
            output.menuMsg();
            String selectNum = input.selectNumInput();
            output.selectMsg(selectNum);
            FunctionSelect selectMenu = getFunctionSelectNumber(selectNum);
            switch (selectMenu) {
                case CHECK:
                    output.getCalculationValues(formulaRepository.getFormulaList());
                    break;
                case CALCULATION:
                    formulaCalculate();
                    break;
                case EXIT:
                    output.exitMsg();
                    programStatus = false;
                    break;
                case WRONGINPUT:
                    output.errorMsg(Error.SELECT_VALIDATION.getMsg());
                    break;
            }
        }
    }

    private FunctionSelect getFunctionSelectNumber(String selectNum) {
        return FunctionSelect.findSelect(selectNum).orElse(FunctionSelect.WRONGINPUT);
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
