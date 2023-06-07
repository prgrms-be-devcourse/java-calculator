package calculator.domain.model;

import calculator.error.exception.WrongInputMenuException;
import calculator.error.model.ResponseErrorFormat;

import java.util.Arrays;

public enum Menu {

    FIND_ONE("조회", "1"),
    CALCULATION_TWO("계산", "2"),
    EXIT_THREE("종료", "3"),
    OTHER("없는 메뉴", ""),
    ;

    private String name;
    private String number;

    Menu(String name,
         String number) {
        this.name = name;
        this.number = number;
    }

    public static Menu from(String number) {
        return Arrays.stream(values())
                .filter(menu -> menu.number.equals(number))
                .findFirst()
                .orElse(OTHER);
    }

    public boolean isFindOne() {

        return this.equals(FIND_ONE);
    }

    public boolean isCalculationTwo() {

        return this.equals(CALCULATION_TWO);
    }

    public boolean isExitTree() {

        return this.equals(EXIT_THREE);
    }

    public boolean isOther(){

        return this.equals(OTHER);
    }
}
