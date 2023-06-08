package com.bona.javacalculator;

import com.bona.javacalculator.io.Console;
import com.bona.javacalculator.service.CalService;

public class Calculator implements Runnable{

    @Override
    public void run() {
        boolean isRun = true;
        Console console = new Console();
        CalService calService = new CalService();

        while(isRun){
            String input = console.input("1. 조회 2. 계산");
            int number = parse(input);

            switch (number) {
                case 1:
                    calService.inquiry();
                    break;
                case 2:
                    calService.calculate();
                    break;
                default:
                    isRun = false;
                    break;
            }

        }
    }

    private int parse(String input) {
        return Integer.parseInt(input);
    }
}
