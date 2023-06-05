package com.programmers.calculator;

import com.programmers.exception.WrongInputMenuException;
import com.programmers.io.Console;

public class Calculator {
    boolean power = true;
    public void run() {
        while(power) {
            Console.printMenu();
            MenuType menu = makeMenuType(Console.inputMenuNumber());

            switch(menu){
                case EXIT:
                    power = false;
                    Console.printExit();
                    break;
            }
        }
    }

    private MenuType makeMenuType(String inputMenuNumber) {
        MenuType menu = null;
        try {
            menu = MenuType.findMenuType(inputMenuNumber);
        } catch (WrongInputMenuException e) {
            Console.printError(e.getMessage());
        }
        return menu;
    }
}
