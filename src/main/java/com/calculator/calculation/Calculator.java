package com.calculator.calculation;

import com.calculator.io.Console;

public class Calculator {
    private Console console = new Console();
    private HistoryManager historyManager = new HistoryManager();
    public void run(){

        while(true){
            console.printMenu();
            String menuOption = console.getMenuOption();
            if (OptionValidator.validate(menuOption)){
                if (menuOption.equals("2")){
                    String expression = console.getExpression();


                    PostfixConverter postfixConverter = new PostfixConverter();
                    postfixConverter.convertToPostfix(expression);

                    PostfixCalculator postfixCalculator = new PostfixCalculator();
                    int result = postfixCalculator.calculatePostfix(postfixConverter.getPostfix());

                    historyManager.addHistory(expression, result);
                    System.out.println(result);
                }
                else if(menuOption.equals("1")){
                    historyManager.printHistory();
                }
                else if(menuOption.equals("3")) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }
            }
            else{
                break;
            }
        }
    }
}
