package com.programmers.java;


import com.programmers.java.io.Input;
import com.programmers.java.io.Output;

import java.util.ArrayList;
import java.util.List;

public class Computer implements Runnable{
    Input input;
    Output output;
    Calculator calculator = new Calculator();
    List<String> db = new ArrayList<>();

    @Override
    public void run() {
        while(true){
            String option = input.chooseOpt();
            int optNum = parseOption(option);
            mainJob(optNum);
        }
    }

    private void mainJob(int optNum) {
        if(optNum == 1){
            select();
        }
        else if(optNum == 2){
            String inputStr = input.input();
            int answer = calculator.calculate(inputStr);
            db.add(String.format("%s = %s", inputStr, answer));
        }
    }

    private void select() {
        for(String s: db){
            System.out.println(s);
        }
    }

    private int parseOption(String option){
        long length = option.chars().filter(Character::isDigit).distinct().count();
        if(length != 1){
            return -1;
        }
        return Character.getNumericValue(option.charAt(0));
    }

}
