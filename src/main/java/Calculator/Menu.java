package Calculator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Menu {
    RECORD("1"), CALC("2"), EXIT("3"), ERROR("error");

    private final String manuNumber;

    public static Menu getManual (String num) {
        for (Menu menu : Menu.values()) {
            if (menu.manuNumber.equals(num)) {
                return menu;
            }
        }
        return Menu.ERROR;
    }

}
