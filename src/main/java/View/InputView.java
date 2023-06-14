package View;

import Common.IO.console.Console;

public class InputView {
    private final String MENU = "1. 조회\n2. 계산\n";
    private final String CHOICE = "선택 : ";
    private final String INVALID_INPUT = "잘못된 입력입니다.";

    public int getChoice() {
        Console.output.println(MENU);
        Console.output.print(CHOICE);
        return Console.input.getChoice();
    }

    public void wrongInput() {
        Console.output.println(INVALID_INPUT);
    }
}
