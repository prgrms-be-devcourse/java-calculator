package view;

import model.Command;

import java.util.Scanner;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public Command commandReader() {
        int input = scanner.nextInt();
        Command.
    }

    public String expressionReader() {

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
