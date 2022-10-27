package calculator.view.input;

import java.util.InputMismatchException;

import static calculator.view.exception.MenuInputException.MENU_INPUT_NULL_EXCEPTION;
import static calculator.view.util.regex.RegexInputUtil.REGEX_MENU_INPUT;
import static calculator.view.util.regex.RegexInputUtil.checkWrong;

public class MenuInput implements BaseInput {

    public Long askMenuId() {
        String menuId = read();
        if (checkWrong(REGEX_MENU_INPUT, menuId)) {
            throw new InputMismatchException(MENU_INPUT_NULL_EXCEPTION.getMessage());
        }
        return Long.parseLong(menuId);
    }
}
