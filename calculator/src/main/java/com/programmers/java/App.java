package com.programmers.java;

import com.programmers.java.application.Console;
import com.programmers.java.application.config.TokenValidator;
import com.programmers.java.application.config.Validator;
import com.programmers.java.application.exception.UnknownOptionException;
import com.programmers.java.application.util.PostfixUtils;
import com.programmers.java.engine.Menu;
import com.programmers.java.engine.calculator.Calculator;
import com.programmers.java.engine.calculator.PostfixCalculator;
import com.programmers.java.engine.history.HistoryInMemoryRepositoryImpl;
import com.programmers.java.engine.history.HistoryRepository;
import com.programmers.java.engine.model.MenuType;
import com.programmers.java.engine.option.CalculatorOption;
import com.programmers.java.engine.option.HistoryOption;
import com.programmers.java.engine.option.Option;

public class App {
    private static Console console = new Console();
    private static HistoryRepository historyRepository = new HistoryInMemoryRepositoryImpl();
    private static Validator validator = new TokenValidator();
    private static PostfixUtils postfixUtils = new PostfixUtils();
    private static Calculator calculator = new PostfixCalculator(validator, postfixUtils);
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

            MenuType menuType = makeMenu(inputOption);
            if (menuType == null) continue;

            switch (menuType) {
                case HISTORY:
                    option = new HistoryOption(console, historyRepository);
                    break;
                case CALCULATE:
                    option = new CalculatorOption(console, historyRepository, calculator);
                    break;
                case EXIT:
                    return;
            }

            try {
                menu.processMenu(option);
            } catch (Exception exception) {
                System.out.println("유효한 식이 아닙니다.\n");
            }
        }
    }

    private static MenuType makeMenu(String inputOption) {
        MenuType menuType;
        try {
            menuType = MenuType.findMenuType(inputOption);
        } catch (UnknownOptionException exception) {
            System.out.println("\n1, 2, 3 중에 입력해주세요.\n");
            return null;
        }
        return menuType;
    }
}
