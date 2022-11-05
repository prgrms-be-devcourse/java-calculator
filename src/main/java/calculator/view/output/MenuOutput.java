package calculator.view.output;

import calculator.menu.Menus;

import java.util.Arrays;
import java.util.stream.Collectors;

import static calculator.view.output.TextUnit.*;

public class MenuOutput implements BaseOutput {

    private static final String MENU_SELECTED_SIGN = "선택 : ";

    public void printSelectedSign() {
        print(MENU_SELECTED_SIGN);
    }

    public void printMenus() {
        print(createMenus() + ENTER.getUnit());
    }

    private String createMenus() {
        return Arrays.stream(Menus.values())
                .map(menu -> menu.getId()
                        + DOT.getUnit()
                        + SPACE.getUnit()
                        + menu.getTitle()
                        + ENTER.getUnit()
                ).collect(Collectors.joining());
    }

    public void printAfter() {
        print(ENTER.getUnit());
    }
}
