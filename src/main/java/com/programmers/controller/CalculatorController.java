package com.programmers.controller;

import com.programmers.domain.Menu;
import com.programmers.view.Input;
import com.programmers.view.Output;

public class CalculatorController {

    public void run(){
        Menu menu;
        do{
            Output.printMenu();

            int menuNum = Input.inputMenu();

            menu = Menu.getMenu(menuNum);

            if(menu.isHistory()){
                //todo : map에서 출력
            }
            if(menu.isCalculate()){
                System.out.println(Input.inputExpression());
            }

        }while(!menu.isFinish());
    }
}
