package calculator.view;

import calculator.validation.exception.ExpressionInputException;
import calculator.validation.exception.MenuInputException;
import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NUMERIC_REGEX = "\\d+";
    private static final String EXPRESSION_REGEX = "^\\d+(\\s[+\\-*/]\\s\\d+)*";
    private static final String NOT_NUMERIC_MENU_INPUT_MESSAGE = "메뉴는 숫자만 입력 가능합니다.";
    private static final String INVALID_EXPRESSION_MESSAGE = "올바르지 않은 계산식이 입력되었습니다.";

    private InputView() {
    }

    public static int inputMenuNumber() {
        String menuInput = readLineWithTrimming();
        validateMenuInput(menuInput);

        return Integer.parseInt(menuInput);
    }

    public static String inputExpression() {
        String expression = readLineWithTrimming();
        validateExpression(expression);

        return expression;
    }

    private static String readLineWithTrimming() {
        return readLine().trim();
    }

    private static String readLine() {
        return SCANNER.nextLine();
    }

    private static void validateMenuInput(String menu) {
        if (!menu.matches(NUMERIC_REGEX)) {
            throw new MenuInputException(NOT_NUMERIC_MENU_INPUT_MESSAGE);
        }
    }

    private static void validateExpression(String infixExpression) {
        if (!infixExpression.matches(EXPRESSION_REGEX)) {
            throw new ExpressionInputException(INVALID_EXPRESSION_MESSAGE);
        }
    }
}
