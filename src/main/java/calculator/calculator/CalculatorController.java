package calculator.controller;

import calculator.domain.Expression;
import calculator.domain.enums.Command;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.Map;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CalculatorService calculatorService;

    public CalculatorController(InputView inputView, OutputView outputView, CalculatorService calculatorService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.calculatorService = calculatorService;
    }

    public void run() {
        Command command;
        do {
            outputView.printCommand();
            String input = inputView.input();
            System.out.println();
            command = Command.from(input);
            processCommand(command);
        }
        while (isContinue(command));
    }

    private void processCommand(Command command) {
        if (command.isHistory()) {
            Map<Expression, Integer> history = calculatorService.getHistory();
            outputView.printHistory(history);
        }
        else if (command.isCalculation()) {
            String input = inputView.input();
            int result = calculatorService.process(new Expression(input));
            outputView.printResult(result);
        }
    }

    private boolean isContinue(Command command) {
        if (command.isExit()) {
            return false;
        }
        return true;
    }
}
