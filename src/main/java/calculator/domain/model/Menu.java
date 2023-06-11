package calculator.domain.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Menu {
    FIND("1", "조회"),
    CALCULATION("2", "계산"),
    EXIT("3", "종료"),
    OTHER("", "없는 메뉴"),
    ;

    private String number;
    private String name;

    private static final Map<String, Menu> menus =
            Collections.unmodifiableMap(Arrays.stream(values())
                    .collect(Collectors.toMap(Menu::getNumber, Function.identity())));

    Menu(String number,
         String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public boolean isFind() {
        return this.equals(FIND);
    }

    public boolean isCalculation() {
        return this.equals(CALCULATION);
    }

    public boolean isExit() {
        return this.equals(EXIT);
    }

    public boolean isOther(){
        return this.equals(OTHER);
    }

    public static Menu from(String menuNumber) {
        return Optional.ofNullable(menus.get(menuNumber))
                .orElse(OTHER);
    }
}
