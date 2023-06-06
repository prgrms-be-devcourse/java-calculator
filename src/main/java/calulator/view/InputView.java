package calulator.view;

import calulator.domain.Menu;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputView {

    private static final String SELECT_MESSAGE = "선택 : ";
    private static final String BLANK_REGEX = "//s";
    private static final String NONE_SPACE_REGEX = "";
    private static final String EXPRESSION_REGEX = "^-?\\d+([+\\-*/]-?\\d+)*$";
    private static final String INVALID_EXPRESSION_MESSAGE = "올바른 수식이 아닙니다.";
    private final Scanner scanner = new Scanner(System.in);

    public Menu inputMenu() {
        System.out.println(Menu.menuInfo());
        System.out.print(SELECT_MESSAGE);
        return Menu.findMenu(inputLineWithoutBlank());
    }

    public String inputExpression() {
        String expression = inputLineWithoutBlank();
        Pattern pattern = Pattern.compile(EXPRESSION_REGEX);
        if (pattern.matcher(expression).matches()) {
            return expression;
        }
        throw new IllegalArgumentException(INVALID_EXPRESSION_MESSAGE);
    }

    private String inputLineWithoutBlank() {
        return scanner.nextLine().replaceAll(BLANK_REGEX, NONE_SPACE_REGEX);
    }

}
