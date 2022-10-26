package engine.calculator;

import engine.compute.Computer;
import engine.exception.NotValidInputException;
import engine.history.History;
import engine.io.Input;
import engine.io.Output;

import static engine.option.Option.*;

public class Calculator implements Runnable {
    private final Input input;
    private final Output output;
    private final History history;
    private final Computer computer;

    public Calculator(Input input, Output output, History history, Computer computer) {
        this.input = input;
        this.output = output;
        this.history = history;
        this.computer = computer;
    }

    @Override
    public void run() {
        String sb = makeOptionList();
        boolean exitFlag = true;

        while (exitFlag) {
            input.showOption(sb);
            String userCommand = input.getUserInputOption();

            try {
                checkUserInput(userCommand);

                if (userCommand.equals(EXIT.getOption())) {
                    exitFlag = false;
                } else if (userCommand.equals(HISTORY.getOption())) {
                    output.showHistory(history);
                } else {
                    String userInputExpression = input.getCalculateSentence("계산할 식을 입력해주세요.");

                    String answer = computer.compute(userInputExpression);

                    history.save(userInputExpression, answer);
                    output.printAnswer(answer);
                }

            } catch (NotValidInputException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
