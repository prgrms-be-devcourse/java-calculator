package com.programmers.java;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;
import com.programmers.java.engine.model.Formula;
import com.programmers.java.engine.repository.FormulaRepository;
import com.programmers.java.engine.service.*;
import com.programmers.java.engine.service.utils.Function;

import java.util.Optional;

public class Calculator implements Runnable {

    private static final int ERROR = -1;
    private static final int INQUIRE = 1;
    private static final int CALCULATE = 2;
    private final Input input;
    private final Output output;

    ValidationService validService = new ValidationService();
    PostFixService postFixService = new PostFixService();
    FormulaRepository formulaRepository = new FormulaRepository();
    CalcService calcService = new CalcService();

    public Calculator(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        while (true) {
            String inputString = input.ReturnInput("1. 조회" + "\n2. 계산");
            if (inputString.isEmpty()) {
                break;
            }
            int selectNum = Parse(inputString);
            if (selectNum == INQUIRE) {
                Find();
            } else if (selectNum == CALCULATE) {
                Calculate();
            } else {
                output.Error("Input");
            }
        }
    }

    private void Find() {
        if (formulaRepository.size() < 1) {
            output.Error("EmptyMap");
        } else {
            formulaRepository.findAll();
        }
        System.out.println();
    }

    private void Calculate() {
        String inputFormula = input.FormulaInput("식을 입력해주세요");
        Optional<Formula> validFormula = validService.Validation(inputFormula);
        long result = 0;
        if (validFormula.isEmpty()) {
            output.Error("Input");
        } else {
            Formula postFixFormula = new Formula(postFixService.makePostFixFormula(validFormula.get()));
            if (formulaRepository.isCacheExit(inputFormula)) {
                result = formulaRepository.cache(inputFormula);
            }
            else {
                result = calcService.calculate(postFixFormula.getFormula());
            }
            formulaRepository.save(inputFormula, result);
            output.PrintCalcResult(result);
        }
    }

    private int Parse(String inputString) {
        if (inputString.length() > 1 || !Function.isStrDigit(inputString)) {
            return ERROR;
        } else if (Integer.parseInt(inputString) == 1) {
            return INQUIRE;
        } else if (Integer.parseInt(inputString) == 2) {
            return CALCULATE;
        }
        return ERROR;
    }
}
