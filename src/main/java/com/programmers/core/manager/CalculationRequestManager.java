package com.programmers.core.manager;

import com.programmers.core.data.CalculationRequest;
import com.programmers.view.Console;

public class CalculationRequestManager {
    private final Console console;

    public CalculationRequestManager(Console console) {
        this.console = console;
    }

    public CalculationRequest createCalculationRequest() {
        String formula = console.inputFormula();
        return new CalculationRequest(formula);
    }
}

