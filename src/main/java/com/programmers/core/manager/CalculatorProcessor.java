package com.programmers.core.manager;

import com.programmers.core.calculator.AbstractCalculator;
import com.programmers.core.data.CalculationRequest;
import com.programmers.core.data.CalculationResult;
import com.programmers.error.ErrorMessages;
import com.programmers.repository.CalculationRepository;
import com.programmers.view.Console;

public class CalculatorProcessor {
    private final AbstractCalculator calculator;
    private final CalculationRepository repository;
    private final Console console;

    public CalculatorProcessor(AbstractCalculator calculator, CalculationRepository repository, Console console) {
        this.calculator = calculator;
        this.repository = repository;
        this.console = console;
    }

    public CalculationResult performCalculation(CalculationRequest request) {
        try {
            CalculationResult result = calculator.calculate(request);
            repository.save(result);
            return result;
        } catch (NumberFormatException e) {
            console.print(ErrorMessages.getOperandIsNotANumberMsg());
        } catch (IllegalArgumentException e) {
            console.print(ErrorMessages.getInvalidOperatorInputMsg());
        } catch (ArithmeticException e) {
            console.print(ErrorMessages.getEnterZeroForDivisionMsg());
        }
        return null;
    }
}

