package calculator.view;

import static calculator.view.OutputView.showMenu;

import calculator.validation.exception.MenuInputException;
import java.util.Scanner;

public final class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String NUMERIC_REGEX = "\\d+";
    private static final String NOT_NUMERIC_MENU_INPUT_MESSAGE = "메뉴는 숫자만 입력 가능합니다.";

    private InputView() {
    }

    public static int inputMenuNumber() {
        showMenu();
        String menuInput = readLine().trim();
        validateIsNumericMenuInput(menuInput);

        return Integer.parseInt(menuInput);
    }

    public static String readLine() {
        return SCANNER.nextLine();
    }

    private static void validateIsNumericMenuInput(String menuInput) {
        if (!menuInput.matches(NUMERIC_REGEX)) {
            throw new MenuInputException(NOT_NUMERIC_MENU_INPUT_MESSAGE);
        }
    }
}
