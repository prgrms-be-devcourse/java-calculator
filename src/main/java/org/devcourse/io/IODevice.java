package org.devcourse.io;


import org.devcourse.calculator.MenuType;

import java.util.List;

public interface IODevice {

    String inputMenu();
    String inputExpression();

    void outputSingleResult(String res);

    void outputList(List<String> outputList);

    // 메뉴 표출이 필요한 계산기의 경우 사용
    default void outputMenus() {

        MenuType[] menus = MenuType.values();
        for (int i = 0; i < menus.length; i++) {
            System.out.println(menus[i].getMenuName());
        }

    }
}
