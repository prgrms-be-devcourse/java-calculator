package engine.calculator;

import engine.Option;
import engine.exception.notValidInputException;
import engine.history.History;
import engine.io.Input;
import engine.io.Output;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable{
    Input input;
    Output output;
    History history;

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
                    String s = input.getCalculateSentence("계산할 식을 입력해주세요.");
                    history.save(s, 12345);
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

    private String makeOptionList() {
        StringBuilder sb = new StringBuilder();
        for (Option o : Option.values()) {
            sb.append(o.ordinal()).append(". ").append(o.getCommand()).append('\n');
        }
        return sb.toString();
    }
}
