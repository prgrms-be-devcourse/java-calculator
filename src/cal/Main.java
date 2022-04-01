package src.cal;

import src.cal.calculator.Calculator;
import src.cal.console.Console;
import src.cal.storage.MemoryStorage;

public class Main {
    public static void main(String[] args) {
        Console myConsole = new Console();
        Calculator myCal = new Calculator();
        MemoryStorage myStorage = new MemoryStorage();

        int menuNum = 1;
        String userInputedStr = "";
        boolean isCorrectNum = false;

        while(true) {
            myConsole.initialMenu();
            userInputedStr = myConsole.next();
            isCorrectNum = myConsole.validateMenuUserInputedStr(userInputedStr);
            if (isCorrectNum == false) {
                myConsole.validateWarningMessage();
                continue;
            }
            menuNum = Integer.parseInt(userInputedStr);

            if (menuNum == 1) {
                for (String calResult : myStorage.getAll()) {
                    System.out.println(calResult);
                }

            } else if (menuNum == 2) {
                double calResult = 0;
                String expression = myCal.nextLine();
                calResult = myCal.compute(expression);
                System.out.println(calResult);

                myStorage.add(expression, calResult);
            }
        }
    }
}
