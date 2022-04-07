package calculator;

import calculator.engine.io.Input;
import calculator.engine.io.Output;
import calculator.engine.model.Menu;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Console implements Input, Output {
    private final Scanner scanner = new Scanner(System.in);

    private final String MENU_INPUT_TEXT = "\n1. 조회\n2. 계산\n(1, 2 이외의 문자를 입력하면 종료됩니다.)\n\n\n선택 :";
    private final String ARITH_INPUT_TEXT = "계산식을 입력해주세요: ";

    @Override
    public Optional<Menu> inputMenu() {
        System.out.println(MENU_INPUT_TEXT);
        String input = scanner.nextLine();
        return Menu.getMenu(input);
    }

    @Override
    public String inputArith() {
        System.out.println(ARITH_INPUT_TEXT);
        return scanner.nextLine();
    }

    @Override
    public void calcResult(double result) {
        System.out.println(String.format("%.3f", result));
    }

    @Override
    public void calcHistory(ArrayList<String> histories) {
        for (String s : histories) {
            System.out.println(s);
        }
    }
}
