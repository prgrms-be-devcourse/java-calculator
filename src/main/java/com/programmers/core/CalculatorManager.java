package com.programmers.core;

import com.programmers.Calculator;
import com.programmers.error.ErrorMsg;
import com.programmers.model.CalculationResult;
import com.programmers.repository.CalculationRepository;
import com.programmers.view.Console;

import java.util.List;

public class CalculatorManager {
    private final CalculationRepository repository;
    private final Console console;
    private static final String VIEW = "1", CALCULATION = "2", EXIT = "3";


    public CalculatorManager(CalculationRepository repository, Console console) {
        this.repository = repository;
        this.console = console;

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
            console.print(ErrorMsg.OPERAND_IS_NOT_A_NUMBER);
        } catch (IllegalArgumentException e) {
            console.print(ErrorMsg.INVALID_OPERATOR_INPUT);
        } catch (ArithmeticException e) {
            console.print(ErrorMsg.ENTER_ZERO_FOR_DIVISION);
        }
    }

    private long sendToCalculator(String formula) {
        Calculator calculator = new Calculator(formula);
        return calculator.calculate(formula);
    }

    private String getFormula() {
        return console.inputFormula();
    }

    private String inputMenu() {
        return console.inputMenu();
    }

    private void wrongMenuSelection() {
        console.print(ErrorMsg.INVALID_MENU_SELECTION);
    }

    private void recordCommandExecution(List<CalculationResult> calculationRecord) {
        if (isEmptyRecord(calculationRecord)) {
            console.print(ErrorMsg.NO_CALCULATION_RECORDS);
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
