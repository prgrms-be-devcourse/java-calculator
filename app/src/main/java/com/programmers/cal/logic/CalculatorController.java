package com.programmers.cal.logic;

import com.programmers.cal.view.InputView;
import com.programmers.cal.view.OutPutView;

import java.util.ArrayList;

public class CalculatorController {

    private static final int LOOK_UP_BTN = 1;
    private static final int CALCULATOR_BTN = 2;
    private static final int EXIT_NUMBER_BTN = 3;

    private CalculatorStore calculatorStore = new CalculatorStore(new ArrayList<>());

    public void start() {

        while (true) {
            switch (InputView.preparation()) {
                case LOOK_UP_BTN:
                    OutPutView.calculatorHistory(calculatorStore.selectAll());
                    break;
                case CALCULATOR_BTN:
                    String formula = InputView.inputTheFormula();
                    double result = CalculatorLogic
                            .Calculation(formula);
                    calculatorStore.save(new Formula(formula, result));
                    OutPutView.calculatorResult(result);
                    break;
                case EXIT_NUMBER_BTN:
                    return ;
            }
        }

    }

}
