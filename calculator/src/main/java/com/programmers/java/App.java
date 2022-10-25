package com.programmers.java;

import com.programmers.java.application.Console;
import com.programmers.java.application.Operator;
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
    private static Operator operator = new Operator();
    private static HistoryRepository historyRepository = new HistoryInMemoryInterface();
    private static Calculator calculator = new CalculatorImpl(operator);
    private static Menu menu = new Menu();
    private static Option option;

    public static void main(String[] args) {
        while (true) {
            // input option
            String inputOption = console.input(
                    "1. 조회\n" +
                            "2. 계산\n" +
                            "3. 종료\n" +
                            "\n" +
                            "선택 : "
            );

            MenuType menuType = MenuType.find(inputOption);

            if (menuType == MenuType.HISTORY) option = new HistoryOption(console, historyRepository);
            else if (menuType == MenuType.CALCULATE) option = new CalculatorOption(console, historyRepository, calculator);
            else if (menuType == MenuType.EXIT) break;
            else break;

//            new Menu(console, calculator, historyRepository, option).run();
            menu.processMenu(option);
        }
    }
}
