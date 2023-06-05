package calulator.view;

import calulator.domain.Menu;

import java.util.Scanner;

public class InputView {

    private static final String SELECT_MESSAGE = "선택 : ";
    private static final String BLANK_REGEX = "//s";
    private static final String NONE_SPACE_REGEX = "";
    private final Scanner scanner = new Scanner(System.in);

    public Menu inputMenu() {
        System.out.println(Menu.menuInfo());
        System.out.printf(SELECT_MESSAGE);
        return Menu.findMenu(inputLineWithoutBlank());
    }

    public String inputExpression() {
        return inputLineWithoutBlank();
    }

    private String inputLineWithoutBlank() {
        return scanner.nextLine().replaceAll(BLANK_REGEX, NONE_SPACE_REGEX);
    }

}
