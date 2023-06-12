package com.bona.javacalculator;

import com.bona.javacalculator.io.Console;
import com.bona.javacalculator.service.*;

public class Calculator implements Runnable{
    CalculateService calculateService = new CalculateService();
    InquiryService inquiryService = new InquiryService();
    private final Console console = new Console();
    @Override
    public void run() {
        boolean isRun = true;

        while(isRun){
            String input = console.input("1. 조회 2. 계산");
            int number = parse(input);
            Option option = Option.valueOf(number);

            if (option == null) {
                continue;
            }

            switch (option) {
                case INQUIRY:
                    inquiryService.inquiry();
                    break;
                case CALCULATE:
                    calculateService.calculate();
                    break;
                default:
                    break;
            }
        }
    }

    private int parse(String input) {
        return Integer.parseInt(input);
    }

}
