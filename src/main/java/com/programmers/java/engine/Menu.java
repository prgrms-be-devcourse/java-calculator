package com.programmers.java.engine;

import com.programmers.java.engine.model.Operator;

import java.util.Arrays;
import java.util.Optional;

/*
Menu : 사용자가 선택하는 메뉴
- 메뉴 옵션과 상수를 enum을 통해 한 곳에서 관리한다.
*/
public enum Menu {
    EXIT("0", "종료"),
    LOOKUP("1", "조회"),
    CALCULATE("2", "계산");

    private final String option;
    private final String prompt;

    Menu(String option, String prompt) {
        this.option = option;
        this.prompt = prompt;
    }

    @Override
    public String toString() {
        return prompt;
    }

    public static Optional<Menu> getMenu(String option) {
        return Arrays.stream(values())
                .filter(o -> o.option.equals(option))
                .findFirst();
    }
}
