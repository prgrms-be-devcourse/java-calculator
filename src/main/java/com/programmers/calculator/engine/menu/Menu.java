package com.programmers.calculator.engine.menu;

import com.programmers.calculator.utils.InputException;

import java.util.Arrays;
import java.util.function.Function;

public enum Menu {
    //조회
//    LOOKUP("1", (formula, result) -> new 조회로직),
    LOOKUP("1"),

    //계산
//    CALCULATION("2", (null, history) -> new 계산로직),
    CALCULATION("2"),

    //종료
    END("3");

    private String commandInput;
//    private Function<String, String> userMenu;

//    Menu(String commandInput, Function<String, String> userMenu) {
//        this.commandInput = commandInput;
//        this.userMenu = userMenu;
//    }

    Menu(String commandInput) {
        this.commandInput = commandInput;
    }

    @Override
    public String toString() {
        return commandInput;
    }

    public static String chooseMenu(String commandInput) {
        return getMenu(commandInput).toString();
        //여기서 바로 menu 메서드를 호출할 수 있는지?? Function<> 으로 됩니까?
    }

    private static Menu getMenu(String command) {
        return Arrays.stream(values())
                .filter(o -> o.commandInput.equals(command))
                .findFirst().orElseThrow(() -> new RuntimeException(new InputException("없는 메뉴 선택")));
    }
}
