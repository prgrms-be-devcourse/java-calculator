package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.Console;
import com.programmers.java.calculator.engine.model.MenuNums;

import java.util.Scanner;


public class Calculator implements Runnable{

    private final Scanner scanner = new Scanner(System.in);
    private CalculatorEngine calculation = new CalculatorEngine();
    private History history = new History();
    private MenuNums menuNums;

    //TODO : 콘솔 리팩토링 필요
    @Override
    public void run() {
        while(true){
            Console.printMenu();
            int menuNum = scanner.nextInt();

            switch (MenuNums.getSelectedNum(menuNum)){
                case RECORD:
                    history.printRecords();
                    break;
                case CALCULATE:
                    scanner.nextLine();
                    String form = scanner.nextLine();
                    calculation.start(form);
                    break;
                case EXIT:
                    return;
                case NOTVALID:
                    System.out.println("잘못된 범위의 선택입니다.");
                    continue;
            }
        }
    }

}
