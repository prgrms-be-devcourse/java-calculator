package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.Menu;
import com.devcourse.java.calculator.io.Console;
import com.devcourse.java.calculator.repository.CalculatorRepository;
import com.devcourse.java.calculator.repository.History;
import com.devcourse.java.calculator.util.CalculateUtil;
import com.devcourse.java.calculator.validator.EquationValidator;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class Calculator implements Runnable{

    private final Console console;
    private final CalculatorRepository calculatorRepository;
    private Menu command;

    @Override
    public void run() {

        while (true) {
            console.printCommandMenu();

            try {
                command = Menu.getCommandMenu(console.getCommand());
            } catch (RuntimeException e) {
                console.printExceptionMessage(e.getMessage());
                continue;
            }

            switch (command) {
                case SELECTED_EXIT:
                    return;
                case SELECTED_PRINT_HISTORY:
                    printHistoryCommand();
                    break;
                case SELECTED_CALCULATE:
                    calculateCommand();
                    break;
            }
        }
    }

    public void printHistoryCommand() {
        try {
            console.printCalculateHistory(calculatorRepository.getHistory());

        } catch (RuntimeException e) {
            console.printExceptionMessage(e.getMessage());
        }
    }

    public void calculateCommand() {
        Optional<String> equation = Optional.empty();
        try {
            console.printRequestEquationInput();
            equation = console.getEquation();
            EquationValidator.checkEquationInput(equation);
            String answer = CalculateUtil.calculateAndReturnAnswer(equation.get());
            console.printAnswerFromEquation(answer);
            History history = new History(equation, Optional.of(answer));
            calculatorRepository.storeHistory(history);

        } catch (RuntimeException e) {
            if (equation.isPresent()) {
                History history = new History(equation, Optional.empty());
                calculatorRepository.storeHistory(history);
            }

            console.printExceptionMessage(e.getMessage());
        }
    }
}
