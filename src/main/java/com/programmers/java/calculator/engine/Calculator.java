package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.io.Console;
import com.programmers.java.calculator.engine.model.MenuNums;


public class Calculator implements Runnable{

    // private final Scanner scanner = new Scanner(System.in);
    private final Console console;
    private CalculatorEngine calculation = new CalculatorEngine();
    private History history = new History();
    private MenuNums menuNums;

    public Calculator(Console console) {
        this.console = console;
    }

    @Override
    public void run() {
        while(true){
            console.printMenu();
            int menuNum = console.inputNum();

            switch (MenuNums.getSelectedNum(menuNum)){
                case RECORD:
                    history.printRecords();
                    break;
                case CALCULATE:
                    console.inputBuffer();
                    String form = console.inputExpression();

                    try{
                        calculation.start(form);
                    }
                    catch (IllegalArgumentException ie){
                        console.printExceptionMsg(ie.getMessage());
                    }

                    break;
                case EXIT:
                    return;
                case NOTVALID:
                    console.printError("잘못된 범위의 선택입니다.");
                    continue;
            }
        }
    }

}
