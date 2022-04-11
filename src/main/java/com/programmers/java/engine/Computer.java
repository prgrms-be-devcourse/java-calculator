package com.programmers.java.engine;

import java.util.ArrayList;
import java.util.List;

import com.programmers.java.engine.io.Input;
import com.programmers.java.engine.io.Output;

public class Computer implements Runnable{
    Input input;
    Output output;
    Calculator calculator;
    List<String> db = new ArrayList<>();
    private final String OPTION_MESSAGE = "1. 조회\n2. 계산\n\n선택 : ";

    public Computer(Input input, Output output){
        this.input = input;
        this.output = output;
        calculator = new Calculator();
    }

    @Override
    public void run() {
        while(true){
            String option = input.chooseOpt(OPTION_MESSAGE);
            try{
                int optNum = parseOption(option);
                mainJob(optNum);
            }

            catch(NumberFormatException e){
                output.inputError();
            }
            catch(ArithmeticException e){
                output.error(e.getMessage());
            }
        }
    }

    private void mainJob(int optNum) {
        if(optNum == 1){
            select();
        }
        else if(optNum == 2){
            String inputStr = input.input();
            Double answer = calculator.calculate(inputStr);
            output.output(String.valueOf(answer));
            db.add(String.format("%s = %s", inputStr, answer));
        }
    }

    private void select() {
        for(String s: db){
            output.output(s);
        }
        output.output("");
    }

    private int parseOption(String option){
        int res = Integer.parseInt(option);
        if(res < 1 || res > 2){
            throw new IllegalArgumentException("option의 범위에서 벗어납니다.");
        }
        return res;
    }
}
