package com.programmers.core;

import com.programmers.error.ErrorMessages;
import com.programmers.model.AbstractCalculator;
import com.programmers.model.CalculationResult;
import com.programmers.repository.CalculationRepository;
import com.programmers.view.Console;

import java.util.List;

public class CalculatorManager {
    private final CalculationRepository repository;
    private final Console console;
    private final AbstractCalculator calculator;

    private static final String VIEW = "1", CALCULATION = "2", EXIT = "3";


    public CalculatorManager(CalculationRepository repository, Console console, AbstractCalculator calculator) {
        this.repository = repository;
        this.console = console;
        this.calculator = calculator;
    }

    public void run() {
        Boolean power = true;

        while (power) {
            switch (inputMenu()) {
                case VIEW:
                    findAllCalculationHistory();
                    break;
                case CALCULATION:
                    calculatorProcessStart();
                    break;
                case EXIT:
                    exitProgram();
                    power = false;
                    break;
                default:
                    wrongMenuSelection();
            }
        }
    }

    private void findAllCalculationHistory() {
        List<CalculationResult> calculationRecord = repository.findAll();
        recordCommandExecution(calculationRecord);
    }

    private void calculatorProcessStart() {
        saveAndPrintResult(console.inputFormula());
    }

    private void saveAndPrintResult(String formula) {
        try {
            long result = sendToCalculator(formula);
            repository.save(new CalculationResult(formula, result));
            console.print(result);
        } catch (NumberFormatException e) {
            console.print(ErrorMessages.getOperandIsNotANumberMsg());
        } catch (IllegalArgumentException e) {
            console.print(ErrorMessages.getInvalidOperatorInputMsg());
        } catch (ArithmeticException e) {
            console.print(ErrorMessages.getEnterZeroForDivisionMsg());
        }
    }

    private void wrongMenuSelection() {
        console.print(ErrorMessages.getInvalidMenuSelectionMsg());
    }

    private void recordCommandExecution(List<CalculationResult> calculationRecord) {
        if (calculationRecord.isEmpty()) {
            console.print(ErrorMessages.getNoCalculationRecordsMsg());
            return;
        }
        console.printList(calculationRecord);
    }


}
