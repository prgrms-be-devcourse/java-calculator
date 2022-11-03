package calculator.view.input;

import java.util.InputMismatchException;

import static calculator.view.exception.MenuInputException.MENU_INPUT_NULL_EXCEPTION;
import static calculator.view.util.regex.RegexInputUtil.checkWrong;

public class MenuInput implements BaseInput {

    public int askMenuId() {
        String menuId = read();
        if (checkWrong(menuId)) {
            throw new InputMismatchException(MENU_INPUT_NULL_EXCEPTION.getMessage());
        }
        return Integer.parseInt(menuId);
    }
}
