package engine.calculator;

import engine.compute.Computer;
import engine.exception.NotValidInputException;
import engine.history.History;
import engine.io.Input;
import engine.io.Output;
import engine.option.Option;

public class Calculator implements Runnable {
    private Input input;
    private Output output;
    private History history;
    private Computer computer;

    public Calculator(Input input, Output output, History history, Computer computer) {
        this.input = input;
        this.output = output;
        this.history = history;
        this.computer = computer;
    }

    @Override
    public void run() {
        String sb = Option.makeOptionList();
        boolean exitFlag = true;


        while (exitFlag) {
            String userCommand = input.showOption(sb);

            try {
                int comm = Option.checkUserInput(userCommand.trim());

                if (comm == 0) {
                    exitFlag = false;
                } else if (comm == 1) {
                    output.showHistory(history);
                } else {
                    String userInputExpression = input.getCalculateSentence("계산할 식을 입력해주세요.");

                    String answer = computer.compute(userInputExpression); //연산 처리 의탁

                    history.save(userInputExpression, answer);
                    output.printAnswer(answer);
                }

            } catch (NotValidInputException e) {
                output.printError(e.getMessage());
            }
        }
    }
}
