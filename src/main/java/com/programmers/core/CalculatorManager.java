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
        boolean power = true;

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
        String formula = getFormula();
        saveAndPrintResult(formula);
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

    private long sendToCalculator(String formula) {
        calculator.calculate(formula);
        return calculator.calculate(formula);
    }

    private String getFormula() {
        return console.inputFormula();
    }

    private String inputMenu() {
        return console.inputMenu();
    }

    private void wrongMenuSelection() {
        console.print(ErrorMessages.getInvalidMenuSelectionMsg());
    }

    private void recordCommandExecution(List<CalculationResult> calculationRecord) {
        if (isEmptyRecord(calculationRecord)) {
            console.print(ErrorMessages.getNoCalculationRecordsMsg());
            return;
        }
        console.printList(calculationRecord);
    }

    private boolean isEmptyRecord(List<CalculationResult> record) {
        return record != null && record.size() == 0;
    }

    private void exitProgram() {
        console.print("프로그램을 종료합니다.");
        System.exit(0);
    }
}
