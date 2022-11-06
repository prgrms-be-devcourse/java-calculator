package engine.calculator;

import engine.compute.Computer;
import engine.exception.NotValidInputException;
import engine.history.Histories;
import engine.io.Input;
import engine.io.Output;

import static engine.option.Option.*;

public class Calculator implements Runnable {
    private final Input input;
    private final Output output;
    private final Histories histories;
    private final Computer computer;

    public Calculator(Input input, Output output, Histories histories, Computer computer) {
        this.input = input;
        this.output = output;
        this.histories = histories;
        this.computer = computer;
    }

    @Override
    public void run() {
        String optionList = makeOptionList();
        String userCommand = "";

        while (!userCommand.equals(EXIT.getOption())) {
            input.showOption(optionList);
            userCommand = input.getUserInputOption();

            try {
                checkUserInput(userCommand);
                executeUserCommand(userCommand);

            } catch (NotValidInputException e) {
                output.printError(e.getMessage());
            }
        }
    }

    private void executeUserCommand(String userCommand) {
        if (userCommand.equals(EXIT.getOption())) {
            return;
        } else if (userCommand.equals(HISTORY.getOption())) {
            output.showHistory(histories);
        } else {
            String userInputExpression = input.getCalculateSentence("계산할 식을 입력해주세요.");

            String answer = computer.compute(userInputExpression);

            histories.save(userInputExpression, answer);
            output.printAnswer(answer);
        }
    }
}
