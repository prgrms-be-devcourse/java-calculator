package com.programmers.cal.logic;

import com.programmers.cal.view.InputView;
import com.programmers.cal.view.OutPutView;

import java.util.ArrayList;

public class CalculatorController {

    private CalculatorStore calculatorStore = new CalculatorStore(new ArrayList<>());

    public void start() {

        while (true) {
            OutPutView.showsTheMenu();

            switch (InputView.selectTheMenu()) {
                case LOOKUP:
                    OutPutView.showsTheCalculationHistory(calculatorStore.selectAll());
                    break;
                case CALCULATE:
                    String formula = InputView.inputTheFormula();
                    double result = CalculatorLogic.calculateTheSum(formula);
                    calculatorStore.save(new Formula(formula, result));
                    OutPutView.showsTheCalculationResult(result);
                    break;
                case EXIT:
                    return ;
            }
        }

    }

}
