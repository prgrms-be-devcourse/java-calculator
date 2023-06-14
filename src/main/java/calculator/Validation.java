package calculator;

import calculator.engine.enums.ConsoleMenu;

public class Validation {
    public static int checkConsoleNumber(int number){
        if (number == ConsoleMenu.ONE.MenuNumber || number == ConsoleMenu.TWO.MenuNumber) {
            return number;
        } else {
            throw new IllegalArgumentException("1번과 2번 중 하나를 선택해주세요.");
        }
    }
}
