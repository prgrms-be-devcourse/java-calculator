package com.programmers.java.engin;

import com.programmers.java.engin.io.Calculation;
import com.programmers.java.engin.io.Input;
import com.programmers.java.engin.io.Output;
import com.programmers.java.engin.model.Logs;
import lombok.AllArgsConstructor;

import java.util.List;



@AllArgsConstructor
public class Calculator implements Runnable{

    private Calculation calculation;
    private Input input;
    private Output output;

    @Override
    public void run() {

        Logs logs = new Logs(); // run 메소드 안에 있는게 맞나 

        while(true){
            String inputMenu = input.input("1. 조회\n2. 계산\n선택 : ");

            if (inputMenu.equals("1")){
                output.logView(logs);
            } else if (inputMenu.equals("2")) {
                String expression = input.input();
                int result = calculation.getResult(expression);
                logs.add(expression + " = " + result);
                output.answer(result);
            } else if (inputMenu.equals("-1")) {
                break;
            } else {
                output.errorMessage("잘못된 입력입니다.");
            }

        }
    }

}
