package calculator.view.output;

import calculator.menu.Menus;

import java.util.Arrays;
import java.util.stream.Collectors;

import static calculator.view.output.TextUnit.*;

public class MenuOutput implements BaseOutput {

    private static final String MENU_SELECTED_SIGN = "선택 : ";

    public void printSelectedSign() {
        print(MENU_SELECTED_SIGN + ENTER.unit);
    }

    public void printMenus() {
        print(createMenus() + ENTER.unit);
    }

    private String createMenus() {
        return Arrays.stream(Menus.values())
                .map(menu -> menu.getId()
                        + DOT.unit
                        + SPACE.unit
                        + menu.getTitle()
                        + ENTER.unit
                ).collect(Collectors.joining());
    }
}
