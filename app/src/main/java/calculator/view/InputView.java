package calculator.view;

import calculator.validation.exception.MenuInputException;
import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NUMERIC_REGEX = "\\d+";
    private static final String NOT_NUMERIC_MENU_INPUT_MESSAGE = "메뉴는 숫자만 입력 가능합니다.";

    private InputView() {
    }

    public static int inputMenuNumber() {
        String menuInput = readLine().trim();
        validateMenuInput(menuInput);

        return Integer.parseInt(menuInput);
    }

    public static String readLine() {
        return SCANNER.nextLine();
    }

    private static void validateMenuInput(String menu) {
        if (!menu.matches(NUMERIC_REGEX)) {
            throw new MenuInputException(NOT_NUMERIC_MENU_INPUT_MESSAGE);
        }
    }
}
