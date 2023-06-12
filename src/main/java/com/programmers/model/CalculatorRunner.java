package com.programmers.model;

import com.programmers.error.ErrorMsg;
import com.programmers.repository.CalculationRepository;
import com.programmers.view.Input;
import com.programmers.view.Output;

import java.util.List;

public class CalculatorRunner {
    private final CalculationRepository repository;
    private final Input input;
    private final Output output;
    private static final String VIEW = "1", CALCULATION = "2";

    public CalculatorRunner(CalculationRepository repository, Input input, Output output) {
        this.repository = repository;
        this.input = input;
        this.output = output;
    }

    public void run() {
        while (true) {
            switch (inputMenu()) {
                case VIEW:
                    findAllCalculationHistory();
                    break;
                case CALCULATION:
                    calculatorProcessStart();
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
        String formula = getFormula();
        saveAndPrintResult(formula);
    }

    private void saveAndPrintResult(String formula) {
        try {
            long result = sendToCalculator(formula);
            repository.save(new CalculationResult(formula, result));
            output.printResult(result);
        } catch (NumberFormatException e) {
            output.printError(ErrorMsg.OPERAND_IS_NOT_A_NUMBER);
        } catch (IllegalArgumentException e) {
            output.printError(ErrorMsg.INVALID_OPERATOR_INPUT);
        } catch (ArithmeticException e) {
            output.printError(ErrorMsg.ENTER_ZERO_FOR_DIVISION);
        }
    }

    private long sendToCalculator(String formula) {
        Calculator calculator = new Calculator(formula);
        return calculator.calculate(formula);
    }

    private String getFormula() {
        return input.inputFormula();
    }

    private String inputMenu() {
        return input.inputMenu();
    }

    private void wrongMenuSelection() {
        output.printError(ErrorMsg.INVALID_MENU_SELECTION);
    }

    private void recordCommandExecution(List<CalculationResult> calculationRecord) {
        if (isEmptyRecord(calculationRecord)) {
            output.printError(ErrorMsg.NO_CALCULATION_RECORDS);
            return;
        }
        output.printRecord(calculationRecord);
    }

    private boolean isEmptyRecord(List<CalculationResult> record) {
        return record != null && record.size() == 0;
    }
}

