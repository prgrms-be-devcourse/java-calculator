package view;

import exception.IllegalExpressionException;
import exception.NoSuchCommandException;
import util.CalculatorUtils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class View {
    private static final String HISTORY_MESSAGE = "1. 조회";
    private static final String CALCULATE_MESSAGE = "2. 계산";
    private static final String SELECT_MESSAGE = "선택 : ";
    private static final int ONE_LENGTH = 1;
    private static final String NORMAL_EXPRESSION = "^\\d+([+\\-*/]\\d+)*$";
    private final Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void printInfoMessage() {
        System.out.print(getFormattedMessage());
    }

    private String getFormattedMessage() {
        return HISTORY_MESSAGE + '\n' +
                CALCULATE_MESSAGE + "\n\n" +
                SELECT_MESSAGE;
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

            return Command.resolveCommand(CalculatorUtils.parseStringToInteger(input));
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
        if (expression.length() == ONE_LENGTH || !Pattern.matches(NORMAL_EXPRESSION, expression)) {
            throw new IllegalExpressionException("[ERROR] 잘못된 연산식입니다.");
        }
    }
}
