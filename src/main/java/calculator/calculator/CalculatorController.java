package calculator.calculator;

import calculator.domain.enums.Command;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
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

        }
        else if (command.isCalculation()) {
            String input = inputView.input();
        }
    }

    private boolean isContinue(Command command) {
        if (command.isExit()) {
            return false;
        }
        return true;
    }
}
