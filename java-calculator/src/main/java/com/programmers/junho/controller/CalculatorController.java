package com.programmers.junho.controller;

import com.programmers.junho.controller.constant.Selection;
import com.programmers.junho.repository.CalculatorRepository;
import com.programmers.junho.repository.ListCalculatorRepository;
import com.programmers.junho.view.InputView;
import com.programmers.junho.view.OutputView;

import java.util.List;

import static com.programmers.junho.controller.constant.Selection.findByCode;

public class CalculatorController {

    private final CalculatorRepository calculatorRepository;
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorRepository = new ListCalculatorRepository();
    }

    public void run() {
        outputView.printChoiceMessage();
        Selection code = findByCode(inputView.getSelectedCode());
        switch (code){
            case CHECK_DATA:
                List<String> calculatedData = calculatorRepository.findAll();
                outputView.printExpressions(calculatedData);
                break;
            case CALCULATE:
                // 계산 기능 구현
            default:
                throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }
}
