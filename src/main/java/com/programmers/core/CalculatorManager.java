package com.programmers.core;

import com.programmers.core.data.CalculationRequest;
import com.programmers.core.data.CalculationResult;
import com.programmers.core.manager.CalculationRequestManager;
import com.programmers.core.manager.CalculatorProcessor;
import com.programmers.core.manager.MenuManager;
import com.programmers.core.manager.ResultPrinter;
import com.programmers.repository.CalculationRepository;

import java.util.List;

public class CalculatorManager {

    private final MenuManager menuManager;
    private final CalculationRequestManager requestManager;
    private final CalculatorProcessor calculatorProcessor;
    private final ResultPrinter resultPrinter;
    private final CalculationRepository repository;

    private static final String VIEW = "1", CALCULATION = "2", EXIT = "3";

    public CalculatorManager(MenuManager menuManager, CalculationRequestManager requestManager, CalculatorProcessor calculatorProcessor, ResultPrinter resultPrinter, CalculationRepository repository) {
        this.menuManager = menuManager;
        this.requestManager = requestManager;
        this.calculatorProcessor = calculatorProcessor;
        this.resultPrinter = resultPrinter;
        this.repository = repository;
    }

    public void run() {
        Boolean power = true;

        while (power) {
            switch (menuManager.inputMenu()) {
                case VIEW:
                    findRecord();
                    break;
                case CALCULATION:
                    calculatorProcess();
                    break;
                case EXIT:
                    menuManager.printExitMessage();
                    break;
                default:
                    menuManager.printInvalidMenuSelection();
            }
        }
    }

    private void findRecord() {
        List<CalculationResult> calculationRecord = repository.findAll();
        menuManager.printCalculationRecords(calculationRecord);
    }

    private void calculatorProcess() {
        CalculationRequest request = requestManager.createCalculationRequest();
        CalculationResult result = calculatorProcessor.performCalculation(request);
        if (result != null) {
            resultPrinter.printResult(result.getResult());
        }
    }
}
