package com.programmers.java;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;
import com.programmers.java.engine.model.PostFixFormula;
import com.programmers.java.engine.model.ValidFormula;
import com.programmers.java.engine.repository.FormulaRepository;
import com.programmers.java.engine.service.CalcService;
import com.programmers.java.engine.service.utils.Function;
import com.programmers.java.engine.service.PostFixService;
import com.programmers.java.engine.service.ValidationService;

import java.util.Optional;

public class Calculator implements Runnable {
    ValidationService validService = new ValidationService();
    PostFixService postFixService = new PostFixService();
    FormulaRepository formulaRepo = new FormulaRepository();
    CalcService calcService = new CalcService();

    private final int INQUERY = 1;
    private final int CALCULATE = 2;

    private Input input;
    private Output output;

    public Calculator(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {

        while (true) {
            String inputString = input.returnInput("1. 조회" + "\n2. 계산");
            if (inputString.isEmpty())
                break;

            int selectNum = parse(inputString);
            if (selectNum == INQUERY) {
                input.inquireInput(selectNum);
                if (formulaRepo.size() < 1)
                    output.errorEmptyRepo();
                else
                    formulaRepo.inquire();
            } else if (selectNum == CALCULATE) {
                String inputFormula = input.returnInput(selectNum + " 번을 선택하셨습니다. 식을 입력해주세요 !");
                Optional<ValidFormula> validFormula = validService.Validation(inputFormula);
                if (validFormula.isEmpty()) {
                    output.inputError();
                } else {
                    PostFixFormula postFixFormula = new PostFixFormula(postFixService.makePostFixFormula(validFormula.get()));
                    Long result = calcService.calculate(postFixFormula.getFormula());
                    output.printCalcResult(result);
                    formulaRepo.save(inputFormula, result);
                }
            } else {
                output.inputError();
            }
        }
    }

    private int parse(String inputString) {
        if (inputString.length() > 1 || !Function.isStrDigit(inputString)) {
            return -1;
        } else if (Integer.parseInt(inputString) == 1) {
            return 1;
        } else if (Integer.parseInt(inputString) == 2) {
            return 2;
        } else {
            return -1;
        }
    }
}
