package calculator.view;

import static calculator.utils.StringUtils.isMatchingExpressionRegex;
import static calculator.utils.StringUtils.isNumeric;

import calculator.exception.ExpressionInputException;
import calculator.exception.MenuInputException;
import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
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
        if (!isNumeric(menu)) {
            throw new MenuInputException(NOT_NUMERIC_MENU_INPUT_MESSAGE);
        }
    }

    private static void validateExpression(String expression) {
        if (!isMatchingExpressionRegex(expression)) {
            throw new ExpressionInputException(INVALID_EXPRESSION_MESSAGE);
        }
    }
}
