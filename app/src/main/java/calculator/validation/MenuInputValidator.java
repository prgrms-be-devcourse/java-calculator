package calculator.validation;

import calculator.entity.Menu;
import calculator.validation.exception.MenuInputException;

public class MenuInputValidator {

    private static final String MENU_INPUT_REGEX = "\\d+";
    private static final String NOT_NUMERIC_MENU_INPUT_MESSAGE = "메뉴는 숫자만 입력 가능합니다.";
    private static final String NOT_EXIST_MENU_MESSAGE = "존재하지 않는 메뉴입니다.";

    public static void validateIsNumericMenuInput(String menuInput) {
        if (!menuInput.matches(MENU_INPUT_REGEX)) {
            throw new MenuInputException(NOT_NUMERIC_MENU_INPUT_MESSAGE);
        }
    }

    public static void validateIsExistedMenu(Menu selectedMenu) {
        if (selectedMenu == null) {
            throw new MenuInputException(NOT_EXIST_MENU_MESSAGE);
        }
    }
}
