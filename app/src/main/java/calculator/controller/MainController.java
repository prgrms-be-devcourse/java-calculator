package calculator.controller;

import static calculator.entity.Menu.getSelectedMenu;
import static calculator.validation.MenuInputValidator.validateIsNumericMenuInput;
import static calculator.view.InputView.readLine;
import static calculator.view.OutputView.printMultiple;
import static calculator.view.OutputView.printWithLineBreak;
import static calculator.view.OutputView.printWithoutLineBreak;

import calculator.entity.Menu;

public class MainController {

    private static final String MENU_INPUT_MESSAGE = "메뉴를 입력해주세요(숫자만 입력) : ";
    private static final String QUIT_MESSAGE = "프로그램을 종료합니다.";

    public void run() {
        Menu selectedMenu = null;

        do {
            try {
                showMenu();
                int menuNumber = selectMenuNumber();
                selectedMenu = getSelectedMenu(menuNumber);
            } catch (Exception e) {
                printWithLineBreak(e.getMessage());
            }
        } while (selectedMenu != Menu.QUIT);

        printWithLineBreak(QUIT_MESSAGE);
    }

    private void showMenu() {
        printMultiple(Menu.values());
        printWithLineBreak();
    }

    private int selectMenuNumber() {
        printWithoutLineBreak(MENU_INPUT_MESSAGE);
        String menuInput = readLine().trim();
        validateIsNumericMenuInput(menuInput);
        return Integer.parseInt(menuInput);
    }
}
