package org.devcourse.calculator;

import org.devcourse.exception.MenuTypeException;
import org.devcourse.repository.Repository;

import java.util.*;

public enum MenuType {

    HISTORY(1, "1. 조회"),
    CALCULATE(2, "2. 계산"),
    EXIT(3, "3. 종료");

    private int menuNum;
    private String menuName;

    MenuType(int menuNum, String menuName) {
        this.menuNum = menuNum;
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }


    public static boolean hasMenu(int menuNum) throws MenuTypeException {

        boolean isPresent = Arrays.stream(MenuType.values())
                .anyMatch(menuType -> (menuType.menuNum == menuNum));

        if(!isPresent) {
            throw new MenuTypeException("존재하지 않는 메뉴입니다. 메뉴 번호를 숫자로 정확히 입력해주세요. [1, 2, 3]");
        } else {
            return true;
        }

    }


    public static MenuType findByMenuNum(int menuNum) throws MenuTypeException {

            return Arrays.stream(MenuType.values())
                    .filter(menuType -> (menuType.menuNum == menuNum))
                    .findAny()
                    .orElseThrow(() -> new MenuTypeException("존재하지 않는 메뉴입니다. 메뉴 번호를 숫자로 정확히 입력해주세요. [1, 2, 3]"));

    }



}

