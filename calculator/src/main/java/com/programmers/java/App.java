package com.programmers.java;

import com.programmers.java.application.Console;
import com.programmers.java.application.config.TokenValidator;
import com.programmers.java.application.config.Validator;
import com.programmers.java.application.exception.*;
import com.programmers.java.engine.Menu;
import com.programmers.java.engine.calculator.Calculator;
import com.programmers.java.engine.calculator.CalculatorImpl;
import com.programmers.java.engine.history.HistoryInMemoryInterface;
import com.programmers.java.engine.history.HistoryRepository;
import com.programmers.java.engine.model.MenuType;
import com.programmers.java.engine.option.CalculatorOption;
import com.programmers.java.engine.option.HistoryOption;
import com.programmers.java.engine.option.Option;

public class App {
    private static Console console = new Console();
    private static HistoryRepository historyRepository = new HistoryInMemoryInterface();
    private static Validator validator = new TokenValidator();
    private static Calculator calculator = new CalculatorImpl(validator);
    private static Menu menu = new Menu();
    private static Option option;

    public static void main(String[] args) throws Exception {
        while (true) {
            // input option
            String inputOption = console.input(
                    "1. 조회\n" +
                            "2. 계산\n" +
                            "3. 종료\n" +
                            "\n" +
                            "선택 : "
            );

            MenuType menuType;
            try {
                menuType = MenuType.findMenuType(inputOption);
            } catch (UnknownOptionException exception) {
                console.input("1, 2, 3 중에 입력해주세요.\n\n");
                continue;
            }

            if (menuType == MenuType.HISTORY) option = new HistoryOption(console, historyRepository);
            else if (menuType == MenuType.CALCULATE) option = new CalculatorOption(console, historyRepository, calculator);
            else if (menuType == MenuType.EXIT) break;
            else break;

            try {
                menu.processMenu(option);
            } catch (Exception exception) {
                System.out.println("유효한 식이 아닙니다.\n");
            }
        }
    }
}
