package engine.calculator;

import engine.Option;
import engine.exception.notValidInputException;
import engine.io.Input;
import engine.io.Output;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Calculator implements Runnable{
    Input input;
    Output output;


    @Override
    public void run() {
        String sb = makeOptionList();

        while (true) {
            String userCommand = input.showOption(sb);

            try {
                int comm = checkUserInput(userCommand.trim());


            } catch (notValidInputException e) {
                output.printError(e.getMessage());

            }
        }


    }

    private int checkUserInput(String userCommand) {
        if(userCommand.length() != 1 || !Character.isDigit(userCommand.charAt(0)))
            throw new notValidInputException("잘못된 입력값입니다.");

        //0 ~ 2의 숫자가 아닌 경우 걸러야 함.
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
