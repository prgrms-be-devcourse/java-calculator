package org.programmers.java;

import org.programmers.java.calculate.Calculate;
import org.programmers.java.console.Input;
import org.programmers.java.console.Output;
import org.programmers.java.message.ErrorMsg;
import org.programmers.java.repository.FormulaRepository;

public class Calculator {
    private boolean exitStatus = true;
    private final Input input;
    private final Output output;
    private final Calculate calculate;
    private final FormulaRepository formulaRepository;

    Calculator(Input input, Output output, Calculate calculate, FormulaRepository formulaRepository){
        this.input = input;
        this.output = output;
        this.calculate = calculate;
        this.formulaRepository = formulaRepository;
    }

    void run() {
        while (exitStatus) {
            output.menuMsg();
            String inputNum = input.numInput();
            output.selectMsg(inputNum);
            switch (inputNum) {
                case "1":
                    output.getCalculationValues(formulaRepository.getFormulaList());
                    break;
                case "2":
                    String formula = input.calculationInput();
                    if(formula.equals("")) break;
                    String result = calculate.requestCalculate(formula);
                    output.calculationValue(result);
                    formulaRepository.save(formula, result);
                    break;
                case "3":
                    output.exitMsg();
                    exitStatus = false;
                    break;
                default:
                    output.errorMsg(ErrorMsg.SELECT_VALIDATION_ERROR_MSG.getErrorMsg());
            }
        }
    }
}
