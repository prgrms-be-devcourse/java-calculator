package com.programmers.java.engin;

import com.programmers.java.engin.io.Calculation;
import com.programmers.java.engin.io.Input;
import com.programmers.java.engin.io.Output;
import com.programmers.java.engin.model.Log;
import com.programmers.java.engin.model.LogGroups;

import java.util.ArrayList;
import java.util.List;


public class Calculator implements Runnable{

    private final Calculation calculation;
    private final Input input;
    private final Output output;
    private final LogGroups logGroups;

    static final String NEWLINE = System.lineSeparator();

    public Calculator(Calculation calculation, Input input, Output output, LogGroups logGroups) {
        this.calculation = calculation;
        this.input = input;
        this.output = output;
        this.logGroups = logGroups;
    }


    @Override
    public void run() {
        Boolean running = true;
        while(running){
            String inputMenu = input.input("1. 조회"+NEWLINE+"2. 계산"+NEWLINE+NEWLINE+"선택 : ");

            switch (inputMenu){
                case "1" -> output.logsView(logGroups.getAllLogs());
                case "2" -> {
                    String expression = input.input();
                    runCalculation(expression);
                }
                case "-1" -> running = false;
                default -> output.errorMessage("잘못된 입력입니다. 메뉴를 다시 선택해주세요.");
            }

        }
    }

    private void runCalculation(String expression){
        try{
            String result = calculation.getResult(expression);
            logGroups.insertLog(new Log(expression ,result));
            output.answer(result);
        }catch (Exception error){
            output.errorMessage(error.getMessage());
        }
    }

}
