package engine.calculator;

import engine.Option;
import engine.compute.Computer;
import engine.exception.notValidInputException;
import engine.history.History;
import engine.io.Input;
import engine.io.Output;
import lombok.AllArgsConstructor;

public class Calculator implements Runnable{
    Input input;
    Output output;
    History history;
    Computer computer;

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
            String userCommand = input.showOption(sb);

            try {
                int comm = checkUserInput(userCommand.trim());

                if (comm == 0) {
                    exitFlag = false;
                } else if (comm == 1) {
                    output.showHistory(history);
                } else {
                    String userInputExpression = input.getCalculateSentence("계산할 식을 입력해주세요.");

                    double answer = computer.compute(userInputExpression); //연산 처리 의탁

                    history.save(userInputExpression, answer);
                    output.printAnswer(answer);
                }

            } catch (notValidInputException e) {
                output.printError(e.getMessage());

            }
        }


    }

    private int checkUserInput(String userCommand) {
        if(userCommand.length() != 1 || !Character.isDigit(userCommand.charAt(0)))
            throw new notValidInputException("잘못된 입력값입니다.");

        int comm = Integer.parseInt(userCommand);

        if(comm == 0 || comm == 1 || comm == 2)
            return comm;
        else
            throw new notValidInputException("잘못된 입력값입니다.");
    }

    //옵션으로 이동?
    private String makeOptionList() {
        StringBuilder sb = new StringBuilder();
        for (Option o : Option.values()) {
            sb.append(o.ordinal()).append(". ").append(o.getCommand()).append('\n');
        }
        return sb.toString();
    }
}
