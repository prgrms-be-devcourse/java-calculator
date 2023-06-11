package view;

import exception.IllegalExpressionException;
import exception.NoSuchCommandException;
import model.Command;
import util.Validator;

import java.util.Scanner;
import java.util.regex.Pattern;

public class View {
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void printInfoMessage() {
        System.out.print(ViewMessage.getFormattedMessage());
    }

    public void printCalculationResult(String result) {
        System.out.print(result + "\n\n");
    }

    public void printHistory(String history) {
        System.out.println(history);
    }

    public void printErrorMessage(String message) {
        System.out.println("\n" + message + "\n");
    }

    public void printNewLine() {
        System.out.println();
    }

    public Command commandReader() {
        try {
            String input = scanner.nextLine();
            Validator.checkIsDigit(input);
            return Command.getCommand(input);
        } catch (RuntimeException e) {
            throw new NoSuchCommandException("[ERROR] 잘못된 명령어를 입력하셨습니다.");
        }
    }

    public String expressionReader() {
        try {
            String expression = removeWhiteSpace(scanner.nextLine());
            checkIsValidExpression(expression);
            return expression;
        } catch (IllegalExpressionException e) {
            throw new IllegalExpressionException("[ERROR] 잘못된 연산식입니다.");
        }
    }

    private String removeWhiteSpace(String input) {
        return input.replaceAll(" ", "");
    }

    private void checkIsValidExpression(String expression) {
        if (!Pattern.matches("^\\d+([+\\-*/]\\d+)*$", expression)) {
            throw new IllegalExpressionException("[ERROR] 잘못된 연산식입니다.");
        }
    }
}
