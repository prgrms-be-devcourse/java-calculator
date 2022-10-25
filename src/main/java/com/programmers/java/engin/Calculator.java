package com.programmers.java.engin;

import com.programmers.java.Console;
import com.programmers.java.engin.io.Calculation;
import com.programmers.java.engin.io.Input;
import com.programmers.java.engin.io.Output;
import com.programmers.java.engin.model.Logs;

import java.util.Optional;


public class Calculator implements Runnable{

    private Calculation calculation;
    private Input input;
    private Output output;

    public Calculator(Calculation calculation, Input input, Output output) {
        this.calculation = calculation;
        this.input = input;
        this.output = output;
    }


    @Override
    public void run() {

        Logs logs = new Logs(); // run 메소드 안에 있는게 맞나 

        while(true){
            String inputMenu = input.input("1. 조회\n2. 계산\n\n선택 : ");

            if (inputMenu.equals("1")){
                output.logView(logs);
            } else if (inputMenu.equals("2")) {
                String expression = input.input();
                Optional<String> result = calculation.getResult(expression);
                if (result.isEmpty()){
                    output.errorMessage("잘못된 입력입니다.");
                    continue;
                }
                logs.add(expression + " = " + result.get());
                output.answer(result.get());
            } else if (inputMenu.equals("-1")) {
                break;
            } else {
                output.errorMessage("잘못된 입력입니다.");
            }

        }
    }

}
