package view;

import exception.NoSuchCommandException;
import model.Command;
import util.CalculatorUtil;

import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public Command commandReader() {
        String input = scanner.nextLine();
        try {
            int command = CalculatorUtil.parseNumber(input);
            return Command.getCommand(command);
        } catch (RuntimeException e) {
            throw new NoSuchCommandException("[ERROR] 잘못된 명령어를 입력하셨습니다.");
        }
    }

    public String expressionReader() throws RuntimeException {
        String expression = scanner.nextLine();
        CalculatorUtil.checkExpressionByRegex(expression);
        return expression;
    }

    public void printInfoMessage() {
        String infoMessage = formatMessages();
        System.out.print(infoMessage);
    }

    public void printAnswer(int result) {
        System.out.print(result + "\n\n");
    }

    private String formatMessages() {
        StringBuilder formattedMessage = new StringBuilder();

        for (ViewMessage msg : ViewMessage.values()) {
            if (!msg.equals(ViewMessage.SELECT)) {
                formattedMessage.append(msg.getMessage()).append('\n');
            }
        }
        formattedMessage.append('\n').append(ViewMessage.SELECT.getMessage());

        return formattedMessage.toString();
    }

    public void printNewLine() {
        System.out.println();
    }
}
