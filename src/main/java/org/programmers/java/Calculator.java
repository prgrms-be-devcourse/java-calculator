package org.programmers.java;

import org.programmers.java.calculation.Calculation;
import org.programmers.java.console.Console;
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

    Calculator(Calculation calculation, FormulaRepository formulaRepository){
        this.input = Console.getInstance();
        this.output = Console.getInstance();
        this.calculation = calculation;
        this.formulaRepository = formulaRepository;
        this.validator = new Validator();
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
        String inputFormula = input.formulaInput();

        if(validator.formulaValidate(inputFormula)){
            String result = calculation.requestCalculate(inputFormula);
            output.calculationValue(result);
            String getFormula = formulaRepository.save(inputFormula, result);
            compareFormula(getFormula, inputFormula, result);
        }
    }

    private void compareFormula(String getFormula, String inputFormula, String result){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append(inputFormula)
                .append(" = ")
                .append(result);
        String formula = stringBuilder.toString();
        if(!getFormula.equals(formula)){
            output.errorMsg(Error.DOES_NOT_MATCH_DATA.getMsg());
        }
    }
}
